package com.egouer.admin.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @class 读取属性文件工具类
 * @date 2014/12/01
 * @author Administrator
 */
public class ReadProperties {

	private static Properties properties;
	
	public static Properties loadProp(String path)
	{
		synchronized (ReadProperties.class) {
			if(properties == null)
			{
				properties = new Properties();
				/**
				 * 支持读取多个属性文件
				 * 文件通过;号进行分隔
				 */
				String paths[] = path.split("\\;");
				if(paths.length > 0)
				{
					for(String s : paths)
					{
						try {
							properties.putAll(PropertiesLoaderUtils.loadAllProperties(s));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		return properties;
	}
}
