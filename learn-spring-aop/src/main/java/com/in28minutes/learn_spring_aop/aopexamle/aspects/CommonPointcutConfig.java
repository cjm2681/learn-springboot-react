package com.in28minutes.learn_spring_aop.aopexamle.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

	@Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexamle.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexamle.business.*.*(..))")
	public void businessPackageConfig() {}

	@Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexamle.data.*.*(..))")
	public void dataPackageConfig() {}
	
	@Pointcut("bean(*Service*)")
	public void allPackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.in28minutes.learn_spring_aop.aopexamle.annotations.TrackTime)")
	public void trackTimeAnnotation() {}
}
