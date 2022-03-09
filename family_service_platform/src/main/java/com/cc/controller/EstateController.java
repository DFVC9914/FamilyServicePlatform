package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
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
    @RequestMapping("/estate/selectCompany")
    public String selectCompany(){
        List<TblCompany> tblCompanies = estateServiceImpl.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(tblCompanies));
    }
    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate){
        int i = estateServiceImpl.insertEstate(fcEstate);
        return JSONObject.toJSONString(new ReturnObject(i));
    }
}
