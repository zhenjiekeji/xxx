/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.bns.client.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.bns.client.model.BasicTollplaza;
import com.uk.sec.bns.client.model.BasicTollstation;
import com.uk.sec.bns.client.service.BasicTollplazaManager;
import com.uk.sec.bns.client.service.BasicTollstationManager;
import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.framework.util.Constant;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenu;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeRoleMenuOper;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeMenuManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeRoleManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeRoleMenuOperManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author
 * @version 1.0
 * @since 1.0
 */

public class BasicTollstationAction extends BaseStruts2Action implements Preparable, ModelDriven {
	/**
	 * 默认多列排序,example: username desc,createTime asc.
	 */
	protected static final String DEFAULT_SORT_COLUMNS = null;
	/*
	 * 跳转地址.---------------START---------------
	 */
	/**
	 * 编辑页面.
	 */
	protected static final String EDIT_JSP = "/bns/client/BasicTollstation/edit.jsp";
	/**
	 * 查看页面.
	 */
	protected static final String INFO_JSP = "/bns/client/BasicTollstation/create.jsp";
	/*
	 * 跳转地址.---------------E N D---------------
	 */

	/*
	 * 重定向地址以!开头.---------------START---------------
	 */
	/**
	 * LIST_ACTION 跳转到列表页面.
	 */
	protected static final String LIST_ACTION = "!/bns/client/BasicTollstation/list.do" + NOTIFY_STATE;
	/*
	 * 重定向地址以!开头.---------------E N D---------------
	 */

	/*
	 * 内部成员定义.---------------START---------------
	 */
	/**
	 * manager.
	 */
	private BasicTollstationManager basicTollstationManager;
	
	@Autowired
	private BasicTollplazaManager basicTollplazaManager;

	@Autowired
	private SecPrivilegeMenuManager secPrivilegeMenuManager;
	

	@Autowired
	private SecPrivilegeRoleMenuOperManager secPrivilegeRoleMenuOperManager;
	
	@Autowired
	private SecPrivilegeRoleManager secPrivilegeRoleManager;

	/**
	 * model.
	 */
	private BasicTollstation basicTollstation = new BasicTollstation();
	//收费广场
	private List<BasicTollplaza> basicTollplazas = new ArrayList<BasicTollplaza>();

