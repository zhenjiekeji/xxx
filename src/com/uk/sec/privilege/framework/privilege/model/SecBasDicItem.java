/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.privilege.framework.privilege.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.uk.sec.framework.base.BaseEntity;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class SecBasDicItem extends BaseEntity {
    
    // alias
    public static final String TABLE_ALIAS            = "字典项表";
    public static final String ALIAS_ITEM_ID          = "字典项ID";
    public static final String ALIAS_ITEM_NAME        = "字典项名称";
    public static final String ALIAS_ITEM_DESCRIPTION = "字典项描述";
    public static final String ALIAS_GROUP_ID         = "字典组ID";
    public static final String ALIAS_DIC_ID           = "字典项表ID";
    public static final String ALIAS_ITEM_FLAG        = "字典项标志位，0：不可现1：可现";
    public static final String ALIAS_ITEM_ORDER       = "字典项排序";
    
    // date formats
    
    // columns START
    private java.lang.Long     itemId;
    private java.lang.String   itemName;
    private java.lang.String   itemDescription;
    private java.lang.String   groupId;
    private java.lang.String   dicId;
    private java.lang.Short    itemFlag;
    private java.lang.Long     itemOrder;
    
    public static final Short  ITEM_FLAG_VISIBLE      = 1;                 // 分组可现
    public static final Short  ITEM_FLAG_INVISIBLE    = 0;                 // 分组不可现
                                                                            
    // columns END
    
    public SecBasDicItem() {
    }
    
    public SecBasDicItem(java.lang.String dicId) {
        this.dicId = dicId;
    }
    
    public void setItemId(java.lang.Long value) {
        this.itemId = value;
    }
    
    public java.lang.Long getItemId() {
        return this.itemId;
    }
    
    public void setItemName(java.lang.String value) {
        this.itemName = value;
    }
    
    public java.lang.String getItemName() {
        return this.itemName;
    }
    
    public void setItemDescription(java.lang.String value) {
        this.itemDescription = value;
    }
    
    public java.lang.String getItemDescription() {
        return this.itemDescription;
    }
    
    public void setGroupId(java.lang.String value) {
        this.groupId = value;
    }
    
    public java.lang.String getGroupId() {
        return this.groupId;
    }
    
    public void setDicId(java.lang.String value) {
        this.dicId = value;
    }
    
    public java.lang.String getDicId() {
        return this.dicId;
    }
    
    public void setItemFlag(java.lang.Short value) {
        this.itemFlag = value;
    }
    
    public java.lang.Short getItemFlag() {
        return this.itemFlag;
    }
    
    private SecBasDicGroup secBasDicGroup;
    
    public void setSecBasDicGroup(SecBasDicGroup secBasDicGroup) {
        this.secBasDicGroup = secBasDicGroup;
    }
    
    public SecBasDicGroup getSecBasDicGroup() {
        return secBasDicGroup;
    }
    
    public java.lang.Long getItemOrder() {
        return itemOrder;
    }
    
    public void setItemOrder(java.lang.Long itemOrder) {
        this.itemOrder = itemOrder;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ItemId", getItemId())
                                        .append("ItemName", getItemName())
                                        .append("ItemDescription", getItemDescription())
                                        .append("GroupId", getGroupId())
                                        .append("DicId", getDicId())
                                        .append("ItemFlag", getItemFlag())
                                        .append("ItemOrder", getItemOrder())
                                        .toString();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getItemId())
                                    .append(getItemName())
                                    .append(getItemDescription())
                                    .append(getGroupId())
                                    .append(getDicId())
                                    .append(getItemFlag())
                                    .append(getItemOrder())
                                    .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SecBasDicItem == false)
            return false;
        if (this == obj)
            return true;
        SecBasDicItem other = (SecBasDicItem) obj;
        return new EqualsBuilder().append(getItemId(), other.getItemId())
                                  .append(getItemName(), other.getItemName())
                                  .append(getItemDescription(), other.getItemDescription())
                                  .append(getGroupId(), other.getGroupId())
                                  .append(getDicId(), other.getDicId())
                                  .append(getItemFlag(), other.getItemFlag())
                                  .append(getItemOrder(), other.getItemOrder())
                                  .isEquals();
    }
}
