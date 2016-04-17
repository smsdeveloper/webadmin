package com.egouer.admin.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egouer.admin.auth.common.UserEnum;
import com.egouer.admin.auth.dao.AuthDao;
import com.egouer.admin.auth.domain.User;
import com.egouer.admin.utils.KeyedDigestMD5;

@Service(value="userService")
public class UserService {

	@Autowired
	private AuthDao authDao;
	
	/**
	 * 账户校验
	 * @return true 通过 false 不通过
	 */
	public boolean checkUser(User user)
	{
		user.setPassword(KeyedDigestMD5.getKeyedDigest(user.getPassword(), ""));
		user = authDao.getSqlSession().selectOne("checkUser", user);
		if(user != null && UserEnum.STATUS_OK.getStatus().equals(user.getStatus()))
		{
			return true;
		}
		return false;
	}
}
