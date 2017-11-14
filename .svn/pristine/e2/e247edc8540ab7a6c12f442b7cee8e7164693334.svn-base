/*
 * Copyright 2001-2008 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.exception;

import org.springframework.core.NestedCheckedException;

/**
 * .
 * 
 * @author xzw
 */
public class SecException extends NestedCheckedException {
    
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 9072184377845573954L;
    /**
     * . messageKey
     */
    private String            messageKey;
    /**
     * . args
     */
    private Object[]          args;
    
    /**
     * .
     */
    public SecException() {
        super("");
        
    }
    
    /**
     * .
     * 
     * @param s .
     */
    public SecException(String s) {
        super(s);
        setMessageKey(s);
    }
    
    /**
     * .
     * 
     * @param s .
     * @param obj .
     */
    public SecException(String s, Object[] obj) {
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
    public SecException(String s, Throwable throwable) {
        super(s, throwable);
        setMessageKey(s);
    }
    
    /**
     * .
     * 
     * @return .
     */
    public Object[] getArgs() {
        return args;
    }
    
    /**
     * .
     * 
     * @param args .
     */
    public void setArgs(Object[] args) {
        this.args = args;
    }
    
    /**
     * .
     * 
     * @return .
     */
    public String getMessageKey() {
        return messageKey;
    }
    
    /**
     * .
     * 
     * @param messageKey .
     */
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
    
}
