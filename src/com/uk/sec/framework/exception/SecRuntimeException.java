/*
 * Copyright 2001-2008 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * 后台异常对象.
 * 
 * @author xzw
 */
public class SecRuntimeException extends NestedRuntimeException {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -9034361243296910141L;
    /**
     * . messageKey
     */
    private String            messageKey;
    /**
     * args.
     */
    private Object[]          args;
    
    /**
     * .
     */
    public SecRuntimeException() {
        super("");
        
    }
    
    /**
     * .
     * 
     * @param s .
     */
    public SecRuntimeException(String s) {
        super(s);
        setMessageKey(s);
    }
    
    /**
     * .
     * 
     * @param s
     *            异常信息
     * @param obj ：
     *            异常参数
     */
    public SecRuntimeException(String s, Object[] obj) {
        super(s);
        setMessageKey(s);
        setArgs(obj);
    }
    
    /**
     * .
     * 
     * @param s .
     * @param throwable .
     */
    public SecRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
        setMessageKey(s);
    }
    
    /**
     * .
     * 
     * @return messageKey.
     */
    public String getMessageKey() {
        return messageKey;
    }
    
    /**
     * .
     * 
     * @param messageKey
     *            messageKey.
     */
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
    
    /**
     * @return args.
     */
    public Object[] getArgs() {
        return args;
    }
    
    /**
     * @param args
     *            args.
     */
    public void setArgs(Object[] args) {
        this.args = args;
    }
    
}
