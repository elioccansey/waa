package com.eli.exception;

public class PostNotFoundException extends RuntimeException {
   public PostNotFoundException(String msg){
       super(msg);
   }
}
