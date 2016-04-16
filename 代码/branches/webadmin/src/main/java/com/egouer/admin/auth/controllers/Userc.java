package com.egouer.admin.auth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RestController
public class Userc {
	private static final Logger log = LoggerFactory.getLogger(Userc.class);
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},value="login")
	public ModelAndView login(User user)
	{
		log.info("username:{},pwd:{}",user.getUsername(), user.getPassword());
		return new ModelAndView("login");
	}

}
