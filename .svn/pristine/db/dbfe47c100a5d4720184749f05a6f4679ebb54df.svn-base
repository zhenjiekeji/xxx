/**
 * 版权所有 科技有限公司 Copyright(c) 2010 All Rights Reserved Project: waite
 * Author: 许振伟 Create Date: 2015-01-14下午05:40:30 Update Date: 2015-01-14下午05:40:30
 * Description:
 */
package com.uk.sec.framework.security.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;

/**
 * Performs a logout by modifying the
 * {@link org.springframework.security.core.context.SecurityContextHolder}.
 * <p>
 * Will also invalidate the {@link HttpSession} if
 * {@link #isInvalidateHttpSession()} is <code>true</code> and the session is
 * not <code>null</code>.
 * 
 * @author xzw
 * @version $Id: SecurityContextLogoutHandler.java 3640 2009-05-04 14:24:54Z
 *          ltaylor $
 */
public class SecurityContextLogoutHandler implements LogoutHandler {
    private boolean invalidateHttpSession = true;
    
    // ~ Methods
    // ========================================================================================================
    
    /**
     * Requires the request to be passed in.
     * 
     * @param request
     *            from which to obtain a HTTP session (cannot be null)
     * @param response
     *            not used (can be <code>null</code>)
     * @param authentication
     *            not used (can be <code>null</code>)
     */
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Assert.notNull(request, "HttpServletRequest required");
        if (this.invalidateHttpSession) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        }
        org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices service;
        SecurityContextHolder.clearContext();
    }
    
    public boolean isInvalidateHttpSession() {
        return this.invalidateHttpSession;
    }
    
    /**
     * Causes the {@link HttpSession} to be invalidated when this
     * {@link LogoutHandler} is invoked. Defaults to true.
     * 
     * @param invalidateHttpSession
     *            true if you wish the session to be invalidated (default) or
     *            false if it should not be.
     */
    public void setInvalidateHttpSession(boolean invalidateHttpSession) {
        this.invalidateHttpSession = invalidateHttpSession;
    }
    
}
