/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.security.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 扩展spring security的自定义登录.
 * 
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
public class SecUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    // ~ Static fields/initializers
    // =====================================================================================
    
    /**
     * 登录时的附加参数名.
     */
    public static final String SPRING_SECURITY_FORM_EXTENT_KEY = "j_extend";
    
    /**
     * 登录时的附加参数命常量. extendParameter
     */
    private String             extendParameter                 = SPRING_SECURITY_FORM_EXTENT_KEY;
    
    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        /*
         * 获得附加参数值.
         */
        String extend = obtainExtend(request);
        
        if (extend == null) {
            extend = "";
        }
        /*
         * 将附件参数放入session中.
         */
        request.getSession().setAttribute(SPRING_SECURITY_FORM_EXTENT_KEY, extend);
        /*
         * 调用父类方法,继续验证逻辑.
         */
        return super.attemptAuthentication(request, response);
    }
    
    protected String obtainExtend(HttpServletRequest request) {
        return request.getParameter(extendParameter);
    }
    
}
