package com.egouer.admin.auth.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.egouer.admin.auth.domain.Function;
import com.egouer.admin.auth.vo.SessionBean;
import com.egouer.admin.utils.SessionUtil;


/**
 * @description 权限控制拦截器
 * @author lifan.sun
 * @since 1.0
 * @version 1.0
 * @date 2016-03-26
 */

public class PermissionInterceptor implements HandlerInterceptor {

	private static final Logger log = LoggerFactory.getLogger(PermissionInterceptor.class);
	private static final String HTML_SUFFIX = ".html";
	private static final String LOGIN_ACTION = "/login";

	/**
	 * 进入controller之前处理 1.校验session会话 2.判读操作员状态 3.拦截控制器权限
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if (request.getRequestURI().endsWith(HTML_SUFFIX) || request.getRequestURI().endsWith(LOGIN_ACTION)) {
			/*
			 * 对html页面或登录页面不进行拦截
			 */
			return true;
		}
		String context = request.getContextPath();
		String urlPath = request.getRequestURI().replaceFirst(context, "");
		urlPath = urlPath.indexOf(".") != -1 ? urlPath.substring(0, urlPath.lastIndexOf(".")) : urlPath;
		log.info("the context:{} request url:{}", context, urlPath);
		try {
			SessionBean sessionBean = SessionUtil.getSession(request);
			if (sessionBean == null) {
				log.info("session error:{}", request.getParameterMap());
				response.sendRedirect(LOGIN_ACTION);
				return false;
			}
			/**
			 * 权限控制
			 */
			if(sessionBean.getFunctions() == null)
			{
				response.sendRedirect(LOGIN_ACTION);
				return false;
			}
			int i = 0;
			for(Function function : sessionBean.getFunctions())
			{
				if(function.getFunctiontype().equals("权限") && 
						function.getFunctionurl().equals(urlPath))
				{
					i++;
				}
			}
			if(i == 0)
			{
				response.sendRedirect(LOGIN_ACTION);
				return false;
			}
			// 根据用户ID获取权限匹配的菜单信息
		} catch (Exception e) {
			log.error("premission error", e);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
