/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.bns.client.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.uk.sec.bns.client.model.BasicInvestorOwner;
import com.uk.sec.bns.client.model.BasicLinkinvestor;
import com.uk.sec.bns.client.model.BasicLinkowner;
import com.uk.sec.bns.client.model.BasicSection;
import com.uk.sec.bns.client.model.Tree;
import com.uk.sec.bns.client.service.BasicInvestorOwnerManager;
import com.uk.sec.bns.client.service.BasicLinkinvestorManager;
import com.uk.sec.bns.client.service.BasicLinkownerManager;
import com.uk.sec.bns.client.service.BasicSectionManager;
import com.uk.sec.bns.client.service.RoadManager;
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

public class BasicLinkownerAction extends BaseStruts2Action implements Preparable, ModelDriven {
	/**
	 * 默认多列排序,example: username desc,createTime asc.
	 */
	protected static final String DEFAULT_SORT_COLUMNS = null;
	/*
	 * 跳转地址.---------------START---------------
	 */
	/**
	 * 列表页面.
	 */
	protected static final String MAIN_JSP = "/bns/client/BasicLinkowner/main.jsp";
	/**
	 * 编辑页面.
	 */
	protected static final String EDIT_JSP = "/bns/client/BasicLinkowner/edit.jsp";
	/**
	 * 查看页面.
	 */
	protected static final String INFO_JSP = "/bns/client/BasicLinkowner/create.jsp";
	/*
	 * 跳转地址.---------------E N D---------------
	 */

	/*
	 * 重定向地址以!开头.---------------START---------------
	 */
	/**
	 * LIST_ACTION 跳转到列表页面.
	 */
	protected static final String LIST_ACTION = "!/bns/client/BasicLinkowner/list.do" + NOTIFY_STATE;
	/*
	 * 重定向地址以!开头.---------------E N D---------------
	 */

	/*
	 * 内部成员定义.---------------START---------------
	 */
	/**
	 * manager.
	 */
	private BasicLinkownerManager basicLinkownerManager;

	@Autowired
	private BasicLinkinvestorManager basicLinkinvestorManager;

	@Autowired
	private BasicInvestorOwnerManager basicInvestorOwnerManager;

	@Autowired
	private BasicSectionManager basicSectionManager;

	@Autowired
	private RoadManager roadManager;

	@Autowired
	private SecPrivilegeMenuManager secPrivilegeMenuManager;

	@Autowired
	private SecPrivilegeRoleMenuOperManager secPrivilegeRoleMenuOperManager;
	
	@Autowired
	private SecPrivilegeRoleManager secPrivilegeRoleManager;

	/**
	 * model.
	 */
	private BasicLinkowner basicLinkowner = new BasicLinkowner();
	private List<BasicSection> basicSections = new ArrayList<BasicSection>();
	private BasicLinkinvestor basicLinkinvestor;

