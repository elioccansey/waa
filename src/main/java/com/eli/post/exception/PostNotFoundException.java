package com.eli.post.exception;

public class PostNotFoundException extends RuntimeException {
   public PostNotFoundException(String msg){
       super(msg);
   }
}
