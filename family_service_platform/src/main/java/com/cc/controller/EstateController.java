package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.bean.FcEstate;
import com.cc.bean.TblCompany;
import com.cc.returnjson.ReturnObject;
import com.cc.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/09 - 03 - 09 - 14:44
 * @Description: com.cc.controller
 * @Version: 1.0
 */
@RestController
public class EstateController {
    @Autowired
    private EstateService estateServiceImpl;
    //选择公司，对应TblCompany表
    @RequestMapping("/estate/selectCompany")
    public String selectCompany(){
        List<TblCompany> tblCompanies = estateServiceImpl.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(tblCompanies));
    }

    //向FcEstate表中插入填写的楼房信息
    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate){
        //插入信息时在service层进行判断插入的信息中的房产编码值是否唯一，唯一则继续操作
        int result = estateServiceImpl.insertEstate(fcEstate);
        if (0==result){
            return JSONObject.toJSONString(new ReturnObject("0","房产编码已存在"));
        }else {
            return JSONObject.toJSONString(new ReturnObject("1","插入数据成功"));
        }
    }
}
