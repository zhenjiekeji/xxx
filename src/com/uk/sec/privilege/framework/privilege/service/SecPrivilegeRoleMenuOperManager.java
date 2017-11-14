/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.privilege.framework.privilege.dao.SecBasDicItemDao;
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeRoleMenuOperDao;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeRoleMenuOper;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecPrivilegeRoleMenuOperManager extends BaseManager<SecPrivilegeRoleMenuOper,java.lang.String>{
    /**
     * historyDao
     */
    private SecPrivilegeRoleMenuOperDao secPrivilegeRoleMenuOperDao;

    private SecBasDicItemDao secBasDicItemDao;

    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     *
     * @param dao
     *            dao.
     */
    public void setSecPrivilegeRoleMenuOperDao(SecPrivilegeRoleMenuOperDao dao) {
        this.secPrivilegeRoleMenuOperDao = dao;
    }

    public void setSecBasDicItemDao(SecBasDicItemDao secBasDicItemDao) {
		this.secBasDicItemDao = secBasDicItemDao;
	}

    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    public EntityDao getEntityDao() {
        return this.secPrivilegeRoleMenuOperDao;
    }

    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Transactional(readOnly=true)
    public Page findByPageRequest(PageRequest pr) {
        return secPrivilegeRoleMenuOperDao.findByPageRequest(pr);
    }

    public void deleteByRoleId(String roleId){
    	secPrivilegeRoleMenuOperDao.deleteByRoleId(roleId);
    }

    /**
	 * 返回相应的角色所关联的所有菜单列表.
	 */   
    public List<String> selectMenuListByRoleId(String roleId){
 	   List<String> menuIdList = secPrivilegeRoleMenuOperDao.selectDistinctMenuId(roleId);
 	   return menuIdList;
    }    
    
    /**
	 * 相应的角色对应的菜单下的所有的操作信息.
	 */
   public Map<String,List<SecBasDicItem>> selectRoleMenuOperationList(String roleId){
	   List<String> menuIdList=secPrivilegeRoleMenuOperDao.selectDistinctMenuId(roleId);
	   Map<String,List<SecBasDicItem>> roleMenuOperationList=new HashMap<String, List<SecBasDicItem>>();
	   for(int i=0;i<menuIdList.size();i++){
		   List<SecBasDicItem> operationListByRoleIdMenuId=secBasDicItemDao.selectOperationByRoleIdMenuId(roleId,menuIdList.get(i));
		   roleMenuOperationList.put(menuIdList.get(i), operationListByRoleIdMenuId);
	   }
	   return roleMenuOperationList;
   }

   /**
	 * 给相应角色重新分配相应的菜单及其对应的操作信息
	 */
   public String assignRoleMenuOperation(String roleId,String menuIdOperation){
	   //首先删除原来分配的旧的权限
	   secPrivilegeRoleMenuOperDao.deleteByRoleId(roleId);
	   //然后再插入新分配的所有权限
	   if(menuIdOperation == null || menuIdOperation.isEmpty()){
		   return "操作成功！";
	   }
	   int count=0;
	   SecPrivilegeRoleMenuOper secPrivilegeRoleMenuOper=new SecPrivilegeRoleMenuOper();
	   String[] menuIdOperationArray = menuIdOperation.split("@@@");
	   for(String menuId : menuIdOperationArray){
			secPrivilegeRoleMenuOper.setRoleId(roleId);
			secPrivilegeRoleMenuOper.setMenuId(menuId);
			secPrivilegeRoleMenuOper.setOperationId(Long.valueOf(0));
			secPrivilegeRoleMenuOperDao.save(secPrivilegeRoleMenuOper);
			count++;
		}
	   if(count>0){
		   return "操作成功！";
	   }
	   else{
		   return "操作失败！";
	   }
   }

}
