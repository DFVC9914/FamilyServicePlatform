package com.cc.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}
