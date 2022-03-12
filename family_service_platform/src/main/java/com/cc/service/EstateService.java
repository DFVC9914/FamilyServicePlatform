package com.cc.service;

import com.cc.bean.*;
import com.cc.receive.CellMessage;
import com.cc.receive.UnitMessage;

import java.util.List;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/09 - 03 - 09 - 14:46
 * @Description: com.cc.service
 * @Version: 1.0
 */
public interface EstateService {

    List<TblCompany> selectCompany();

    int insertEstate(FcEstate fcEstate);

    List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode);

    Integer updateBuilding(FcBuilding fcBuilding);

    List<FcUnit> selectUnit(UnitMessage unitMessage);

    Integer updateUnit(FcUnit fcUnit);

    List<FcCell> insertCell(CellMessage cellMessage);

    List<FcBuilding> selectBuildingByEstate(String estateCode);

    List<FcUnit> selectUnitByBuildingEstate(String buildingCode);

    List<FcCell> selectCell(String unitCode);

    List<FcEstate> selectEstate(String company);
}
