/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.ectable.action;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.framework.ectable.model.EctableColumn;
import com.uk.sec.framework.ectable.model.EctableColumnDetail;
import com.uk.sec.framework.ectable.service.EctableColumnDetailManager;
import com.uk.sec.framework.ectable.service.EctableColumnManager;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class EctableColumnDetailAction extends BaseStruts2Action implements Preparable, ModelDriven {
    /**
     * 默认多列排序,example: username desc,createTime asc.
     */
    protected static final String      DEFAULT_SORT_COLUMNS = null;
    /*
     * 跳转地址.---------------START---------------
     */
    /**
     * 查询页面.
     */
    protected static final String      QUERY_JSP            = "/framework/ectable/EctableColumnDetail/query.jsp";
    /**
     * 列表页面.
     */
    protected static final String      LIST_JSP             = "/framework/ectable/EctableColumnDetail/list.jsp";
    /**
     * 新建页面.
     */
    protected static final String      CREATE_JSP           = "/framework/ectable/EctableColumnDetail/create.jsp";
    /**
     * 编辑页面.
     */
    protected static final String      EDIT_JSP             = "/framework/ectable/EctableColumnDetail/edit.jsp";
    /**
     * 查看页面.
     */
    protected static final String      SHOW_JSP             = "/framework/ectable/EctableColumnDetail/show.jsp";
    
    /**
     * 显示配置ectable自定义列的页面.
     */
    protected static final String      EC_DIALOG            = "/components/ec_column_dialog.jsp";
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String      LIST_ACTION          = "!/framework/ectable/EctableColumnDetail/list.do";
    /*
     * 重定向地址以!开头.---------------E N D---------------
     */

    /*
     * 内部成员定义.---------------START---------------
     */
    /**
     * manager.
     */
    private EctableColumnManager       ectableColumnManager;
    private EctableColumnDetailManager ectableColumnDetailManager;
    /**
     * model.
     */
    private EctableColumnDetail        ectableColumnDetail;
    /**
     * id.
     */
    java.lang.String                   id                   = null;
    /**
     * items 删除记录id数组.
     */
    private String[]                   items;
    /**
     * ectable详细配置数据的orderNum数组.提交后保存在根据页面上所有column的实际顺序作为新的排序号.以[order=?]的方式保存
     */
    private String[]                   orderNums;
    /**
     * ectable详细配置数据的showStatus数组.提交后保存着选中的checkbox的值,checkbox的值为该条column的id.以[show=?]的方式保存
     */
    private String[]                   columnShows;
    /**
     * ectable详细配置数据id数组.提交后保存着所有column的id.以[id=?]的方式保存
     */
    private String[]                   ids;
    /**
     * ectable的tableId.
     */
    private String                     tableId;
    /**
     * ectable详细配置数据的列表.
     */
    private List<EctableColumnDetail>  ecdlist;
    
    /*
     * 内部成员定义.---------------E N D---------------
     */

    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.Preparable#prepare()
     */
    public void prepare() throws Exception {
        if (isNullOrEmptyString(id)) {
            ectableColumnDetail = new EctableColumnDetail();
        } else {
            ectableColumnDetail = ectableColumnDetailManager.getById(id);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return ectableColumnDetail;
    }
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     * 
     * @param manager
     *            manager.
     */
    public void setEctableColumnDetailManager(EctableColumnDetailManager manager) {
        this.ectableColumnDetailManager = manager;
    }
    
    /**
     * @param val
     *            id.
     */
    public void setId(java.lang.String val) {
        this.id = val;
    }
    
    /**
     * @param items
     *            items.
     */
    public void setItems(String[] items) {
        this.items = items;
    }
    
    /**
     * 进入查询页面.
     * 
     * @return 查询页面.
     */
    public String query() {
        return QUERY_JSP;
    }
    
    /**
     * 执行搜索.
     * 
     * @return 搜索页面.
     */
    public String list() {
        PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS, "ecd_list");
        // pageRequest.getFilters().put("key",value); //add custom filter
        Page page = ectableColumnDetailManager.findByPageRequest(pageRequest);
        savePage(page, pageRequest);
        return LIST_JSP;
    }
    
    /**
     * 查看对象.
     * 
     * @return 查看页面.
     */
    public String show() {
        return SHOW_JSP;
    }
    
    /**
     * 进入新增页面
     * 
     * @return 新增页面.
     */
    public String create() {
        return CREATE_JSP;
    }
    
    /**
     * 保存新增对象.
     * 
     * @return 重定向到列表页面.
     */
    public String save() {
        ectableColumnDetailManager.save(ectableColumnDetail);
        return LIST_ACTION;
    }
    
    /**
     * 进入更新页面.
     * 
     * @return 更新页面.
     */
    public String edit() {
        return EDIT_JSP;
    }
    
    /**
     * 保存更新对象.
     * 
     * @return 重定向到列表页面.
     */
    public String update() {
        ectableColumnDetailManager.update(this.ectableColumnDetail);
        return LIST_ACTION;
    }
    
    /**
     * 删除对象.
     * 
     * @return 重定向到列表页面.
     */
    public String delete() {
        for (int i = 0; i < items.length; i++) {
            Hashtable params = HttpUtils.parseQueryString(items[i]);
            java.lang.String id = new java.lang.String((String) params.get("id"));
            ectableColumnDetailManager.removeById(id);
        }
        return LIST_ACTION;
    }
    
    /**
     * 提交ectable的自定义配置.
     * columnShows数组保存着所有要显示的列,orderNums保存着所有列的排序号,ids数组保存着所有列的id.
     */
    public String batchUpdate() throws Exception {
        // 自定义配置保存成功后的跳转页面.
        String action = this.getRequest().getParameter("action");
        // 如果所有的列都不显示,不提交,自动返回.
        if (this.columnShows != null && !Arrays.deepEquals(this.columnShows, new String[] { "false" })) {
            // 所有要显示的列的id的集合.
            Set<String> cols = new HashSet<String>();
            for (String s : columnShows) {
                Hashtable colsTable = HttpUtils.parseQueryString(s);
                // 从columnShows的每个元素中提取出值.
                String key = (String) colsTable.get("show");
                cols.add(key);
            }
            this.ectableColumnDetailManager.batchUpdate(this.ids, this.orderNums, cols);
        }
        return action;
    }
    
    /**
     * 根据tableId和userId获得显示设置数据.
     * 
     * @return 配置ectable自定义列的页面.
     * @author 张旭
     */
    public String generateEcList() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String testTableId = "inspectResult_list";
        // 取出表格要显示的列及他们的之间的顺序
        EctableColumn ec = this.ectableColumnManager.findByUniqueName(testTableId);
        if (ec != null) {
            // this.ecdlist = this.ectableColumnManager.findEcdListByEc(ec,
            // this.getUserView()
            // .getUserInfo()
            // .getSecLoginId());
            this.ecdlist = this.ectableColumnManager.findEcdListByEc(ec, "1");
        }
        return EC_DIALOG;
    }
    
    /**
     * @return the ectableColumnManager
     */
    public EctableColumnManager getEctableColumnManager() {
        return ectableColumnManager;
    }
    
    /**
     * @param ectableColumnManager
     *            the ectableColumnManager to set
     */
    public void setEctableColumnManager(EctableColumnManager ectableColumnManager) {
        this.ectableColumnManager = ectableColumnManager;
    }
    
    /**
     * @return the ectableColumnDetail
     */
    public EctableColumnDetail getEctableColumnDetail() {
        return ectableColumnDetail;
    }
    
    /**
     * @param ectableColumnDetail
     *            the ectableColumnDetail to set
     */
    public void setEctableColumnDetail(EctableColumnDetail ectableColumnDetail) {
        this.ectableColumnDetail = ectableColumnDetail;
    }
    
    /**
     * @return the orderNums
     */
    public String[] getOrderNums() {
        return orderNums;
    }
    
    /**
     * @param orderNums
     *            the orderNums to set
     */
    public void setOrderNums(String[] orderNums) {
        this.orderNums = orderNums;
    }
    
    /**
     * @return the columnShows
     */
    public String[] getColumnShows() {
        return columnShows;
    }
    
    /**
     * @param columnShows
     *            the columnShows to set
     */
    public void setColumnShows(String[] columnShows) {
        this.columnShows = columnShows;
    }
    
    /**
     * @return the ids
     */
    public String[] getIds() {
        return ids;
    }
    
    /**
     * @param ids
     *            the ids to set
     */
    public void setIds(String[] ids) {
        this.ids = ids;
    }
    
    /**
     * @return the tableId
     */
    public String getTableId() {
        return tableId;
    }
    
    /**
     * @param tableId
     *            the tableId to set
     */
    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
    
    /**
     * @return the ecdlist
     */
    public List<EctableColumnDetail> getEcdlist() {
        return ecdlist;
    }
    
    /**
     * @param ecdlist
     *            the ecdlist to set
     */
    public void setEcdlist(List<EctableColumnDetail> ecdlist) {
        this.ecdlist = ecdlist;
    }
    
    /**
     * @return the ectableColumnDetailManager
     */
    public EctableColumnDetailManager getEctableColumnDetailManager() {
        return ectableColumnDetailManager;
    }
    
    /**
     * @return the id
     */
    public java.lang.String getId() {
        return id;
    }
    
    /**
     * @return the items
     */
    public String[] getItems() {
        return items;
    }
    
}
