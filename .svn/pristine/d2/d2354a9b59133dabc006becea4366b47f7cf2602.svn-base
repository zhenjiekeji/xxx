package com.uk.sec.framework.security.action;

import java.io.Serializable;
import java.util.Map;

import com.uk.sec.framework.security.model.UserInfo;



/**
 * 系统登录后保存用户信息,放入session
 * 
 * @since 1.0
 */
public class UserView<PK extends Serializable> implements Serializable {
    /**
     * UserView对象放入session中使用的固定的key. SESSION_USER_VIEW
     */
    public static final String  SESSION_USER_VIEW = "user_view";
    private Map<String, Object> userData;
    
    private UserInfo<PK>        userInfo;
    
    private String[]            roles;
    
    /**
     * @param userInfo
     */
    public UserView(UserInfo<PK> userInfo) {
        super();
        this.userInfo = userInfo;
    }
    
    public String[] getRoles() {
        return roles;
    }
    
    public void setRoles(String[] roles) {
        this.roles = roles;
    }
    
    public Map<String, Object> getUserData() {
        return userData;
    }
    
    public void setUserData(Map<String, Object> userData) {
        this.userData = userData;
    }
    
    public UserInfo<PK> getUserInfo() {
        return userInfo;
    }
    
    public void setUserInfo(UserInfo<PK> userInfo) {
        this.userInfo = userInfo;
    }
    
    public PK getLoginId() {
        return userInfo.getSecLoginId();
    }
    
    public String getLoginName() {
        return userInfo.getLoginName();
    }
    
    public String getLoginDisplayName() {
        return userInfo.getLoginDisplayName();
    }
    
}
