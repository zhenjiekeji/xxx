/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.ectable.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.uk.sec.framework.base.BaseEntity;


/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class EctableColumn extends BaseEntity {
    
    // alias
    public static final String TABLE_ALIAS       = "ECTABLE列表中列排序定义表";
    public static final String ALIAS_ID          = "主键";
    public static final String ALIAS_NAME        = "显示名";
    public static final String ALIAS_UNIQUE_NAME = "唯一名称";
    public static final String ALIAS_DESCRIPTION = "描述";
    
    // date formats
    
    // columns START
    private java.lang.String   id;
    private java.lang.String   name;
    private java.lang.String   uniqueName;
    private java.lang.String   description;
    
    // columns END
    
    public EctableColumn() {
    }
    
    public EctableColumn(java.lang.String id) {
        this.id = id;
    }
    
    public void setId(java.lang.String value) {
        this.id = value;
    }
    
    public java.lang.String getId() {
        return this.id;
    }
    
    public void setName(java.lang.String value) {
        this.name = value;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setUniqueName(java.lang.String value) {
        this.uniqueName = value;
    }
    
    public java.lang.String getUniqueName() {
        return this.uniqueName;
    }
    
    public void setDescription(java.lang.String value) {
        this.description = value;
    }
    
    public java.lang.String getDescription() {
        return this.description;
    }
    
    private Set ectableColumnDetails = new HashSet(0);
    
    public void setEctableColumnDetails(Set<EctableColumnDetail> ectableColumnDetail) {
        this.ectableColumnDetails = ectableColumnDetail;
    }
    
    public Set<EctableColumnDetail> getEctableColumnDetails() {
        return ectableColumnDetails;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("Id", getId())
                                        .append("Name", getName())
                                        .append("UniqueName", getUniqueName())
                                        .append("Description", getDescription())
                                        .toString();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                                    .append(getName())
                                    .append(getUniqueName())
                                    .append(getDescription())
                                    .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EctableColumn == false) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        EctableColumn other = (EctableColumn) obj;
        return new EqualsBuilder().append(getId(), other.getId())
                                  .append(getName(), other.getName())
                                  .append(getUniqueName(), other.getUniqueName())
                                  .append(getDescription(), other.getDescription())
                                  .isEquals();
    }
}
