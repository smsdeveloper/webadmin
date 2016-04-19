package com.egouer.admin.auth.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.egouer.admin.auth.domain.Menu;
import com.egouer.admin.auth.services.MenuService;
import com.egouer.admin.auth.vo.SessionBean;
import com.egouer.admin.base.BaseController;
import com.egouer.admin.utils.SessionUtil;
import com.egouer.admin.utils.SpringContext;


@RestController
public class Mainc extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(Userc.class);
	@RequestMapping(method = RequestMethod.GET,value={"/","/index"})
	public ModelAndView index(HttpServletRequest request,Model model)
	{
		log.info("index view");
		try {
			SessionBean sessionBean = SessionUtil.getSession(request);
			MenuService menuService = (MenuService)SpringContext.getBean("menuService");
			List<Menu> menuList = menuService.selectMenusByRoleCode(sessionBean.getUser());
			model.addAttribute("menuList", menuList);
			model.addAttribute("user", sessionBean.getUser());
			this.setPath("index");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(),e);
			this.setPath("login");
		}
		return this.toView();
	}
}
