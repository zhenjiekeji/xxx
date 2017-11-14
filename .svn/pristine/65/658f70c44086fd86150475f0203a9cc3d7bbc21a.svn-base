package com.uk.sec.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于日志的Annotation，只要service层的方法具有这个Annotation，就会被日志拦截器记录 用法：
 * 
 * @Log(model = "请求", title = "删除请求", method = "deleteRequest", msg
 *            ="删除id为[%0]的数据") 其中%0对应被标注的方法的参数编号
 *            ，从0开始，日志拦截器会调用toString方法获取参数的文本信息记录到日志中
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String model();
    
    String title();
    
    String method();
    
    String msg();
}
