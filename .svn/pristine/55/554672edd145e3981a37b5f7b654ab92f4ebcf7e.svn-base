/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUser;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecPrivilegeUserDao extends BaseIbatis3Dao<SecPrivilegeUser, java.lang.String> {
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    @Override
    public Class getEntityClass() {
        return SecPrivilegeUser.class;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(SecPrivilegeUser entity) {
        if (entity.getLoginId() == null)
            save(entity);
        else
            update(entity);
    }
    
    /**
     * 分页查询.
     * 
     * @param pageRequest
     *            查询参数.
     * @return page.
     */
    public Page findByPageRequest(PageRequest pageRequest) {
        return pageQuery("SecPrivilegeUser.pageSelect", pageRequest);
    }
    
    public SecPrivilegeUser getByLoginName(java.lang.String v) {
        return (SecPrivilegeUser) getSqlSession().selectOne("SecPrivilegeUser.getByLoginName", v);
    }
    
    public boolean existLoginName(SecPrivilegeUser secPrivilegeUser) {
        long count = (Long) this.getSqlSession().selectOne(this.getCountQuery(), secPrivilegeUser);
        if (count > 0) {
            return true;
        }
        return false;
    }
    
    public List<SecPrivilegeUser> findUserByLoginNameAndPd(SecPrivilegeUser secPrivilegeUser) {
        return this.getSqlSession().selectList("SecPrivilegeUser.findByLoginNameAndPd", secPrivilegeUser);
    }
    
    /**
     * @description 根据节点得到该节点相应的审批人列表
     * @return List<SecPrivilegeUser>
     */
    public List<SecPrivilegeUser> getUserListByDeptAndRole(Map map) {
        return this.getSqlSession().selectList("SecPrivilegeUser.getUserListByDeptAndRole", map);
    }
    /**
     * 根据流程ID修改所属用户.
     *
     * @param 实体.
     * @return int.
     */
    public int updatePassword(SecPrivilegeUser entity) {
        return getSqlSession().update("SecPrivilegeUser.updatePassword", entity);
    }
    
    /**
     * @description 用于得到登录用户所在部门信息
     * @param loginName
     * @return 用户详细信息list
     */
    public List<SecPrivilegeUser> findUserDeptInfoByLoginName(String loginName) {
        return this.getSqlSession().selectList("SecPrivilegeUser.findUserDeptInfoByLoginName", loginName);
    }
    

}
