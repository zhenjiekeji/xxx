/*
 * 版权所有 科技有限公司 Copyright(c) 2015 All Rights Reserved Project: waite
 * Author: 许振伟 Create Date: 2015-01-6下午04:41:54 Update Date: 2015-01-6下午04:41:54
 * Description:
 */
package com.uk.sec.framework.interceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.uk.sec.framework.annotation.Log;
import com.uk.sec.framework.log.LogController;


/**
 * @author xzw
 */
public class LogInterceptor implements MethodInterceptor {
    
    /*
     * (non-Javadoc)
     * 
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept
     *      .MethodInvocation)
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = invocation.proceed();
        Log log = invocation.getMethod().getAnnotation(Log.class);
        if (log == null) {
            return result;
        }
        String model = log.model();
        String title = log.title();
        String method = log.method();
        String msg = log.msg();
        Object[] args = invocation.getArguments();
        for (int i = 0; args != null && i < args.length; i++) {
            Object o = args[i];
            if (o == null) {
                continue;
            }
            String regex = "[%" + i + "]";
            msg = msg.replace(regex, o.toString());
            while (msg.contains(regex)) {
                msg = msg.replace(regex, o.toString());
            }
        }
        
        // 记录日志信息
        LogController.log(model, title, method, msg, LogController.PRIORITY_INFO);
        return result;
    }
}
