/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;


import com.opensymphony.xwork2.interceptor.PrefixMethodInvocationUtil;
import com.uk.sec.framework.exception.SecRuntimeException;
import com.uk.sec.framework.log.LogFactory;

/**
 * manager层前置校验.
 * 
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
public class ValidationAspect {
    private static final String VALIDATE_PREFIX = "validate";
    private Logger              logger          = LogFactory.LOGGER_SERVICE;
    
    public void validate(JoinPoint joinPoint) throws Throwable {
        Object[] parameter = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        Class[] parameterTypes = new Class[parameter.length];
        for (int i = 0; i < parameter.length; i++) {
            Object o = parameter[i];
            parameterTypes[i] = o == null ? null : o.getClass();
        }
        Method invoke = getPrefixedMethod(new String[] { VALIDATE_PREFIX }, methodName, target, parameterTypes);
        if (invoke != null) {
            try {
                invoke.invoke(target, parameter);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                throw e;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw e;
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof SecRuntimeException) {
                    throw e.getCause();
                }
                e.printStackTrace();
            }
            logger.info("Manager validation : Target [" + target.getClass().getName() + "], method ["
                        + invoke.getName() + "()] is done.");
        } else {
            logger.info("Manager validation : Target [" + target.getClass().getName() + "], method [" + VALIDATE_PREFIX
                        + PrefixMethodInvocationUtil.capitalizeMethodName(methodName) + "()] is not found.");
        }
    }
    
    private static Method getPrefixedMethod(String[] prefixes, String methodName, Object target, Class[] parameterTypes) {
        assert (prefixes != null);
        String capitalizedMethodName = PrefixMethodInvocationUtil.capitalizeMethodName(methodName);
        for (String prefixe : prefixes) {
            String prefixedMethodName = prefixe + capitalizedMethodName;
            try {
                return target.getClass().getMethod(prefixedMethodName, parameterTypes);
            } catch (NoSuchMethodException e) {
            }
        }
        return null;
    }
}
