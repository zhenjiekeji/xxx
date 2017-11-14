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
import com.uk.sec.privilege.framework.privilege.dao.SecPrivilegeMenuOperDao;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenuOper;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecPrivilegeMenuOperManager extends BaseManager<SecPrivilegeMenuOper,java.lang.String>{
    /**
     * historyDao
     */
    private SecPrivilegeMenuOperDao secPrivilegeMenuOperDao;

    private SecBasDicItemDao secBasDicItemDao;

    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     *
     * @param dao
     *            dao.
     */
    public void setSecPrivilegeMenuOperDao(SecPrivilegeMenuOperDao dao) {
        this.secPrivilegeMenuOperDao = dao;
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
        return this.secPrivilegeMenuOperDao;
    }

    /**
     * {@inheritDoc}
     *
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Transactional(readOnly=true)
    public Page findByPageRequest(PageRequest pr) {
        return secPrivilegeMenuOperDao.findByPageRequest(pr);
    }

    /**
	 * 选中的菜单对应的操作列表信息.
	 */
	public List<SecBasDicItem> selectOperationByMenuId(String menuId) {
		return secBasDicItemDao.selectOperationByMenuId(menuId);
	}

	public void saveMenuRelateOperations(Long[] operationId,String menuId){
		//将菜单操作表中该菜单关联的原有操作全部删除
		secPrivilegeMenuOperDao.deleteByMenuId(menuId);
		//往菜单操作表中插入该菜单关联的新操作记录
		if(operationId != null){
			SecPrivilegeMenuOper secPrivilegeMenuOper=new SecPrivilegeMenuOper();
			for(Long selectOperationId : operationId){
				secPrivilegeMenuOper.setMenuId(menuId);
				secPrivilegeMenuOper.setOperationId(selectOperationId);
				secPrivilegeMenuOperDao.save(secPrivilegeMenuOper);
			}
		}
	}

    /**
	 * 具体菜单对应的所有的操作列表信息.
	 */
   public Map<String,List<SecBasDicItem>> selectMenuOperationList(){
	   List<String> menuIdList=secPrivilegeMenuOperDao.selectDistinctMenuId();
	   Map<String,List<SecBasDicItem>> menuOperationList=new HashMap<String, List<SecBasDicItem>>();
	   for(int i=0;i<menuIdList.size();i++){
		   List<SecBasDicItem> operationListByMenuId=secBasDicItemDao.selectOperationByMenuId(menuIdList.get(i));
		   menuOperationList.put(menuIdList.get(i), operationListByMenuId);
	   }
	   return menuOperationList;
   }

}
