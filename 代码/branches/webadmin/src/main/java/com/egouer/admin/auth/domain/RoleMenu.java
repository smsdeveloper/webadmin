package com.egouer.admin.auth.domain;

import java.util.Date;

public class RoleMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RoleMenu.roleMenuId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    private Long rolemenuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RoleMenu.menuCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    private String menucode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RoleMenu.roleCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    private String rolecode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RoleMenu.addTime
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    private Date addtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RoleMenu.roleMenuId
     *
     * @return the value of RoleMenu.roleMenuId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public Long getRolemenuid() {
        return rolemenuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RoleMenu.roleMenuId
     *
     * @param rolemenuid the value for RoleMenu.roleMenuId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public void setRolemenuid(Long rolemenuid) {
        this.rolemenuid = rolemenuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RoleMenu.menuCode
     *
     * @return the value of RoleMenu.menuCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public String getMenucode() {
        return menucode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RoleMenu.menuCode
     *
     * @param menucode the value for RoleMenu.menuCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public void setMenucode(String menucode) {
        this.menucode = menucode == null ? null : menucode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RoleMenu.roleCode
     *
     * @return the value of RoleMenu.roleCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public String getRolecode() {
        return rolecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RoleMenu.roleCode
     *
     * @param rolecode the value for RoleMenu.roleCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RoleMenu.addTime
     *
     * @return the value of RoleMenu.addTime
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RoleMenu.addTime
     *
     * @param addtime the value for RoleMenu.addTime
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}