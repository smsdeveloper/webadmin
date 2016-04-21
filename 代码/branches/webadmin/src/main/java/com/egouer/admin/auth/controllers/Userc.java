package com.egouer.admin.auth.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @description 用户控制器
 * @author lifan.sun
 * @version 
 * @since 
 * @date 2016年4月17日
 */
import org.springframework.web.servlet.ModelAndView;

import com.egouer.admin.auth.domain.User;
import com.egouer.admin.auth.services.UserService;
import com.egouer.admin.base.BaseController;
import com.egouer.admin.utils.JsonResult;
import com.egouer.admin.utils.SessionUtil;
import com.egouer.admin.utils.SpringContext;
@RestController
public class Userc extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(Userc.class);
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},value="login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,Model model,User user)
	{
		this.setPath("login");
		log.info("username:{},pwd:{}",user.getUsername(), user.getPassword());
		try{
			UserService userService = (UserService)SpringContext.getBean("userService");
			if(userService.isRelogin(request))
			{
				this.setPath("redirect:index");
				return this.toView();
			}
			if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword()))
			{
				return this.toView();
			}
			if(userService.checkUser(request,response,user))
			{
				this.setPath("redirect:index");
				return this.toView();
			}
			model.addAttribute(ERROR_MSG, "登录失败，帐号错误");
		}catch (Exception e){
			log.error(e.getMessage(),e);
			model.addAttribute(ERROR_MSG, e.getMessage());
		}
		return this.toView();
	}
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},value="auth/usermanage")
	public ModelAndView userManage()
	{
		this.setPath("auth/userlist");
		return this.toView();
	}
	/**
	 * 用户列表
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,value="auth/userlist")
	public JsonResult userList(User user)
	{
		UserService userService = (UserService)SpringContext.getBean("userService");
		try{
			List<User> list = userService.selectUserListPage(user);
			this.setJsonResult(JsonResult.Result.RESULT_SUCCESS.getResult(), JsonResult.Result.RESULT_SUCCESS.getMsg(), "0", list, (int)user.getDatacount());
		} catch (Exception e){
			log.error(e.getMessage(),e);
			this.setJsonResult(JsonResult.Result.RESULT_ERROR.getResult(), JsonResult.Result.RESULT_ERROR.getMsg(), "0", null, 0);
		}
		return this.getJsonResult();
	}
	/**
	 * 注销
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},value="logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		this.setPath("redirect:login");
		SessionUtil.removeSession(request);
		
		return this.toView();
	}

}
