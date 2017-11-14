/**
 * 版权所有 科技有限公司 Copyright(c) 2015 All Rights Reserved
 * Project: waite
 * Author: 许振伟
 * Create Date: 2015-01-10 09:24
 * Update Date: 2015-01-10 09:24
 * Description: 处理批量删除的时候,删除成功和删除失败的数据
 */
package com.uk.sec.framework.base;

/**
 * 处理批量删除的时候,删除成功和删除失败的数据
 * 
 * @since 1.0
 */
public class BaseDataView {
    /** 默认的构造方法,其实什么都不做 */
    public BaseDataView() {
        
    }
    
    /** 业务的唯一编码 */
    private String uniqueName;
    /** 业务的显示名称 */
    private String displayName;
    /** 业务模块名称 */
    private String modeName;
    /** 删除的成功数量 */
    private int successNum;
    /** 删除的失败数 */
    private int errorNum;
    
    public String getUniqueName() {
        return this.uniqueName;
    }
    
    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public String getModeName() {
        return this.modeName;
    }
    
    public void setModeName(String modeName) {
        this.modeName = modeName;
    }
    
    public int getSuccessNum() {
        return this.successNum;
    }
    
    public void setSuccessNum(int successNum) {
        this.successNum = successNum;
    }
    
    public int getErrorNum() {
        return this.errorNum;
    }
    
    public void setErrorNum(int errorNum) {
        this.errorNum = errorNum;
    }
}
