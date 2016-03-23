package com.feng.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class TestAdvice {

	
	@Before("execution(* hello(..))")
	public void beforeAdvice() {
		System.out.println("before:----------------------------------------------------------------- " );  
	}
}
