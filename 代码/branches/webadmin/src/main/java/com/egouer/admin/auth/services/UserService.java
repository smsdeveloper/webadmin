package com.egouer.admin.auth.services;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egouer.admin.auth.common.UserEnum;
import com.egouer.admin.auth.dao.AuthDao;
import com.egouer.admin.auth.domain.Function;
import com.egouer.admin.auth.domain.RoleFunction;
import com.egouer.admin.auth.domain.User;
import com.egouer.admin.auth.domain.UserRole;
import com.egouer.admin.auth.vo.SessionBean;
import com.egouer.admin.base.BaseService;
import com.egouer.admin.utils.DateUtils;
import com.egouer.admin.utils.KeyedDigestMD5;
import com.egouer.admin.utils.SessionUtil;

@Service(value="userService")
public class UserService extends BaseService{

	@Autowired
	private AuthDao authDao;
	
	public AuthDao getAuthDao() {
		return authDao;
	}
	public void setAuthDao(AuthDao authDao) {
		this.authDao = authDao;
	}
	/**
	 * 校验是否已经登录过
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean isRelogin(HttpServletRequest request) throws UnsupportedEncodingException
	{
		if(SessionUtil.getSession(request) != null)
		{
			/**
			 * 存在session会话，则直接进入首页
			 */
			return true;
		}
		return false;
	}
	/**
	 * 账户校验
	 * @return true 通过 false 不通过
	 * @throws UnsupportedEncodingException 
	 */
	public boolean checkUser(HttpServletRequest request,HttpServletResponse response,User user) throws UnsupportedEncodingException
	{
		user.setStatus(UserEnum.STATUS_OK.getStatus());
		user.setPassword(KeyedDigestMD5.getKeyedDigest(user.getPassword(), "").toLowerCase());
		user = authDao.getSqlSession().selectOne("checkUser", user);
		if(user != null && UserEnum.STATUS_OK.getStatus().equals(user.getStatus()))
		{
			/**
			 * 登录成功 存放session
			 */
			SessionBean sessionBean = new SessionBean();
			sessionBean.setLoginTime(DateUtils.strDate("yyyy-MM-dd HH:mm:ss"));
			sessionBean.setUser(user);
			sessionBean.setIp(this.getRemortIP(request));
			
			UserRole userRole = new UserRole();
			userRole.setUserid(user.getUserid());
			List<UserRole> userRoles = this.authDao.getSqlSession().selectList("selectListByUserId", userRole);
			List<Function> functions = new ArrayList<Function>();
			for(UserRole role : userRoles)
			{
				RoleFunction roleFunction = new RoleFunction();
				roleFunction.setRolecode(role.getRolecode());
				List<RoleFunction> roleFunctions = this.authDao.getSqlSession().selectList("selectListByRoleCode", roleFunction);
				for(RoleFunction rfun : roleFunctions)
				{
					Function function = new Function();
					function.setFunctioncode(rfun.getFunctioncode());
					function.setStatus("正常");
					function = this.getAuthDao().getSqlSession().selectOne("selectFunction", function);
					functions.add(function);
				}
			}
			sessionBean.setFunctions(functions);
			Cookie cookie = SessionUtil.putSession(sessionBean);
			response.addCookie(cookie);
			return true;
		}
		return false;
	}
	
	/**
	 * 获取真实IP地址
	 * @param request
	 * @return
	 */
	private String getRemortIP(HttpServletRequest request) {  
	    if (request.getHeader("x-forwarded-for") == null) {  
	        return request.getRemoteAddr();  
	    }  
	    String ips = request.getHeader("x-forwarded-for");
	    if(ips.indexOf(",") != -1)
	    {
	    	String ip[] = ips.split("\\,");
	    	return ip[0].trim();
	    }
	    return null;  
	} 
	
	public List<User> selectUserListPage(User user)
	{
		this.setDaoSupport(authDao);
		return this.selectListByPage("selectUserList", user);
	}
	
	public void addUser(User user) throws Exception
	{
		user.setPassword(KeyedDigestMD5.getKeyedDigest(user.getPassword(), ""));
		user.setStatus("正常");
		if(this.getAuthDao().getSqlSession().insert("addUser", user) <= 0)
		{
			throw new Exception("新增用户失败");
		}
	}
	@Transactional(rollbackFor = Exception.class)
	public void updateUserStatus(User users[])
	{
		for(User user : users)
		{
			this.authDao.getSqlSession().update("updateUserStatus", user);
		}
	}
}
