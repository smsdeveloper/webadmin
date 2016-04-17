package com.egouer.admin.utils;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.egouer.admin.auth.common.AuthContants;
import com.egouer.admin.auth.vo.SessionBean;

/**
 * session工具类
 * @description 
 * @author lifan.sun
 * @version 
 * @since 
 * @date 2016年4月17日
 */
public class SessionUtil {

	private static final Logger log = LoggerFactory.getLogger(SessionUtil.class);
	private static final long SESSON_TIMEOUT = 20*60*1000;
	private static final String SESSION_KEY = "session_key";
	private static final int COOKIE_AGE = 24*60*1000*60*7;
	/**
	 * 保存session到缓存数据库中
	 * @param sessionBean
	 * @throws UnsupportedEncodingException 
	 */
	public static Cookie putSession(SessionBean sessionBean) throws UnsupportedEncodingException
	{
		String key = UUID.randomUUID().toString().replaceAll("-", "");
		RedisUtil redisUtil = (RedisUtil)SpringContext.getBean("redisUtil");
		String json = JSON.toJSONString(sessionBean);
		String value = Base64.encodeBase64String(json.getBytes("utf-8"));
		redisUtil.setEx(key, SESSON_TIMEOUT, value);
		Cookie cookie = new Cookie(SESSION_KEY, key);
		cookie.setMaxAge(COOKIE_AGE);
		cookie.setDomain(AuthContants.COOKIE_DOMAIN);
		cookie.setPath("/");
		log.info("用户登录：{}，{}",key, json);
		return cookie;
	}
	/**
	 * 获取session
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static SessionBean getSession(HttpServletRequest request) throws UnsupportedEncodingException
	{
		Cookie[] cookies = request.getCookies();
		String value = null;
		for(Cookie cookie : cookies)
		{
			if(cookie.getName().equals(SESSION_KEY))
			{
				value = cookie.getValue();
				break;
			}
		}
		if(StringUtils.isNotEmpty(value))
		{
			RedisUtil redisUtil = (RedisUtil)SpringContext.getBean("redisUtil");
			String session = new String(Base64.decodeBase64(redisUtil.get(value)),"utf-8");
			return JSON.parseObject(session, SessionBean.class);
		}
		return null;
	}
}
