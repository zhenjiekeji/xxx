/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.uk.sec.framework.base.BaseIbatis3Dao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUserDMZ;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

/**
 * @author
 * @since 1.0
 * @version 1.0
 */
@Component
public class SecPrivilegeUserDMZDao extends BaseIbatis3Dao<SecPrivilegeUserDMZ, java.lang.String> {
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#getEntityClass()
     */
    @Override
    public Class getEntityClass() {
        return SecPrivilegeUserDMZ.class;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseIbatis3Dao#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(SecPrivilegeUserDMZ entity) {
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
        return pageQuery("SecPrivilegeUserDMZ.pageSelect", pageRequest);
    }
    
    public SecPrivilegeUserDMZ getByLoginName(java.lang.String v) {
        return (SecPrivilegeUserDMZ) getSqlSession().selectOne("SecPrivilegeUserDMZ.getByLoginName", v);
    }
    
    public boolean existLoginName(SecPrivilegeUserDMZ secPrivilegeUser) {
        long count = (Long) this.getSqlSession().selectOne(this.getCountQuery(), secPrivilegeUser);
        if (count > 0) {
            return true;
        }
        return false;
    }
    
    public List<SecPrivilegeUserDMZ> findUserByLoginNameAndPd(SecPrivilegeUserDMZ secPrivilegeUser) {
        return this.getSqlSession().selectList("SecPrivilegeUserDMZ.findByLoginNameAndPd", secPrivilegeUser);
    }
    
    /**
     * @description 用于得到登录用户所在部门信息
     * @param logiName
     * @return 用户部门名称
     */
    public String findDeptInfoByLoginName(String logiName) {
        List<String> deptList = this.getSqlSession().selectList("SecPrivilegeUserDMZ.findDeptInfoByLoginName", logiName);
        if (deptList == null || deptList.isEmpty()) {
            return null;
        } else {
            return deptList.get(0);
        }
    }
    
    /**
     * @description 根据节点得到该节点相应的审批人列表
     * @return List<SecPrivilegeUserDMZ>
     */
    public List<SecPrivilegeUserDMZ> getApproverList(Map map) {
        return this.getSqlSession().selectList("SecPrivilegeUserDMZ.getApproverListByNode", map);
    }
    
}
