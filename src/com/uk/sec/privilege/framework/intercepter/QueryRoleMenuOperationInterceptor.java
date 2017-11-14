package com.uk.sec.privilege.framework.intercepter;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.uk.sec.framework.security.action.UserView;
import com.uk.sec.privilege.framework.privilege.dao.SecBasDicItemDao;
import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;

@SuppressWarnings("serial")
public class QueryRoleMenuOperationInterceptor extends AbstractInterceptor {

	private static final Logger logger = Logger.getLogger(QueryRoleMenuOperationInterceptor.class);

	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		UserView userView=(UserView)session.get(UserView.SESSION_USER_VIEW);
		// 如果用户还没有登录，则转到登录页面
		if(userView==null) {
			logger.info("You must Login the System first");
			return "/login.jsp";
		}
		String menuId=ServletActionContext.getRequest().getParameter("menuId");
		if(menuId != null){
			 String loginId=(String)userView.getLoginId();
			 WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
			//从spring的容器中拿出SecBasDicItemDao对象
			 SecBasDicItemDao secBasDicItemDao=(SecBasDicItemDao)ctx.getBean("secBasDicItemDao");
			 List<SecBasDicItem> secBasDicItemList=secBasDicItemDao.selectOperationByLoginIdMenuId(loginId, menuId);
			 userView.getUserData().put("roleMenuOperList", secBasDicItemList);
		}
		return invocation.invoke();
	}

}
