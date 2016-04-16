package com.egouer.admin.auth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class Mainc {
	private static final Logger log = LoggerFactory.getLogger(Userc.class);
	@RequestMapping(method = RequestMethod.GET,value={"/","/index"})
	public ModelAndView index()
	{
		log.info("index view");
		return new ModelAndView("index");
	}
}
