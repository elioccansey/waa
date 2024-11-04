package com.eli.logging;

import com.eli.exception.AppExceptionLog;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
@RequiredArgsConstructor
public class LogAspect {

    private final LogService logService;

    @Pointcut("@annotation(executionTime)")
    public void loggingPointcut(ExecutionTime executionTime){}

    @Pointcut("within(com.eli..*) ")
    public void logExceptionPC(){}

    @Around(value = "logExceptionPC()")
    public Object logExceptionAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        }catch (Throwable ex){
            long execTime = System.currentTimeMillis() - start;
            AppExceptionLog.builder()
                    .executionTime(execTime)
                    .dateTime(LocalDateTime.now())
                    .operation(proceedingJoinPoint.getSignature().toShortString())
                    .principle("SystemUser")
                    .exceptionType(ex.getClass().getSimpleName())
                    .build();
            throw ex;
        }
    }

    @Around("loggingPointcut(executionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint, ExecutionTime executionTime) throws Throwable {

        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long execTime = System.currentTimeMillis() - start;

        Log newLog = Log.builder()
                .executionTime(execTime)
                .dateTime(LocalDateTime.now())
                .operation(proceedingJoinPoint.getSignature().getName())
                .principle("SimpleUser")
                .build();
        logService.createLog(newLog);
        return  result;
    }


}
