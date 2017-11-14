package com.uk.sec.privilege.framework.intercepter;

import java.util.Map;

import org.apache.log4j.Logger;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.uk.sec.framework.security.action.UserView;

@SuppressWarnings("serial")
public class CheckLoginInterceptor extends AbstractInterceptor {

	private static final Logger logger = Logger.getLogger(CheckLoginInterceptor.class);

	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		UserView userView=(UserView)session.get(UserView.SESSION_USER_VIEW);
		// 如果用户还没有登录，则转到登录页面
		if(userView==null) {
			logger.info("You must Login the System first");
			return "/login.jsp";
		}
		return invocation.invoke();
	}

}