	/**
	 * id.
	 */
	java.lang.String pkId = null;
	/**
	 * items 删除记录id数组.
	 */
	private String keyIds;
	private String menuId;
	private String liPkId;
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
			basicLinkowner = new BasicLinkowner();
		} else {
			basicLinkowner = basicLinkownerManager.getById(pkId);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public Object getModel() {
		return basicLinkowner;
	}

	/**
	 * 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写
	 * 
	 * @param manager
	 *            manager.
	 */
	public void setBasicLinkownerManager(BasicLinkownerManager basicLinkownerManager) {
		this.basicLinkownerManager = basicLinkownerManager;
	}

	/**
	 * @param val
	 *            id.
	 */
	public void setPkId(java.lang.String val) {
		this.pkId = val;
	}

	public String getLiPkId() {
		return liPkId;
	}

	public void setLiPkId(String liPkId) {
		this.liPkId = liPkId;
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
		SecPrivilegeMenu secPrivilegeMenu = secPrivilegeMenuManager.findByProperty("menuId", menuId);
		basicLinkowner.setLoName(secPrivilegeMenu.getMenuTitle());
		// 根据menuId查询数据库是否存在管理处信息
		Map paraMap = new HashMap();
		paraMap.put("menuId", menuId);
		paraMap.put("flag", 0);
		List<BasicLinkowner> basicLinkownerList = basicLinkownerManager.findAllBy(paraMap);
		if (basicLinkownerList.size() > 0) {
			basicLinkowner = (BasicLinkowner) basicLinkownerList.get(0);
			// 关联关系查询
			BasicInvestorOwner tempBasicInvestorOwner = basicInvestorOwnerManager.findByProperty("loPkId",
					basicLinkowner.getPkId());
			// 上级单位pkId
			if (tempBasicInvestorOwner != null) {
				String liPkId = tempBasicInvestorOwner.getLiPkId();
				BasicLinkinvestor basicLinkinvestor = basicLinkinvestorManager.findByProperty("pkId", liPkId);
				basicLinkowner.setBasicLinkinvestor(basicLinkinvestor);
			}
			//路段信息
			Map paraMapRoad = new HashMap();
			paraMapRoad.put("seSectionownerId", basicLinkowner.getPkId());
			basicSections = basicSectionManager.findAllBy(paraMapRoad);
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
				basicLinkowner = basicLinkownerManager.findByProperty("pkId", pkId);
			}
			obj.put("result", basicLinkowner);
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
		basicLinkowner.setFlag(0);
		basicLinkowner.setLoProvinceCode("13");
		basicLinkownerManager.save(basicLinkowner);
		// 更新menu表(管理处名称与menutitle一致)
		String menuId = getMenuId();
		SecPrivilegeMenu secPrivilegeMenu = secPrivilegeMenuManager.findByProperty("menuId", menuId);
		secPrivilegeMenu.setMenuTitle(basicLinkowner.getLoName());
		secPrivilegeMenuManager.saveOrUpdate(secPrivilegeMenu); //保存menu操作菜单表
		return INFO_JSP;
	}

	/**
	 * 保存新增公路对象.
	 * 
	 * @return 重定向到列表页面.
	 */
	public void saveSection() {
		String result = "fail";
		JSONObject obj = new JSONObject();
		String menuId = getMenuId();
		//pkId
		BasicLinkowner basicLinkowner = basicLinkownerManager.findByProperty("pkId", pkId);
		try {
			JSONArray json = JSONArray.fromObject(getJsonarray());
			BasicSection basicSection = new BasicSection();
			String seName = "";
			String sectionId = "";
			for (int i = 0; i < json.size(); i++) {
				JSONObject job = json.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				sectionId = (String)job.get("pkId");
				seName = (String) job.get("trName");
				String seStartstakenum = (String) job.get("seStartstakenum");
				String seEndstakenum = (String) job.get("seEndstakenum");
				basicSection.setSeName(seName);
				//路段起止桩号
				basicSection.setSeStartstakenum(seStartstakenum);
				basicSection.setSeEndstakenum(seEndstakenum);
				//设置标志
				basicSection.setFlag(0);
				//为了使用关联关系，只能采用pkId
				basicSection.setPkId(sectionId);
				basicSection.setSeSectionownerId(basicLinkowner.getPkId());
				basicSectionManager.saveOrUpdate(basicSection);
			}
			SecPrivilegeMenu menuObject = secPrivilegeMenuManager.findByProperty("menuId", menuId);
			// 保存menu表
			SecPrivilegeMenu secPrivilegeMenu = new SecPrivilegeMenu();
			//路段信息名称
			secPrivilegeMenu.setMenuTitle(seName);
			secPrivilegeMenu.setMenuDescription("路段信息描述");
			secPrivilegeMenu.setMenuVieworder(menuObject.getMenuVieworder()+"0001");
			secPrivilegeMenu.setMenuUrl(Constant.BASIC_SECTION);
			secPrivilegeMenu.setMenuFlag(Short.parseShort("1"));
			secPrivilegeMenu.setMenuIsleaf(Short.parseShort("1"));
			secPrivilegeMenu.setParentId(menuId);
			secPrivilegeMenuManager.save(secPrivilegeMenu); // 保存menu操作菜单表
			//再次更新路段信息，将menuId更新到表中
			basicSection.setMenuId(secPrivilegeMenu.getMenuId());
			basicSectionManager.saveOrUpdate(basicSection);
			//将菜单权限赋给对应的用户角色
			SecPrivilegeRoleMenuOper secPrivilegeRoleMenuOper = new SecPrivilegeRoleMenuOper();
			String roleName = (String)this.getUserView().getUserData().get("roleName");
			secPrivilegeRoleMenuOper.setRoleId(secPrivilegeRoleManager.findByProperty("roleName", roleName).getRoleId());
			secPrivilegeRoleMenuOper.setOperationId(Long.parseLong("0"));
			secPrivilegeRoleMenuOper.setMenuId(secPrivilegeMenu.getMenuId());
			secPrivilegeRoleMenuOperManager.save(secPrivilegeRoleMenuOper);

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
			basicLinkowner.setFlag(0);
			basicLinkowner.setLoProvinceCode("13");
			if(StringUtils.isNotEmpty(basicLinkowner.getPkId())) {
				basicLinkownerManager.update(basicLinkowner);
			} else {
				basicLinkownerManager.save(basicLinkowner);
			}	    
			// 更新menu表(管理处名称与menutitle一致)
			String menuId = getMenuId();
			SecPrivilegeMenu secPrivilegeMenu = secPrivilegeMenuManager.findByProperty("menuId", menuId);
			secPrivilegeMenu.setMenuTitle(basicLinkowner.getLoName());
			secPrivilegeMenuManager.saveOrUpdate(secPrivilegeMenu); //保存menu操作菜单表
			
			obj.put("result", basicLinkowner.getPkId());
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
				basicLinkowner.setFlag(1);
				basicLinkownerManager.update(basicLinkowner);
			}
			obj.put("result", basicLinkowner.getPkId());
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
		String liPkId = getLiPkId();
		basicLinkinvestor.setFlag(0);
		try {
			if (StringUtils.isNotEmpty(liPkId)) {
				basicLinkinvestor.setPkId(liPkId);
				basicLinkinvestorManager.saveOrUpdate(basicLinkinvestor);
			} else {
				basicLinkinvestorManager.save(basicLinkinvestor);
				// 创建关联关系
				BasicInvestorOwner basicInvestorOwner = new BasicInvestorOwner();
				basicInvestorOwner.setLiPkId(basicLinkinvestor.getPkId());
				basicInvestorOwner.setLoPkId(basicLinkowner.getPkId());
				basicInvestorOwner.setIvOperate(Constant.IV_OPERATE_ONE);
				String loginName = (String) this.getUserView().getLoginName();
				basicInvestorOwner.setIvOperator(loginName);
				basicInvestorOwner.setIvOperatetime(new Date());
				basicInvestorOwnerManager.save(basicInvestorOwner);
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
	 * 异步获取管理处公路树
	 * 
	 * @throws Exception
	 */
	public void getRoadTreeByTreeByAsyn() throws Exception {
		//String id = this.getRequest().getParameter("id");
		List<Tree> treeList = roadManager.getRoadTreeList();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(treeList);
		this.getResponse().getWriter().print(jsonString);
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

	public List<BasicSection> getBasicSections() {
		return basicSections;
	}

	public void setBasicSections(List<BasicSection> basicSections) {
		this.basicSections = basicSections;
	}

	public BasicLinkinvestor getBasicLinkinvestor() {
		return basicLinkinvestor;
	}

	public void setBasicLinkinvestor(BasicLinkinvestor basicLinkinvestor) {
		this.basicLinkinvestor = basicLinkinvestor;
	}

	public BasicLinkownerManager getBasicLinkownerManager() {
		return basicLinkownerManager;
	}

}
