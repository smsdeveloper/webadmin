package com.egouer.admin.base;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseService {

	private SqlSessionDaoSupport daoSupport;
	
	protected void setDaoSupport(SqlSessionDaoSupport daoSupport) {
		this.daoSupport = daoSupport;
	}


	/**
	 * 基于mybatis3的分页方法
	 * @param <T>
	 * @param sqlMap mybatis3 domain.xml的sql id
	 * @param baseObj domain对象
	 * @return list
	 * @since mybatis3.0
	 */
	
	protected <T> List<T> selectListByPage(String sqlMap,BaseObj baseObj)
	{
		int offset = 0;
		Long count = daoSupport.getSqlSession().selectOne(sqlMap + "Count", baseObj);
		count = count == null ? 0 : count;
		if(count < baseObj.getDatacount())
		{
			baseObj.setPagecount(1);
		}else{
			baseObj.setPagecount(count % baseObj.getPagesize() == 0 ? (count/baseObj.getPagecount()) : (count/baseObj.getPagesize() + 1));
		}
		offset = baseObj.getPageno() <= 1 ? 0 : (baseObj.getPageno() - 1) * baseObj.getPagesize();
		baseObj.setDatacount(count);
		baseObj.setOffset(offset);
		return daoSupport.getSqlSession().selectList(sqlMap, baseObj);
	}
}
