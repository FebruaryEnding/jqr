package com.yao.jqr.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ContextUtils implements ApplicationContextAware {
    private static ThreadLocal<ContextData> contextDataThreadLocal = new ThreadLocal<ContextData>();

    private static ApplicationContext applicationContext;

    public static void setContexeData(ContextData contexeData) {
        contextDataThreadLocal.set(contexeData);
    }

    public static ContextData getContexeData() {
        ContextData contextData = contextDataThreadLocal.get();
        if (contextData == null) {
            contextDataThreadLocal.set(new ContextData());
        }
        return contextDataThreadLocal.get();
    }

    public static HttpServletRequest getRequest() {
        ContextData contextData = contextDataThreadLocal.get();
        return contextData != null ? contextData.getRequest() : null;
    }

    public static HttpServletResponse getResponse() {
        ContextData contextData = contextDataThreadLocal.get();
        return contextData != null ? contextData.getResponse() : null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
