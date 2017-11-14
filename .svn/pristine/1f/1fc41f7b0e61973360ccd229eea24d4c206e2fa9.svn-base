/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.privilege.framework.privilege.dao.SecBasDicItemDao;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class SecBasDicItemManager extends BaseManager<SecBasDicItem, java.lang.String> {
    /**
     * historyDao
     */
    private SecBasDicItemDao secBasDicItemDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setSecBasDicItemDao(SecBasDicItemDao dao) {
        this.secBasDicItemDao = dao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.secBasDicItemDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return secBasDicItemDao.findByPageRequest(pr);
    }
    
    /**
     * 查询相应的字典组下所有的字典项.
     */
    public List<SecBasDicItem> selectDicItemListByGroupId(String groupId) {
        return secBasDicItemDao.selectDicItemListByGroupId(groupId);
    }
    
    /**
     * 根据groupId,orderColumn,查询出List<SecBasDicItem>.
     */
    public List<SecBasDicItem> selectDicItemByGroupIdAndOrder(String groupId, String sortColumns) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("groupId", groupId);
        map.put("sortColumns", sortColumns);
        return secBasDicItemDao.selectDicItemByGroupIdAndOrder(map);
    }
    
    /**
     * 查询字典项中最大的排序id并+1
     */
    public Long findMaxItemOrder(String groupId) {
        Long maxOrder = secBasDicItemDao.findMaxItemOrder(groupId);
        if (maxOrder != null && maxOrder > 0) {
            return maxOrder + 1;
        } else {
            return 1L;
        }
    }
    
    /**
     * 查询字典项中最小的排序id
     */
    public Long findMinItemOrder(String groupId) {
        Long minOrder = secBasDicItemDao.findMinItemOrder(groupId);
        if (minOrder != null && minOrder > 0) {
            return minOrder;
        } else {
            return 1L;
        }
    }
    
    /**
     * 查询字典项中最大的ItemId并+1
     */
    public Long findMaxItemId(String groupId) {
        if (secBasDicItemDao.findMaxItemId(groupId) != null && secBasDicItemDao.findMaxItemId(groupId) > 0) {
            return secBasDicItemDao.findMaxItemId(groupId) + 1;
        } else {
            return 1L;
        }
    }
    
    /**
     * 下移字典项
     * 
     * @param dicId
     * @param groupId
     */
    public void orderDown(String dicId, String groupId) {
        secBasDicItemDao.orderDown(dicId, groupId);
    }
    
    /**
     * 上移字典项
     * 
     * @param dicId
     * @param groupId
     */
    public void orderUp(String dicId, String groupId) {
        secBasDicItemDao.orderUp(dicId, groupId);
    }
    
    // 转化 json
    public List<Map> getSelectItemMap(List<SecBasDicItem> list) {
        
        List<Map> maplist = new ArrayList<Map>();
        for (SecBasDicItem item : list) {
            Map map = makeMap(item);
            maplist.add(map);
        }
        return maplist;
        
    }
    
    private Map makeMap(SecBasDicItem item) {
        Map map = new HashMap();
        map.put("itemId", item.getItemId());
        map.put("dec", item.getItemDescription());
        map.put("name", item.getItemName());
        return map;
    }
    /**
     * list 转 map
     * @author 景艳磊
     * @date 2015-1-22
     * @param list
     * @return Map<String, SecBasDicItem>
     */
    public Map<String, SecBasDicItem> listToMap(List<SecBasDicItem> list) {
    	Map<String, SecBasDicItem> map = new LinkedHashMap<String, SecBasDicItem>();
    	if (list.size() > 0) {
    		for (SecBasDicItem items : list) {
    			map.put(items.getItemId()+"", items);
    		}
    	}
    	return map;
    }
}
