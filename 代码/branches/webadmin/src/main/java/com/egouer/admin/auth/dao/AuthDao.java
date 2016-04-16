package com.egouer.admin.auth.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository(value="authDao")
public class AuthDao extends SqlSessionDaoSupport {
	@Resource(name="authSqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	@PostConstruct
	public void initSqlSession()
	{
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
}
