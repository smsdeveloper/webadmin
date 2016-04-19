package com.egouer.admin.auth.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egouer.admin.auth.dao.AuthDao;
import com.egouer.admin.auth.domain.Menu;
import com.egouer.admin.auth.domain.RoleMenu;
import com.egouer.admin.auth.domain.User;
import com.egouer.admin.auth.domain.UserRole;

@Service
public class MenuService {

	@Autowired
	private AuthDao authDao;
	public List<Menu> selectMenusByRoleCode(User user)
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
		List<Menu> menus = new ArrayList<Menu>();
		for(UserRole role : userRoleList)
		{
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRolecode(role.getRolecode());
			/**
			 * 查询用户角色编号对应的功能列表
			 */
			List<RoleMenu> roleMenuList = authDao.getSqlSession().selectList("selectMenusByRoleCode", roleMenu);
			if(roleMenuList == null || roleMenuList.isEmpty())
			{
				continue;
			}
			for(RoleMenu roleMenu2 : roleMenuList)
			{
				/**
				 * 组装功能列表
				 */
				Menu menu = new Menu();
				menu.setMenucode(roleMenu2.getMenucode());
				menu.setStatus("正常");
				menu = authDao.getSqlSession().selectOne("selectMenu", menu);
				menus.add(menu);
			}
		}
		return menus;
	}
}
