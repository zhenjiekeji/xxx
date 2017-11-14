/**
 * 版权所有 科技有限公司 Copyright(c) 2015 All Rights Reserved Project: waite
 * Author: xzw Create Date: 2015-01-10 10:46 Update Date: 2015-01-17 10:46
 * Description: 防止用户以JSP方式直接访问
 */
package com.uk.sec.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.uk.sec.framework.log.LogFactory;


/**
 * 防止用户以JSP方式直接访问
 * 
 * @since 1.0
 */
public class SecurityRejectJsp implements Filter {
    Logger log = LogFactory.LOGGER_SECURITY;
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String rul = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                     + request.getContextPath();
        this.log.info("拦截JSP直接访问,请求地址: " + request.getRequestURI());
        response.sendRedirect(rul + "/mainPage.do");
    }
    
    public void init(FilterConfig arg0) throws ServletException {
        
    }
    
    public void destroy() {
        
    }
}
