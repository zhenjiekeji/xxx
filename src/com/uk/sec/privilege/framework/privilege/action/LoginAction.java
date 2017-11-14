package com.uk.sec.privilege.framework.privilege.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.ServletActionContext;

import com.uk.sec.framework.base.BaseStruts2Action;
import com.uk.sec.framework.security.action.UserView;
import com.uk.sec.framework.security.util.SecurityUtils;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeMenu;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeRole;
import com.uk.sec.privilege.framework.privilege.model.SecPrivilegeUser;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeMenuManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeRoleManager;
import com.uk.sec.privilege.framework.privilege.service.SecPrivilegeUserManager;

@SuppressWarnings( { "serial", "unchecked" })
public class LoginAction extends BaseStruts2Action {

	/**
	 * 登录界面.
	 */
	protected static final String LOGIN_JSP = "/login.jsp";

	/**
	 * 管理处主界面.
	 */
   protected static final String CLIENTMAINFRAME_JSP = "!/bns/client/BasicLinkowner/main.do";
   /**
	 * 管理处审核主界面.
	 */
  protected static final String CLIENTMAINFRAME_Z_JSP = "!/bns/client/BasicLinkowner/list.do";
	/**
	 * 后台管理员主界面.
	 */
	protected static final String MAINFRAME_JSP = "/mainFrame.jsp";
	/**
	 * LOGIN_FRAME 跳转界面,便于portal登陆时链接地址发生转化,防止直接登陆系统
	 */
	protected static final String LOGIN_INDEX_JSP = "/index.jsp";

	private SecPrivilegeUserManager secPrivilegeUserManager;
	private SecPrivilegeMenuManager secPrivilegeMenuManager;
	private SecPrivilegeRoleManager secPrivilegeRoleManager;

	private final SecPrivilegeUser secPrivilegeUser = new SecPrivilegeUser();
	private String loginName;
	private String passwd;
	private Integer isOnlyViewMedical; // 是否只展示跟医疗模块有关的数据

	/**
	 * @Description 
	 *              获取登陆用户权限和权限对应的菜单信息、用户所在部门信息等，放到userView中，与登陆用户信息一并放在session中，
	 *              用于前台显示
	 */

