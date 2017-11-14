package com.uk.sec.framework.security.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.uk.sec.framework.security.model.SecUserDetails;


@SuppressWarnings("unchecked")
public abstract class AbstractUserDetailsDao implements UserDetailsService {
    
    private String loginUserName;
    
    /**
     * 为子类提供处理userName的接口
     * 
     * @param userName
     * @return
     * @author xzw
     * @see RoutingDao
     */
    public String prepare(String userName) {
        this.loginUserName = userName;
        return this.loginUserName;
    }
    
    @SuppressWarnings("deprecation")
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
        this.loginUserName = prepare(userName);
        String conversionUserName = "";
        // 用户的用户名可能是中文,须对中文进行转码
        if (!StringUtils.isBlank(this.loginUserName)) {
            // 进行转码
            try {
                conversionUserName = new String(this.loginUserName.getBytes("ISO8859_1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        
        /*
         * 下面一段代码要根据用户名conversionUserName,从系统中查询出该用户的信息,构造安全框架的UserDetails实例
         * 这里通常需要查询数据库,可以通过spring上下文获得一个实现了UserDetailsDao的bean来执行这个工作.
         */
        List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
        authsList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        SecUserDetails user = getSecUserDetailsByUsername(conversionUserName);
        if (user != null) {// 用户存在,构造UserDetails对象
            org.springframework.security.core.userdetails.User authUser = new org.springframework.security.core.userdetails.User(
                    conversionUserName, user.getPassword(), true, true, true, true, authsList);
            return authUser;
        } else {
            throw new UsernameNotFoundException("没有这个用户");
        }
    }
    
    public abstract SecUserDetails getSecUserDetailsByUsername(String userName);
}
