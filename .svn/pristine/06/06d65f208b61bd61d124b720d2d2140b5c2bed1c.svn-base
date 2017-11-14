/*
 * Copyright 2001-2011 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xzw.
 */
public class SessionFilter implements javax.servlet.Filter {
    
    public void destroy() {
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String path = httpServletRequest.getServletPath();
        if (path.contains("mainPage.do") || path.contains("showLoginPage.do") || path.contains("loginUser.do")) {
            chain.doFilter(request, response);
        } else if (httpServletRequest.getSession().getAttribute("user_view") == null) {
            chain.doFilter(request, response);
            // httpServletResponse.sendRedirect(httpServletRequest.getContextPath()
            // + "/commons/expired_session.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
    
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
}
