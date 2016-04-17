package com.egouer.admin.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @class spring操作工具类
 * @date 2014/12/01
 * @author sunlifan
 */
public class SpringContext {

	private volatile static ApplicationContext context = null;
	private final static String SPRING_FILE = "classpath:config/applicationContext.xml";
	
	public static Object getBean(String name)
	{
		synchronized (SpringContext.class) {
			if(context == null)
			{
				context = new FileSystemXmlApplicationContext(SPRING_FILE);
			}
		}
		return context.getBean(name);
		
	}
}
