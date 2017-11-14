package com.uk.sec.framework.security.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.StringUtils;

import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.framework.security.filter.SecUsernamePasswordAuthenticationFilter;
import com.uk.sec.framework.security.model.UserInfo;
import com.uk.sec.framework.security.service.SecUserManager;


/**
 * 系统登录模块
 * 
 * @author xzw.
 * @version 1.0
 */
@SuppressWarnings( { "serial", "unchecked" })
public class MainAction extends BaseStruts2Action {
    /**
     * UserView对象放入session中使用的固定的key. SESSION_USER_VIEW
     */
    public static final String    SESSION_USER_VIEW = "user_view";
    /**
     * ## 系统登录页面 *
     */
    protected static final String LOGIN_JSP         = "/login.jsp";
    /**
     * ## 系统主页 *
     */
    protected static final String HOMEPAGE_JSP      = "/homepage.jsp";
    protected static final String HEAD_JSP          = "/head.jsp";
    protected static final String LEFT_JSP          = "/left.jsp";
    /**
     * 验证通过后跳转
     */
    protected static final String HOME_PAGE         = "!/homePage.do";
    
    protected static final String ERROR_PAGE        = "!/showLoginPage.do?error=2";
    protected static final String HALT_ERROR_PAGE   = "!/showLoginPage.do?error=5";
    
    /**
     * ## 没有访问权限的用户登录系统,跳转页面
     */
    protected static final String NO_PERMISSION_JSP = "/no_permission.jsp";
    /**
     * ## 用户名
     */
    private String                userName;
    private SecUserManager        secUserManager;
    
    /**
     * ## 进入登录页面
     * 
     * @return 系统登录页面
     */
    public String login() {
        Cookie[] cookies = this.getRequest().getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equalsIgnoreCase(TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY)) {
                byte[] b = Base64.decode(c.getValue().getBytes());
                String str = new String(b);
                this.userName = str.split(":")[0];
            }
        }
        return LOGIN_JSP;
    }
    
    /**
     * 进入主页面的ACTION/登录方法,经过springsecurity验证后才会进入本方法
     * 
     * @return
     * @throws Exception
     */
    public String mainPage() throws Exception {
        
        /* 随机码验证 */
        String randSession = (String) this.getRequest()
                                          .getSession()
                                          .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String checkcode = (String) this.getRequest()
                                        .getSession()
                                        .getAttribute(SecUsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_EXTENT_KEY);
        
        if ((checkcode != null) && (!checkcode.equals(randSession))) {
            if (!checkcode.equalsIgnoreCase(randSession)) {
                // return ERROR_PAGE;
            }
            
        }
        
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = "";
        if (obj instanceof UserDetails) {
            userName = ((UserDetails) obj).getUsername();
        } else {
            userName = obj.toString();
        }
        /*
         * 这里要根据userName获得用户的信息,并放入userView中,然后将userView放入session中.
         * 通常的方式使用一个manager来获得用户信息. 注册商用户 session中的信息有用户名,用户类型,注册商id 审核用户
         * session中的信息有用户名,用户类型,姓名
         */
        Map<String, String> mapData = null;
        
        if (null == secUserManager) {
            return LOGIN_JSP;
        }
        // 用户为注册商，则查询注册商表获取用户详细信息
        UserInfo userInfo = secUserManager.getSecUserInfoByUsername(userName);
        if (null == userInfo) {
            return LOGIN_JSP;
        } else {
            /*
             * 如果用户存在,将用户信息放入用户视图中,userView放入Session中.将登陆用户信息放入用户显示视图中.
             */
            mapData = new HashMap<String, String>();
            // 用户id，放入session中
            UserView userView = new UserView(userInfo);
            userView.setUserData(mapData);
            this.setUserView(userView);
        }
        return HOME_PAGE;
    }
    
    /**
     * 进入主页面的ACTION/登录方法,经过springsecurity验证
     * 
     * @return
     * @throws Exception
     */
    public String homePage() throws Exception {
        String result = HOMEPAGE_JSP;
        UserView userView = this.getUserView();
        if (userView == null) {
            result = LOGIN_JSP;
        }
        return result;
    }
    
    /**
     * 返回head.jsp
     * 
     * @return
     */
    public String head() {
        return HEAD_JSP;
    }
    
    /**
     * 返回left.jsp
     * 
     * @return
     */
    public String left() {
        return LEFT_JSP;
    }
    
    /**
     * Sets a "cancel cookie" (with maxAge = 0) on the response to disable
     * persistent logins.
     * 
     * @param request
     * @param response
     */
    public void cancelCookie() {
        Cookie cookie = new Cookie(TokenBasedRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY, null);
        cookie.setMaxAge(0);
        cookie.setPath(StringUtils.hasLength(this.getRequest().getContextPath()) ? this.getRequest().getContextPath()
                                                                                : "/");
        this.getResponse().addCookie(cookie);
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return the secUserManager
     */
    public SecUserManager getSecUserManager() {
        return secUserManager;
    }
    
    /**
     * @param secUserManager
     *            the secUserManager to set
     */
    public void setSecUserManager(SecUserManager secUserManager) {
        this.secUserManager = secUserManager;
    }
    
}
