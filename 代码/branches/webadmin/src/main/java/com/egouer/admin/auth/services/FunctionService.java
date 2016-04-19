package com.egouer.admin.auth.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egouer.admin.auth.dao.AuthDao;
import com.egouer.admin.auth.domain.Function;
import com.egouer.admin.auth.domain.RoleFunction;
import com.egouer.admin.auth.domain.User;
import com.egouer.admin.auth.domain.UserRole;

@Service
public class FunctionService {

	@Autowired
	private AuthDao authDao;
	
	/**
	 * 根据用户获取功能列表
	 * @param user
	 * @return
	 */
	public List<Function> selectFuntionListByUserId(User user)
	{
		UserRole userRole = new UserRole();
		userRole.setUserid(user.getUserid());
		/**
		 * 查询用户所属的角色列表
		 */
		List<UserRole> userRoleList = authDao.getSqlSession().selectList("selectListByUserId", userRole);
		if(userRoleList == null || userRoleList.isEmpty())
		{
			return null;
		}
		List<Function> functions = new ArrayList<Function>();
		for(UserRole role : userRoleList)
		{
			RoleFunction roleFunction = new RoleFunction();
			roleFunction.setRolecode(role.getRolecode());
			/**
			 * 查询用户角色编号对应的功能列表
			 */
			List<RoleFunction> roleFunctionList = authDao.getSqlSession().selectList("selectListByRoleCode", roleFunction);
			if(roleFunctionList == null || roleFunctionList.isEmpty())
			{
				continue;
			}
			for(RoleFunction roleFun : roleFunctionList)
			{
				/**
				 * 组装功能列表
				 */
				Function function = new Function();
				function.setFunctioncode(roleFun.getFunctioncode());
				function.setStatus("正常");
				function = authDao.getSqlSession().selectOne("selectFunction", function);
				functions.add(function);
			}
		}
		return functions;
	}
}
