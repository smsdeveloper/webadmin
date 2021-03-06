package com.egouer.admin.auth.domain;

import java.util.Date;

public class UserRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserRole.userRoleId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    private Long userroleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserRole.userId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    private Long userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserRole.roleCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    private String rolecode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UserRole.addTime
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    private Date addtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserRole.userRoleId
     *
     * @return the value of UserRole.userRoleId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public Long getUserroleid() {
        return userroleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserRole.userRoleId
     *
     * @param userroleid the value for UserRole.userRoleId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserRole.userId
     *
     * @return the value of UserRole.userId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserRole.userId
     *
     * @param userid the value for UserRole.userId
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserRole.roleCode
     *
     * @return the value of UserRole.roleCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public String getRolecode() {
        return rolecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserRole.roleCode
     *
     * @param rolecode the value for UserRole.roleCode
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UserRole.addTime
     *
     * @return the value of UserRole.addTime
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UserRole.addTime
     *
     * @param addtime the value for UserRole.addTime
     *
     * @mbggenerated Mon Apr 18 19:45:20 CST 2016
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}