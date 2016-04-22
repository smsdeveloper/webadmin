package com.egouer.admin.utils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.egouer.admin.auth.domain.User;

public class CheckUtil {

	/**
	 * 校验类中字段是否为空
	 * @param object
	 * @param fields
	 * @return
	 * @throws Exception 
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void checkFields(Object object,String fields[]) throws Exception
	{
		try{
			for(String name : fields)
			{
				if(StringUtils.isEmpty(BeanUtils.getProperty(object, name)))
				{
					throw new Exception(name+"不能为空");
				}
			}
		}catch (Exception e){
			throw e;
		}
	}
	
	public static void main(String[] args) {
		User user = new User();
		try {
			CheckUtil.checkFields(user, new String[]{"username"});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