	public String login() {
		if (this.loginName == null || this.passwd == null) {
			return LOGIN_JSP;
		}

		secPrivilegeUser.setLoginName(this.loginName);
		secPrivilegeUser.setPasswd(SecurityUtils.encoderByMd5(this.passwd));

		logger.info("loginName:" + secPrivilegeUser.getLoginName());
		logger.info("passwd:" + secPrivilegeUser.getPasswd());

		List<SecPrivilegeUser> userList = secPrivilegeUserManager
				.findUserByLoginNameAndPd(secPrivilegeUser);
		if (userList == null || userList.isEmpty()) {
			this.getRequest().setAttribute("errorMessage", "用户名或密码错误，请重新输入！");
			return LOGIN_JSP;
		}
		// 得到用户登陆ID并执行查询,对查询到的所有菜单做分组操作
		String loginId = userList.get(0).getLoginId();
		List<SecPrivilegeRole> secPrivilegeRoleList = secPrivilegeRoleManager
				.selectUserRoleList(loginId);
		// 如果查询出来的角色列表为空，则返回登录页面提示：请对该用户分配相应的角色及菜单！
		if (secPrivilegeRoleList == null || secPrivilegeRoleList.isEmpty()) {
			this.getRequest().setAttribute("errorMessage", "请对该用户分配相应的权限及菜单！");
			return LOGIN_JSP;
		}
		// 循环取出角色信息
		String roleName = "";
		for (SecPrivilegeRole role : secPrivilegeRoleList) {
			roleName = role.getRoleName();
		}
		List<SecPrivilegeMenu> secPrivilegeMenuList = secPrivilegeMenuManager
				.findAllMenuByLoginId(loginId);
		// 如果查询出来的菜单列表为空，则返回登录页面提示：请对该用户对应的角色分配相应的菜单！
		if (secPrivilegeMenuList == null || secPrivilegeMenuList.isEmpty()) {
			this.getRequest()
					.setAttribute("errorMessage", "请对该用户关联的角色分配相应的菜单！");
			return LOGIN_JSP;
		}

		UserView userView = new UserView(userList.get(0));

		// 循环得到的所有菜单，找出一级菜单在头部显示，其他的分别划分到对应的父级菜单，并在左侧显示
		List<SecPrivilegeMenu> topDisplayMenu = new ArrayList<SecPrivilegeMenu>();
		for (SecPrivilegeMenu m : secPrivilegeMenuList) {
			if (isNullOrEmptyString(m.getParentId())
					&& m.getMenuVieworder().length() == m.MENU_VIEWORDER_LEVEL) {
				// 得到所有的一级菜单，在头部显示
				topDisplayMenu.add(m);
			}
		}
		// 二级菜单
		Map<String, List<SecPrivilegeMenu>> secondLevelMenus = new TreeMap<String, List<SecPrivilegeMenu>>();
		Map<String, List<SecPrivilegeMenu>> thirdLevelMenus = new TreeMap<String, List<SecPrivilegeMenu>>();

		for (SecPrivilegeMenu topMenu : topDisplayMenu) {
			List<SecPrivilegeMenu> newSecMenu = new ArrayList<SecPrivilegeMenu>();
			List<SecPrivilegeMenu> menuList = secPrivilegeMenuManager
					.findMenuByLoginIdAndParentId(loginId, topMenu.getMenuId());
			if (!isNullOrEmptyString(menuList) && menuList.size() > 0) {

				for (SecPrivilegeMenu secMenu : menuList) {
					// 判断是否存在三级菜单
					List<SecPrivilegeMenu> thirdMenuList = secPrivilegeMenuManager
							.findMenuByLoginIdAndParentId(loginId, secMenu
									.getMenuId());
					if (thirdMenuList.size() > 0) {
						thirdLevelMenus.put(secMenu.getMenuId(), thirdMenuList);
						secMenu.setMenuHaveson(true);
					} else {
						secMenu.setMenuHaveson(false);
					}

					newSecMenu.add(secMenu);
				}
				secondLevelMenus.put(topMenu.getMenuVieworder(), newSecMenu);
			}
		}

		Map<String, Object> userData = new HashMap<String, Object>();
		// 把查询到的菜单信息放到map中
		userData.put("topDisplayMenu", topDisplayMenu);
		userData.put("secondLevelMenus", secondLevelMenus);
		userData.put("thirdLevelMenus", thirdLevelMenus);

		// 把查询到的部门名称信息放到map中
		userData.put("roleName", roleName);
		// 把isOnlyViewMedical放到map中
		userData.put("isOnlyViewMedical", this.isOnlyViewMedical);
		// 如需向session中存放其他用户相关信息，则使用 userData.put(<String>,<Object>)...
		userView.setUserData(userData);
		this.setUserView(userView);
		return LOGIN_INDEX_JSP;
	}

	public String loginFrame() {
		String roleName = (String) this.getUserView().getUserData().get(
				"roleName");
		if ("操作员".equals(roleName)) {
			return CLIENTMAINFRAME_JSP;
		} else if ("管理处".equals(roleName)) {
			return CLIENTMAINFRAME_Z_JSP;
		} else if ("系统管理员".equals(roleName)) {
			return MAINFRAME_JSP;
		} else {
			this.getRequest().setAttribute("errorMessage", "该用户没有操作权限！");
			return LOGIN_INDEX_JSP;
		}
	}

	public String loginOut() {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN_JSP;
	}

	public void setSecPrivilegeUserManager(
			SecPrivilegeUserManager secPrivilegeUserManager) {
		this.secPrivilegeUserManager = secPrivilegeUserManager;
	}

	public void setSecPrivilegeMenuManager(
			SecPrivilegeMenuManager secPrivilegeMenuManager) {
		this.secPrivilegeMenuManager = secPrivilegeMenuManager;
	}

	public void setSecPrivilegeRoleManager(
			SecPrivilegeRoleManager secPrivilegeRoleManager) {
		this.secPrivilegeRoleManager = secPrivilegeRoleManager;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setIsOnlyViewMedical(Integer isOnlyViewMedical) {
		this.isOnlyViewMedical = isOnlyViewMedical;
	}
}
