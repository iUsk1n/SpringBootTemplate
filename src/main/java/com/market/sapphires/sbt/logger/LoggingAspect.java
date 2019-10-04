package com.market.sapphires.sbt.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Before("execution(public * com.market.sapphires.sbt.controller..*(..))")
    private void before(JoinPoint jp) {
        log.debug(
                new StringBuilder("START: ")
                        .append(jp.getTarget().getClass().toString())
                        .append(".").append(jp.getSignature().getName()).toString());
    }

    @After("execution(public * com.market.sapphires.sbt.controller..*(..))")
    private void after(JoinPoint jp) {
        log.debug(
                new StringBuilder("END: ")
                        .append(jp.getTarget().getClass().toString())
                        .append(".").append(jp.getSignature().getName()).toString());
    }

}