	/**
	 * id.
	 */
	java.lang.String pkId = null;
	/**
	 * items 删除记录id数组.
	 */
	private String keyIds;
	private String menuId;
	private String jsonarray;

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
			basicTollstation = new BasicTollstation();
		} else {
			basicTollstation = basicTollstationManager.getById(pkId);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public Object getModel() {
		return basicTollstation;
	}

	/**
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
	 * 
	 * @param manager
	 *            manager.
	 */
	public void setBasicTollstationManager(BasicTollstationManager basicTollstationManager) {
		this.basicTollstationManager = basicTollstationManager;
	}

	/**
	 * @param val
	 *            id.
	 */
	public void setPkId(java.lang.String val) {
		this.pkId = val;
	}

	/**
	 * 查看对象.
	 * 
	 * @return 查看页面.
	 */
	public String info() {
		String menuId = getMenuId();
		// 根据menuId查询数据库是否存在管理处信息
		Map paraMap = new HashMap();
		paraMap.put("menuId", menuId);
		paraMap.put("flag", 0);
		List<BasicTollstation> basicTollstationList = basicTollstationManager.findAllBy(paraMap);
		if (basicTollstationList.size() > 0) {
			basicTollstation = (BasicTollstation) basicTollstationList.get(0);
			//收费站信息
			Map paraMapRoad = new HashMap();
			paraMapRoad.put("tpTollstationPkid", basicTollstation.getPkId());
			basicTollplazas = basicTollplazaManager.findAllBy(paraMapRoad);
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
				basicTollstation = basicTollstationManager.findByProperty("pkId", pkId);
			}
			obj.put("result", basicTollstation);
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
	 * 保存新增对象.
	 * 
	 * @return 重定向到列表页面.
	 */
	public String save() {
		// 设置初始标志位
		basicTollstation.setFlag(0);
		basicTollstationManager.save(basicTollstation);
		// 保存menu表
		/*
		 * SecPrivilegeMenu secPrivilegeMenu = new SecPrivilegeMenu();
		 * secPrivilegeMenuManager.save(secPrivilegeMenu); //保存menu操作菜单表
		 * SecPrivilegeRoleMenuOper secPrivilegeRoleMenuOper = new
		 * SecPrivilegeRoleMenuOper();
		 * secPrivilegeRoleMenuOperManager.save(secPrivilegeRoleMenuOper);
		 */
		return INFO_JSP;
	}

	/**
	 * 保存新增收费广场对象.
	 * 
	 * @return 重定向到列表页面.
	 */
	public void saveTollplaza() {
		String result = "fail";
		JSONObject obj = new JSONObject();
		String menuId = getMenuId();
		//pkId
		BasicTollstation basicTollstation = basicTollstationManager.findByProperty("pkId", pkId);
		try {
			JSONArray json = JSONArray.fromObject(getJsonarray());
			String tsName = "";
			String plazaPkId = "";
			BasicTollplaza basicTollplaza = new BasicTollplaza();
			for (int i = 0; i < json.size(); i++) {
				JSONObject job = json.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				plazaPkId = (String)job.get("pkId");
				String tsCode = (String)job.get("tsCode");
				tsName = (String) job.get("tsName");
				int tsType = (int) job.get("tsType");
			    //收费广场老编号
				basicTollplaza.setOldCode(tsCode);
				basicTollplaza.setTpName(tsName);
				//收费广场类型
				basicTollplaza.setTpPlazatype(tsType);	
				basicTollplaza.setFlag(0);
				//为了使用关联关系，只能采用pkId
				basicTollplaza.setTpTollstationPkid(basicTollstation.getPkId());
				//if(StringUtils.isNotEmpty(plazaPkId)) {
					basicTollplaza.setPkId(plazaPkId);
					basicTollplazaManager.saveOrUpdate(basicTollplaza);
				/*} else {
					basicTollplazaManager.save(basicTollplaza);
				}*/
				
			}
			if(StringUtils.isEmpty(plazaPkId)) {
				SecPrivilegeMenu menuObject = secPrivilegeMenuManager.findByProperty("menuId", menuId);
				// 保存menu表
				SecPrivilegeMenu secPrivilegeMenu = new SecPrivilegeMenu();
				secPrivilegeMenu.setMenuTitle(tsName);
				secPrivilegeMenu.setMenuDescription("收费广场信息描述");
				secPrivilegeMenu.setMenuVieworder(menuObject.getMenuVieworder()+"0001");
				secPrivilegeMenu.setMenuUrl(Constant.BASIC_TOLL_PLAZA);
				secPrivilegeMenu.setMenuFlag(Short.parseShort("1"));
				secPrivilegeMenu.setMenuIsleaf(Short.parseShort("1"));
				secPrivilegeMenu.setParentId(menuId);
				secPrivilegeMenuManager.save(secPrivilegeMenu); // 保存menu操作菜单表
				//再次更新收费站信息
				basicTollplaza.setMenuId(secPrivilegeMenu.getMenuId());
				basicTollplazaManager.saveOrUpdate(basicTollplaza);
				//将菜单权限赋予相应的用户角色
				SecPrivilegeRoleMenuOper secPrivilegeRoleMenuOper = new SecPrivilegeRoleMenuOper();
				String roleName = (String)this.getUserView().getUserData().get("roleName");
				secPrivilegeRoleMenuOper.setRoleId(secPrivilegeRoleManager.findByProperty("roleName", roleName).getRoleId());
				secPrivilegeRoleMenuOper.setOperationId(Long.parseLong("0"));
				secPrivilegeRoleMenuOper.setMenuId(secPrivilegeMenu.getMenuId());
				secPrivilegeRoleMenuOperManager.save(secPrivilegeRoleMenuOper);
			}

			obj.put("result", "success");
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
			basicTollstation.setFlag(0);
			if (StringUtils.isNotEmpty(basicTollstation.getPkId())) {
				basicTollstationManager.saveOrUpdate(basicTollstation);
			} else {
				basicTollstationManager.save(basicTollstation);
			}
			obj.put("result", basicTollstation.getPkId());
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
	 * ajax删除对象.
	 * 
	 * @return 重定向到列表页面.
	 */
	public void deleteByAjax() {
		String result = "fail";
		JSONObject obj = new JSONObject();
		try {
			if (StringUtils.isNotBlank(pkId)) {
				basicTollstation.setFlag(1);
				basicTollstationManager.update(basicTollstation);
			}
			obj.put("result", basicTollstation.getPkId());
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
		return "BasicTollstation_list";
	}

	public String getKeyIds() {
		return keyIds;
	}

	public void setKeyIds(String keyIds) {
		this.keyIds = keyIds;
	}

	public String getJsonarray() {
		return jsonarray;
	}

	public void setJsonarray(String jsonarray) {
		this.jsonarray = jsonarray;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public BasicTollstationManager getBasicTollstationManager() {
		return basicTollstationManager;
	}

	public List<BasicTollplaza> getBasicTollplazas() {
		return basicTollplazas;
	}

	public void setBasicTollplazas(List<BasicTollplaza> basicTollplazas) {
		this.basicTollplazas = basicTollplazas;
	}

}
