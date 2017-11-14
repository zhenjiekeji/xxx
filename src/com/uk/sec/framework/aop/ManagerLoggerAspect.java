/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;

import com.uk.sec.framework.log.LogFactory;


/**
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
public class ManagerLoggerAspect {
    private static final Logger logger = LogFactory.LOGGER_FRAMEWORK;
    
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        logger.info("Manager entrance : Target [" + target.getClass().getName() + "], method [" + methodName + "()].");
    }
    
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        logger.info("Manager exit : Target [" + target.getClass().getName() + "], method [" + methodName + "()].");
    }
    
    public void afterThrowing(Exception exception) {
        logger.info("Manager exception : Target [" + exception.getClass().getName() + "], message ["
                    + exception.getMessage() + "].");
    }
    
}
