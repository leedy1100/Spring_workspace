package com.upgrade.mvc.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.upgrade.mvc.dao")
@Aspect
@Component
public class LogAop {

	@Pointcut("execution(public * com.upgrade.mvc.dao.*Dao*.*(..))")
	public void pointCut() {}
	
	@Before("pointCut()")
	public void before(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");

		logger.info("---------logger start---------");
		Object args[] = join.getArgs();
		if (args != null) {
			logger.info("Method : " + join.getSignature().getName());
			for (int i = 0; i < args.length; i++) {
				logger.info(i + "번째 : " + args[i]);
			}
		}
	}

	@After("pointCut()")
	public void after(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("---------logger end---------");

	}

	@AfterThrowing("pointCut()")
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("error : " + join.getArgs());
		logger.info("error : " + join.toString());
	}
}
