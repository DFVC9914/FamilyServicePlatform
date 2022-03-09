package com.cc.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 企业档案
 * </p>
 *
 * @author cc
 * @since 2022-03-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TblCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 企业编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业全称
     */
    private String companyFullName;

    /**
     * 企业简称
     */
    private String companySimpleName;

    /**
     * 英文名称
     */
    private String companyEnglishName;

    /**
     * 企业品牌
     */
    private String companyBrand;

    /**
     * 企业类型
     */
    private String companyType;

    /**
     * 所属行业
     */
    private String companyTrade;

    /**
     * 企业地址
     */
    private String companyAddr;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 企业电话
     */
    private String companyPhone;

    /**
     * 企业传真
     */
    private String companyFax;

    /**
     * 企业网站
     */
    private String companyWebsite;

    /**
     * 企业邮箱
     */
    private String companyEmail;

    /**
     * 国税号
     */
    private String companyNational;

    /**
     * 地税号
     */
    private String companyLand;

    /**
     * 开户银行
     */
    private String openBank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 法人代表
     */
    private String companyLeader;

    /**
     * 注册时间
     */
    private LocalDateTime registerDate;

    /**
     * 注册资金
     */
    private Double registerMoney;

    /**
     * 员工人数
     */
    private String employeeNumber;

    /**
     * 企业简介
     */
    private String companyIntro;

    /**
     * 备注
     */
    private String remark;
}
