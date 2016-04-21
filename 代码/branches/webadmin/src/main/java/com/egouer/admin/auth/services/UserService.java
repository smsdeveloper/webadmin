package com.egouer.admin.auth.services;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egouer.admin.auth.common.UserEnum;
import com.egouer.admin.auth.dao.AuthDao;
import com.egouer.admin.auth.domain.User;
import com.egouer.admin.auth.vo.SessionBean;
import com.egouer.admin.base.BaseService;
import com.egouer.admin.utils.DateUtils;
import com.egouer.admin.utils.KeyedDigestMD5;
import com.egouer.admin.utils.SessionUtil;

@Service(value="userService")
public class UserService extends BaseService{

	@Autowired
	private AuthDao authDao;
	
	public boolean isRelogin(HttpServletRequest request) throws UnsupportedEncodingException
	{
		if(SessionUtil.getSession(request) != null)
		{
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
}
