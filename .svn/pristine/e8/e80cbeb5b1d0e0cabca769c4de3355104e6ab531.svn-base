/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.bns.client.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.bns.client.model.BasicLinkinvestor;
import com.uk.sec.bns.client.service.BasicInvestorOwnerManager;
import com.uk.sec.bns.client.service.BasicLinkinvestorManager;
import com.uk.sec.framework.base.BaseStruts2Action;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class BasicLinkinvestorAction extends BaseStruts2Action implements Preparable, ModelDriven {
    /**
     * 默认多列排序,example: username desc,createTime asc.
     */
    protected static final String DEFAULT_SORT_COLUMNS = null;
    /*
     * 跳转地址.---------------START---------------
     */
    /**
     * 查询页面.
     */
    protected static final String QUERY_JSP            = "/bns/client/BasicLinkinvestor/query.jsp";
    /**
     * 列表页面.
     */
    protected static final String MAIN_JSP             = "/bns/client/BasicLinkinvestor/main.jsp";
    /**
     * 新建页面.
     */
    protected static final String CREATE_JSP           = "/bns/client/BasicLinkinvestor/create.jsp";
    /**
     * 编辑页面.
     */
    protected static final String EDIT_JSP             = "/bns/client/BasicLinkinvestor/edit.jsp";
    /**
     * 查看页面.
     */
    protected static final String INFO_JSP             = "/bns/client/BasicLinkinvestor/create.jsp";
    /**
     * 添加下级菜单页面.
     */
    protected static final String ADD_LOWER_LEVEL_JSP  = "/bns/client/BasicLinkinvestor/addLowerLevelSet.jsp";
    /*
     * 跳转地址.---------------E N D---------------
     */

    /*
     * 重定向地址以!开头.---------------START---------------
     */
    /**
     * LIST_ACTION 跳转到列表页面.
     */
    protected static final String LIST_ACTION          = "!/bns/client/BasicLinkinvestor/list.do" + NOTIFY_STATE;
    /*
     * 重定向地址以!开头.---------------E N D---------------
     */

    /*
     * 内部成员定义.---------------START---------------
     */
    /**
     * manager.
     */
    private BasicLinkinvestorManager basicLinkinvestorManager;
    private BasicInvestorOwnerManager basicInvestorOwnerManager;
    
    /**
     * model.
     */
    private BasicLinkinvestor        basicLinkinvestor = new BasicLinkinvestor();
 

	/**
     * id.
     */
    java.lang.String              pkId                   = null;
    /**
     * items 删除记录id数组.
     */
    private String[]              items;
    private String                keyIds;
    private String                ztreeIdAndPid;
    private String                menuId;
    
    /*
     * 内部成员定义.---------------E N D---------------
     */

    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.Preparable#prepare()
     */
    public void prepare() throws Exception {
        if (isNullOrEmptyString(pkId)) {
        	basicLinkinvestor = new BasicLinkinvestor();
        } else {
        	basicLinkinvestor = basicLinkinvestorManager.getById(pkId);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public Object getModel() {
        return basicLinkinvestor;
    }
    
    /**
     * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
     * 
     * @param manager
     *            manager.
     */
    public void setBasicLinkinvestorManager(BasicLinkinvestorManager basicLinkinvestorManager) {
		this.basicLinkinvestorManager = basicLinkinvestorManager;
	}
    
	/**
     * @param val
     *            id.
     */
    public void setPkId(java.lang.String val) {
        this.pkId = val;
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
     * 首页面.
     * 
     * @return 首页面.
     */
    public String main() {
        return MAIN_JSP;
    }
    
    /**
     * 查看对象.
     * 
     * @return 查看页面.
     */
    public String info() {
    	String menuId = getMenuId();
    	//根据menuId查询数据库是否存在管理处信息
    	Map paraMap = new HashMap();
    	paraMap.put("menuId", menuId);
    	paraMap.put("flag", 0);
    	List<BasicLinkinvestor> basicLinkinvestorList = basicLinkinvestorManager.findAllBy(paraMap);
    	if(basicLinkinvestorList.size() > 0) {
    		basicLinkinvestor = (BasicLinkinvestor)basicLinkinvestorList.get(0);
    	}
        return INFO_JSP;
    }
    
    /**
     * 查找一个对象.
     * 
     * @return 重定向到列表页面.
     */
    public void findById() {
    	String result = "fail";
        JSONObject obj = new JSONObject();
        try {
        	if (StringUtils.isNotBlank(pkId)) {
        		basicLinkinvestor = basicLinkinvestorManager.findByProperty("pkId", pkId);
            }
            obj.put("result", basicLinkinvestor);
        } catch (Exception e) {
            obj.put("result", result);

        } finally {
           try {
                this.getResponse().getWriter().print(obj);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    
    /**
     * 通过ajax保存新增对象.
     * 
     * @return 重定向到列表页面.
     */
    public void saveByAjax() {
    	String result = "fail";
        JSONObject obj = new JSONObject();
        try {
        	basicLinkinvestor.setFlag(0);
        	if(StringUtils.isNotEmpty(basicLinkinvestor.getPkId())) {
        		basicLinkinvestorManager.saveOrUpdate(basicLinkinvestor);
        	} else {
        		basicLinkinvestorManager.save(basicLinkinvestor);
        	}
            obj.put("result", basicLinkinvestor.getPkId());
        } catch (Exception e) {
            obj.put("result", result);

        } finally {
           try {
                this.getResponse().getWriter().print(obj);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
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
    	basicLinkinvestorManager.update(this.basicLinkinvestor);
        return LIST_ACTION;
    }
    
    /**
     * ajax删除对象.
     * 
     * @return 重定向到列表页面.
     */
    public void deleteByAjax() {
    	String result = "fail";
        JSONObject obj = new JSONObject();
        try {
        	if (StringUtils.isNotBlank(pkId)) {
        		basicLinkinvestor.setFlag(1);
        		basicLinkinvestorManager.update(basicLinkinvestor);
            }
            obj.put("result", basicLinkinvestor.getPkId());
        } catch (Exception e) {
            obj.put("result", result);

        } finally {
           try {
                this.getResponse().getWriter().print(obj);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
    }
    
    /**
     * 通过ajax保存新增上级单位对象.
     * 
     * @return 重定向到列表页面.
     */
    public void saveDeptByAjax() {
    	String result = "fail";
        JSONObject obj = new JSONObject();
        try {
        	if(StringUtils.isNotEmpty(basicLinkinvestor.getPkId())) {
        		basicLinkinvestorManager.saveOrUpdate(basicLinkinvestor);
        	} else {
        		basicLinkinvestorManager.save(basicLinkinvestor);
        	}
            obj.put("result", basicLinkinvestor.getPkId());
        } catch (Exception e) {
            obj.put("result", result);

        } finally {
           try {
                this.getResponse().getWriter().print(obj);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    @Override
    public String getEctableId() {
        return "BasicLinkowner_list";
    }
    
    public String getKeyIds() {
		return keyIds;
	}

	public void setKeyIds(String keyIds) {
		this.keyIds = keyIds;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
    
    public String getZtreeIdAndPid() {
        return ztreeIdAndPid;
    }
    
    public void setZtreeIdAndPid(String ztreeIdAndPid) {
        this.ztreeIdAndPid = ztreeIdAndPid;
    }
 	
}
