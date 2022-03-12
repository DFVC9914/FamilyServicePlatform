package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
import com.cc.bean.*;
import com.cc.receive.CellMessage;
import com.cc.receive.UnitMessage;
import com.cc.returnjson.ReturnObject;
import com.cc.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    //楼宇查询功能，
    @RequestMapping("/estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber,String estateCode){
        List<FcBuilding> fcBuildings = estateServiceImpl.selectBuilding(buildingNumber, estateCode);
        return JSONObject.toJSONString(new ReturnObject(fcBuildings));
    }

    //更新楼宇信息
    @RequestMapping("/estate/updateBuilding")
    public String updateBuilding(FcBuilding fcBuilding){
        Integer result = estateServiceImpl.updateBuilding(fcBuilding);
        if(1==result){
            return JSONObject.toJSONString(new ReturnObject("更新楼宇信息成功"));
        }else {
            return JSONObject.toJSONString(new ReturnObject("更新楼宇信息失败"));
        }
    }

    @RequestMapping("/estate/selectUnit")
    public String selectUnit(@RequestBody UnitMessage[] unitMessages){
        List<FcUnit> allUnit=new ArrayList<>();
        for (UnitMessage unitMessage : unitMessages) {
            allUnit.addAll(estateServiceImpl.selectUnit(unitMessage));
        }
        return JSONObject.toJSONString(new ReturnObject(allUnit));
    }

    @RequestMapping("/estate/updateUnit")
    public String updateUnit(FcUnit fcUnit){
        Integer result = estateServiceImpl.updateUnit(fcUnit);
        if(1==result){
            return JSONObject.toJSONString(new ReturnObject("更新单元成功"));
        }else
        {
            return JSONObject.toJSONString(new ReturnObject("跟新单元失败"));
        }
    }

    @RequestMapping("/estate/insertCell")
    public String insertCell(@RequestBody CellMessage[] cellMessages){
        List<FcCell> allCell= new ArrayList<>();
        for (CellMessage cellMessage : cellMessages) {
            List<FcCell> fcCells = estateServiceImpl.insertCell(cellMessage);
            allCell.addAll(fcCells);
        }
        return JSONObject.toJSONString(new ReturnObject(allCell));
    }

    @RequestMapping("/estate/selectBuildingByEstate")
    public String selectBuildingByEstate(String estateCode){
        List<FcBuilding> fcBuildings = estateServiceImpl.selectBuildingByEstate(estateCode);
        return JSONObject.toJSONString(new ReturnObject(fcBuildings));
    }

    @RequestMapping("/estate/selectUnitByBuildingEstate")
    public String selectUnitByBuildingEstate(String buildingCode){
        List<FcUnit> fcUnits = estateServiceImpl.selectUnitByBuildingEstate(buildingCode);
        return JSONObject.toJSONString(new ReturnObject(fcUnits));
    }

    @RequestMapping("/estate/selectCell")
    public String selectCell(String unitCode){
        List<FcCell> fcCells= estateServiceImpl.selectCell(unitCode);
        return JSONObject.toJSONString(new ReturnObject(fcCells));
    }

    @RequestMapping("/estate/selectEstate")
    public  String selectEstate(String company){
        List<FcEstate> fcEstates = estateServiceImpl.selectEstate(company);
        return JSONObject.toJSONString(new ReturnObject(fcEstates));
    }
}
