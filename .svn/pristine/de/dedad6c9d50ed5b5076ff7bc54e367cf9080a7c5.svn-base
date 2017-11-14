/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.ectable.model;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.uk.sec.framework.base.BaseEntity;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class EctableColumnDetail extends BaseEntity {
    
    // alias
    public static final String TABLE_ALIAS             = "排序清单";
    public static final String ALIAS_ID                = "主键";
    public static final String ALIAS_COLUMN_NAME       = "列名";
    public static final String ALIAS_ORDER_NUM         = "排序号";
    public static final String ALIAS_SHOW_STATUS       = "显示状态,1显示,0不显示";
    public static final String ALIAS_USER_ID           = "用户ID,0为默认,其它为具体用户的视图定义";
    public static final String ALIAS_VIEW_TYPE         = "视图类型,HTML,PDF,CSV,XSL";
    public static final String ALIAS_DISPLAY_NAME      = "显示名";
    public static final String ALIAS_ECTABLE_COLUMN_ID = "表单定义表的主键";
    
    // date formats
    public static final String VIEW_PDF                = "pdf";
    public static final String VIEW_HTML               = "html";
    public static final String VIEW_CSV                = "csv";
    public static final String VIEW_XLS                = "xls";
    
    public static final String ECTABLE_USER_ID         = "userIdForEctable";
    
    // columns START
    private java.lang.String   id;
    private java.lang.String   columnName;
    private java.lang.Integer  orderNum;
    private java.lang.Long     showStatus;
    private java.lang.String   userId;
    private java.lang.String   viewType;
    private java.lang.String   displayName;
    private java.lang.String   ectableColumnId;
    
    // columns END
    
    public EctableColumnDetail() {
    }
    
    public EctableColumnDetail(java.lang.String id) {
        this.id = id;
    }
    
    public void setId(java.lang.String value) {
        this.id = value;
    }
    
    public java.lang.String getId() {
        return this.id;
    }
    
    public void setColumnName(java.lang.String value) {
        this.columnName = value;
    }
    
    public java.lang.String getColumnName() {
        return this.columnName;
    }
    
    public void setOrderNum(java.lang.Integer value) {
        this.orderNum = value;
    }
    
    public java.lang.Integer getOrderNum() {
        return this.orderNum;
    }
    
    public void setShowStatus(java.lang.Long value) {
        this.showStatus = value;
    }
    
    public java.lang.Long getShowStatus() {
        return this.showStatus;
    }
    
    public void setUserId(java.lang.String value) {
        this.userId = value;
    }
    
    public java.lang.String getUserId() {
        return this.userId;
    }
    
    public void setViewType(java.lang.String value) {
        this.viewType = value;
    }
    
    public java.lang.String getViewType() {
        return this.viewType;
    }
    
    public void setDisplayName(java.lang.String value) {
        this.displayName = value;
    }
    
    public java.lang.String getDisplayName() {
        return this.displayName;
    }
    
    public void setEctableColumnId(java.lang.String value) {
        this.ectableColumnId = value;
    }
    
    public java.lang.String getEctableColumnId() {
        return this.ectableColumnId;
    }
    
    private EctableColumn ectableColumn;
    
    public void setEctableColumn(EctableColumn ectableColumn) {
        this.ectableColumn = ectableColumn;
    }
    
    public EctableColumn getEctableColumn() {
        return ectableColumn;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("Id", getId())
                                        .append("ColumnName", getColumnName())
                                        .append("OrderNum", getOrderNum())
                                        .append("ShowStatus", getShowStatus())
                                        .append("UserId", getUserId())
                                        .append("ViewType", getViewType())
                                        .append("DisplayName", getDisplayName())
                                        .append("EctableColumnId", getEctableColumnId())
                                        .toString();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                                    .append(getColumnName())
                                    .append(getOrderNum())
                                    .append(getShowStatus())
                                    .append(getUserId())
                                    .append(getViewType())
                                    .append(getDisplayName())
                                    .append(getEctableColumnId())
                                    .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EctableColumnDetail == false) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        EctableColumnDetail other = (EctableColumnDetail) obj;
        return new EqualsBuilder().append(getId(), other.getId())
                                  .append(getColumnName(), other.getColumnName())
                                  .append(getOrderNum(), other.getOrderNum())
                                  .append(getShowStatus(), other.getShowStatus())
                                  .append(getUserId(), other.getUserId())
                                  .append(getViewType(), other.getViewType())
                                  .append(getDisplayName(), other.getDisplayName())
                                  .append(getEctableColumnId(), other.getEctableColumnId())
                                  .isEquals();
    }
    
    @Override
    public EctableColumnDetail clone() {
        EctableColumnDetail ectableColumnDetail = new EctableColumnDetail();
        try {
            PropertyUtils.copyProperties(ectableColumnDetail, this);
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // To change body of catch statement use
            // File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace(); // To change body of catch statement use
            // File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace(); // To change body of catch statement use
            // File | Settings | File Templates.
        }
        ectableColumnDetail.setId("0");
        return ectableColumnDetail;
    }
}
