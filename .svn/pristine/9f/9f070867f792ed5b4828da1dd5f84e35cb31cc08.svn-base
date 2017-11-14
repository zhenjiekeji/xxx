/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeUserDao;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUser;
import com.uk.sec.privilege.framework.privilege.util.PFUtils.SplitSignal;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecPrivilegeUserManager extends BaseManager<SecPrivilegeUser, java.lang.String> {
    /**
     * historyDao
     */
    private SecPrivilegeUserDao secPrivilegeUserDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setSecPrivilegeUserDao(SecPrivilegeUserDao dao) {
        this.secPrivilegeUserDao = dao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.secPrivilegeUserDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return secPrivilegeUserDao.findByPageRequest(pr);
    }
    
    @Transactional(readOnly = true)
    public SecPrivilegeUser getByLoginName(java.lang.String v) {
        return secPrivilegeUserDao.getByLoginName(v);
    }
    
    public boolean existLoginName(SecPrivilegeUser secPrivilegeUser) {
        if (secPrivilegeUser != null) {
            String loginName = secPrivilegeUser.getLoginName();
            // 再判断loginName是否被占用
            if (StringUtils.isNotBlank(loginName)) {
                return secPrivilegeUserDao.existLoginName(secPrivilegeUser);
            }
        }
        // 否则表明不存在
        return false;
    }
    
    /**
     * 根据zTree要求的格式构造角色map名单
     */
    public List<Map> getUserZtreeMap(Map<String, Object> selectedItemMap, String deptstr, String rolstr) {
        Map map = new HashMap();
        if (deptstr != null && !"".equals(deptstr)) {
            String[] depts = deptstr.split(SplitSignal.SPLIT_SIGNAL_AIT.getSignal());
            map.put("deptIdArray", depts);
            
        }
        if (rolstr != null && !"".equals(rolstr)) {
            String[] rols = rolstr.split(SplitSignal.SPLIT_SIGNAL_AIT.getSignal());
            map.put("roleIdArray", rols);
        }
        List<SecPrivilegeUser> secPrivilegeUsers = secPrivilegeUserDao.getUserListByDeptAndRole(map);
        List<Map> sonTrees = new ArrayList<Map>();
        // 根据zTree要求的格式构造角色map名单
        for (SecPrivilegeUser secPrivilegeUser : secPrivilegeUsers) {
            Map treemap = makeUserZtree(secPrivilegeUser, selectedItemMap);
            sonTrees.add(treemap);
        }
        return sonTrees;
    }
    
    private Map makeUserZtree(SecPrivilegeUser secPrivilegeUser, Map<String, Object> selectedItemMap) {
        Map tree = new HashMap();
        tree.put("id", secPrivilegeUser.getLoginName());
        tree.put("pId", "0");
        tree.put("name", secPrivilegeUser.getUserName());
        if (selectedItemMap != null && selectedItemMap.containsKey(String.valueOf(secPrivilegeUser.getLoginId()))) {
            tree.put("checked", true);
        } else {
            tree.put("checked", false);
        }
        return tree;
    }
    
    public List<SecPrivilegeUser> findUserByLoginNameAndPd(SecPrivilegeUser secPrivilegeUser) {
        return secPrivilegeUserDao.findUserByLoginNameAndPd(secPrivilegeUser);
    }
   
    
    /**
     * 根据流程ID修改所属用户.
     *
     * @param 实体.
     * @return int.
     */
    public int updatePassword(SecPrivilegeUser entity) {
        return secPrivilegeUserDao.updatePassword(entity);
    }
    
    /**
     * @description 用于得到登录用户所在部门信息
     * @param loginName
     * @return 用户部门名称
     */
    public SecPrivilegeUser findUserDeptInfoByLoginName(String loginName) {
    	List<SecPrivilegeUser> secPrivilegeUserList = secPrivilegeUserDao.findUserDeptInfoByLoginName(loginName);
    	if(secPrivilegeUserList == null || secPrivilegeUserList.isEmpty()){
    		return null;
    	}
    	return secPrivilegeUserList.get(0);
    }

}
