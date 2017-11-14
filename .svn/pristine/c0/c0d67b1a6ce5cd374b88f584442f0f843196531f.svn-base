/*
 * Copyright 2001-2008 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.log;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.uk.sec.framework.interceptor.LogInterceptor;


/**
 * 配合LogInteceptor. 用于日志记入数据库
 * 
 * @author Administrator
 * @see LogInterceptor
 */
public class LogController {
    
    public static final String PRIORITY_INFO  = "info";
    public static final String PRIORITY_ERROR = "error";
    public static final String PRIORITY_WARN  = "warn";
    
    public static final String PROJECT_LOG    = "projectlog";
    public static final String LOGIN_ID       = "loginId";
    public static final String LOGIN_NAME     = "loginName";
    public static final String MODEL          = "model";
    public static final String TITLE          = "title";
    public static final String METHODE_DESC   = "methode_desc";
    
    /**
     * 日志保存
     * 
     * @param model
     *            日志记录的模块
     * @param title
     *            日志记录的标题
     * @param method
     *            日志记录的方法
     * @param priority
     *            日志记录优先级
     */
    public static void log(String model, String title, String method, String msg, String priority) {
        Log log = LogFactory.getLog(PROJECT_LOG);
        // 设置日志记录的各参数
        org.apache.log4j.MDC.put(MODEL, model);
        org.apache.log4j.MDC.put(TITLE, title);
        org.apache.log4j.MDC.put(METHODE_DESC, method);
        // 根据日志级别记录日志信息
        if (PRIORITY_INFO.equals(priority)) {
            log.info(msg);
        } else if (PRIORITY_ERROR.equals(priority)) {
            log.error(msg);
        } else if (PRIORITY_WARN.equals(priority)) {
            log.warn(msg);
        }
        
    }
    
}
