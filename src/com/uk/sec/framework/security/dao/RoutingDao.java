package com.uk.sec.framework.security.dao;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.security.model.SecUserDetails;


/**
 * @author xzw.
 * @since 1.0
 * @version 1.0
 * @see AbstractUserDetailsDao
 * @see SecUsernamePasswordAuthenticationFilter.
 */
@SuppressWarnings("unchecked")
@Component
public class RoutingDao extends AbstractUserDetailsDao {
    
    private SecUserDao secUserDao;
    
    /**
     * 分拆userName,获得附加参数和真正的用户登录名. {@inheritDoc}
     * 
     * @see cn.ac.sec.cnnic.domaininspection.framework.security.dao.AbstractUserDetailsDao#prepare(java.lang.String)
     */
    @Override
    public String prepare(String userName) {
        return userName;
    }
    
    /**
     * 覆盖父类方法,根据附加参数值调用不同的dao获取用户数据. {@inheritDoc}
     * 
     * @see cn.ac.sec.cnnic.domaininspection.framework.security.dao.AbstractUserDetailsDao#getSecUserDetailsByUsername(java.lang.String)
     */
    @Override
    public SecUserDetails getSecUserDetailsByUsername(String userName) {
        return secUserDao.getSecUserDetailsByUsername(userName);
    }
    
    /**
     * @return the secUserDao
     */
    public SecUserDao getSecUserDao() {
        return secUserDao;
    }
    
    /**
     * @param secUserDao
     *            the secUserDao to set
     */
    public void setSecUserDao(SecUserDao secUserDao) {
        this.secUserDao = secUserDao;
    }
    
}
