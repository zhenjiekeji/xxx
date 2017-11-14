/*
 * Copyright 2001-2008 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.exception;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * 异常对象类.
 * 
 * @author xzw
 */
public class ErrorMessage {
    
    /**
     * SPLITSEPARATOR.
     */
    public static final String SPLITSEPARATOR     = "\\.";
    /**
     * BLANKSTRING.
     */
    public static final String BLANKSTRING        = "";
    /**
     * REGEXPATTERNSTRING.
     */
    public static final String REGEXPATTERNSTRING = "^[EWIF]([.][A-Za-z]+)+$";
    /**
     * DEFAULTMESSAGEKEY.
     */
    public static final String DEFAULTMESSAGEKEY  = "E.framework.core.invalidateMessagekey";
    /**
     * . message
     */
    private String             message;
    
    /**
     * messageKey.
     */
    private String             messageKey;
    
    /**
     * . messageType
     */
    private String             messageType;
    
    /**
     * 消息对象构造函数,对于有参数的异常信息需要调用该构造函数.
     * 
     * @param se :
     *            SecException
     * @param message :
     *            String
     */
    public ErrorMessage(SecException se, String message) {
        String messageKey = se.getMessageKey();
        if (se.getArgs() != null) {
            Object[] args = se.getArgs();
            this.message = MessageFormat.format(message, args);
        }
        setMessageType(getType(messageKey));
    }
    
    /**
     * 消息对象构造函数
     * 
     * @param message :
     *            消息值
     * @param messageKey
     *            ：消息键值
     */
    public ErrorMessage(String message, String messageKey) {
        this.message = message;
        this.messageKey = messageKey;
        setMessageType(getType(messageKey));
    }
    
    /**
     * 默认的空的构造函数.
     */
    public ErrorMessage() {
        
    }
    
    /**
     * .
     * 
     * @return .
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * .
     * 
     * @param message .
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * .
     * 
     * @return .
     */
    public String getMessageType() {
        return messageType;
    }
    
    /**
     * .
     * 
     * @param messageType .
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    
    /**
     * .
     * 
     * @param messageKey
     *            messageKey.
     * @return .
     */
    public String getType(String messageKey) {
        String type = BLANKSTRING;
        if (StringUtils.hasText(messageKey)) {
            Pattern pattern = Pattern.compile(REGEXPATTERNSTRING);
            Matcher matcher = pattern.matcher(messageKey);
            if (!matcher.find()) {
                messageKey = DEFAULTMESSAGEKEY;
            }
            type = messageKey.split(SPLITSEPARATOR)[0];
        }
        return type;
    }
    
    public String getMessageKey() {
        return messageKey;
    }
    
    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }
}
