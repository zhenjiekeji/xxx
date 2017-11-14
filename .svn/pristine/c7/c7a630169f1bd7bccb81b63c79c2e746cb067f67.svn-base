/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.ectable.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uk.sec.framework.aop.ValidationAware;
import com.uk.sec.framework.base.BaseManager;
import com.uk.sec.framework.base.EntityDao;
import com.uk.sec.framework.ectable.dao.EctableColumnDetailDao;
import com.uk.sec.framework.ectable.model.EctableColumnDetail;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

@Component
@Transactional
public class EctableColumnDetailManager extends BaseManager<EctableColumnDetail, java.lang.String> implements
        ValidationAware {
    /**
     * historyDao
     */
    private EctableColumnDetailDao ectableColumnDetailDao;
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写
     * 
     * @param dao
     *            dao.
     */
    public void setEctableColumnDetailDao(EctableColumnDetailDao dao) {
        this.ectableColumnDetailDao = dao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#getEntityDao()
     */
    @Override
    public EntityDao getEntityDao() {
        return this.ectableColumnDetailDao;
    }
    
    public void validateFindByPageRequest(PageRequest pr) {
        logger.info("EctableColumnDetailManager: testFindByPageRequest");
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javacommon.base.BaseManager#findByPageRequest(cn.org.rapid_framework.page.PageRequest)
     */
    @Override
    @Transactional(readOnly = true)
    public Page findByPageRequest(PageRequest pr) {
        return ectableColumnDetailDao.findByPageRequest(pr);
    }
    
    /**
     * 根据表格定义,用户id,视图类型查询.
     * 
     * @param ectableColumnId
     * @param userId
     * @param viewType
     * @return
     * @author xzw
     */
    public List<EctableColumnDetail> findByUserIdAndViewType(String ectableColumnId, String userId, String viewType) {
        return this.ectableColumnDetailDao.findByUserIdAndViewType(ectableColumnId, userId, viewType);
    }
    
    /**
     * 根据表格定义,用户id,查询视图类型为html的showStatus为0的.
     * 
     * @param ectableColumnId
     * @param userId
     * @return
     * @author xzw
     */
    public List<EctableColumnDetail> findHtmlViewDenied(String ectableColumnId, String userId) {
        return this.ectableColumnDetailDao.findDeniedByViewType(ectableColumnId, userId, EctableColumnDetail.VIEW_HTML);
    }
    
    /**
     * 根据表格定义,用户id,查询视图类型为pdf的showStatus为0的.
     * 
     * @param ectableColumnId
     * @param userId
     * @return
     * @author xzw
     */
    public List<EctableColumnDetail> findPdfViewDenied(String ectableColumnId, String userId) {
        return this.ectableColumnDetailDao.findDeniedByViewType(ectableColumnId, userId, EctableColumnDetail.VIEW_PDF);
    }
    
    /**
     * 根据表格定义,用户id,查询视图类型为csv的showStatus为0的.
     * 
     * @param ectableColumnId
     * @param userId
     * @return
     * @author xzw
     */
    public List<EctableColumnDetail> findCsvViewDenied(String ectableColumnId, String userId) {
        return this.ectableColumnDetailDao.findDeniedByViewType(ectableColumnId, userId, EctableColumnDetail.VIEW_CSV);
    }
    
    /**
     * 根据表格定义,用户id,查询视图类型为xls的showStatus为0的.
     * 
     * @param ectableColumnId
     * @param userId
     * @return
     * @author xzw
     */
    public List<EctableColumnDetail> findXslViewDenied(String ectableColumnId, String userId) {
        return this.ectableColumnDetailDao.findDeniedByViewType(ectableColumnId, userId, EctableColumnDetail.VIEW_XLS);
    }
    
    /**
     * 查询下一个排序号
     * 
     * @param ectableColumnId
     * @param viewType
     * @return
     * @author xzw
     */
    public int getOrderNumByModel(String ectableColumnId, String viewType) {
        return this.ectableColumnDetailDao.findECDByMaxOrderNum(ectableColumnId, viewType);
    }
    
    /**
     * 根据ectableColumnId和columnName查询出主键
     * 
     * @param ectableColumnId
     * @param columnName
     * @return
     * @author xzw
     */
    public String findECDByColumnNameAndId(String ectableColumnId, String columnName) {
        if (this.ectableColumnDetailDao.findECDByColumnNameAndId(ectableColumnId, columnName) != null) {
            return this.ectableColumnDetailDao.findECDByColumnNameAndId(ectableColumnId, columnName).getId();
        }
        return null;
    }
    
    /**
     * 根据ectableColumnId和columnName删除记录.
     * 
     * @param ectableColumnId
     * @param columnName
     * @author xzw
     */
    public void removeECDByColumnNameAndId(String ectableColumnId, String columnName) {
        this.ectableColumnDetailDao.removeECDByColumnNameAndId(ectableColumnId, columnName);
    }
    
    /**
     * 根据视图类型为html 的一个ectableColumnDetail查询同一属性的视图类型为xls的ectableColumnDetail.
     * 
     * @param ectableColumnDetail
     * @return
     * @author xzw
     */
    public EctableColumnDetail findByHtml(EctableColumnDetail ectableColumnDetail) {
        return this.ectableColumnDetailDao.findByHtml(ectableColumnDetail);
    }
    
    /**
     * 新增用户时初始化该用户的默认显示设置数据.
     * 
     * @param userId
     * @author xzw
     */
    // TODO ectable导出，修改userId默认值
    public void copyColumnDetailWhenUserCreated(String userId) {
        List<EctableColumnDetail> ectableColumnDetailList = this.ectableColumnDetailDao.findAllBy("userId", "1");
        List<EctableColumnDetail> ectableColumnDetailListOriginal = new ArrayList<EctableColumnDetail>();
        for (EctableColumnDetail ectableColumnDetail : ectableColumnDetailList) {
            EctableColumnDetail detail = ectableColumnDetail.clone();
            detail.setUserId(userId);
            ectableColumnDetailListOriginal.add(detail);
        }
        this.ectableColumnDetailDao.saveAll(ectableColumnDetailListOriginal);
    }
    
    /**
     * 提交ectable的自定义配置.
     * 
     * @param ids
     *            ids数组保存着所有列的id
     * @param orderNums
     *            orderNums保存着所有列的排序号
     * @param cols
     *            cols保存着所有要显示的列
     * @author xzw
     */
    public void batchUpdate(String[] ids, String[] orderNums, Set<String> cols) {
        for (int i = 0; i < ids.length; i++) {
            // 从ids的每个元素中提取出值.
            Hashtable rows = HttpUtils.parseQueryString(ids[i]);
            String id = (String) rows.get("id");
            
            // 从orderNums的每个元素中提取出值.
            Hashtable orders = HttpUtils.parseQueryString(orderNums[i]);
            Integer orderNum = new Integer((String) orders.get("order"));
            
            // cols中存在的主键对应的列的showStatus设为显示，否则设为不显示.
            Long show = cols.contains(id) ? 1L : 0L;
            
            // 构造model,视图类型为html
            EctableColumnDetail ectableColumnDetailHtml = this.getById(id);
            ectableColumnDetailHtml.setOrderNum(orderNum);
            ectableColumnDetailHtml.setShowStatus(show);
            this.update(ectableColumnDetailHtml);
            
            // 构造model,如果有同一列的视图类型为xls的model,修改后提交.
            EctableColumnDetail ectableColumnDetailXls = this.findByHtml(ectableColumnDetailHtml);
            if (ectableColumnDetailXls != null) {
                ectableColumnDetailXls.setOrderNum(orderNum);
                ectableColumnDetailXls.setShowStatus(show);
                this.update(ectableColumnDetailXls);
            }
            
        }
    }
    
}
