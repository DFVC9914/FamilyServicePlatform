package com.cc.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户档案
 * </p>
 *
 * @author lian
 * @since 2021-10-15
 */
public class TblUserRecord implements Serializable {

    private static final long serialVersionUID=1L;

    private String token;
    
    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 岗位角色
     */
    private TblRole tblRole;

    /**
     * 用户性别
     */
    private String userGender;

    /**
     * 所属部门
     */
    private TblDept tblDept;

    /**
     * 职位
     */
    private Integer userJob;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 办公电话
     */
    private String officePhone;

    /**
     * 内线电话
     */
    private String innerPhone;

    /**
     * 移动电话
     */
    private String movePhone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 允许发送手机短信
     */
    private String isSendMsg;

    /**
     * 有效开始日期
     */
    private Date startDate;

    /**
     * 有效结束日期
     */
    private Date stopDate;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 登陆ip规则
     */
    private String ipRule;

    /**
     * 入职日期
     */
    private Date userHiredate;

    /**
     * 允许发送微信
     */
    private String isSendWchat;

    /**
     * 备注
     */
    private String remark;

    /**
     * 所属公司
     */
    private TblCompany tblCompany;

    /**
     * 是否部门管理者
     */
    private String isDeptAdmin;

    /**
     * 最后登陆时间
     */
    private Date lastLoginDate;

    /**
     * 创建人
     */
    private String createPerson;

    /**
     * 创建时间
     */
    private Date createDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }



    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }


    public Integer getUserJob() {
        return userJob;
    }

    public void setUserJob(Integer userJob) {
        this.userJob = userJob;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TblRole getTblRole() {
        return tblRole;
    }

    public void setTblRole(TblRole tblRole) {
        this.tblRole = tblRole;
    }

    public String getInnerPhone() {
        return innerPhone;
    }

    public void setInnerPhone(String innerPhone) {
        this.innerPhone = innerPhone;
    }

    public String getMovePhone() {
        return movePhone;
    }

    public void setMovePhone(String movePhone) {
        this.movePhone = movePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsSendMsg() {
        return isSendMsg;
    }

    public void setIsSendMsg(String isSendMsg) {
        this.isSendMsg = isSendMsg;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIpRule() {
        return ipRule;
    }

    public void setIpRule(String ipRule) {
        this.ipRule = ipRule;
    }

    public Date getUserHiredate() {
        return userHiredate;
    }

    public void setUserHiredate(Date userHiredate) {
        this.userHiredate = userHiredate;
    }

    public String getIsSendWchat() {
        return isSendWchat;
    }

    public void setIsSendWchat(String isSendWchat) {
        this.isSendWchat = isSendWchat;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    public String getIsDeptAdmin() {
        return isDeptAdmin;
    }

    public void setIsDeptAdmin(String isDeptAdmin) {
        this.isDeptAdmin = isDeptAdmin;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public TblDept getTblDept() {
        return tblDept;
    }

    public void setTblDept(TblDept tblDept) {
        this.tblDept = tblDept;
    }

    public TblCompany getTblCompany() {
        return tblCompany;
    }

    @Override
    public String toString() {
        return "TblUserRecord{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                ", tblRole=" + tblRole +
                ", userGender='" + userGender + '\'' +
                ", tblDept=" + tblDept +
                ", userJob=" + userJob +
                ", userStatus='" + userStatus + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", innerPhone='" + innerPhone + '\'' +
                ", movePhone='" + movePhone + '\'' +
                ", email='" + email + '\'' +
                ", isSendMsg='" + isSendMsg + '\'' +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                ", birthday=" + birthday +
                ", ipRule='" + ipRule + '\'' +
                ", userHiredate=" + userHiredate +
                ", isSendWchat='" + isSendWchat + '\'' +
                ", remark='" + remark + '\'' +
                ", tblCompany=" + tblCompany +
                ", isDeptAdmin='" + isDeptAdmin + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", createPerson='" + createPerson + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public void setTblCompany(TblCompany tblCompany) {
        this.tblCompany = tblCompany;
    }

}
