package com.cc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.bean.*;
import com.cc.mapper.*;
import com.cc.receive.CellMessage;
import com.cc.receive.UnitMessage;
import com.cc.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/09 - 03 - 09 - 14:46
 * @Description: com.cc.service.impl
 * @Version: 1.0
 */
@Service
public class EstateServiceImpl implements EstateService {
    @Autowired
    private TblCompanyMapper tblCompanyMapper;

    @Autowired
    private FcEstateMapper fcEstateMapper;

    @Autowired
    private FcBuildingMapper fcBuildingMapper;

    @Autowired
    private FcUnitMapper fcUnitMapper;

    @Autowired
    private FcCellMapper fcCellMapper;

    @Override
    public List<TblCompany> selectCompany() {
        return tblCompanyMapper.selectCompanyName();
    }

    @Override
    public int insertEstate(FcEstate fcEstate) {
        QueryWrapper<FcEstate> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("estate_code",fcEstate.getEstateCode());
        FcEstate findResult = fcEstateMapper.selectOne(queryWrapper);
        if (null!=findResult){
            return 0;
        }else {
            return fcEstateMapper.insert(fcEstate);
        }
    }

    //数据库表格中为空，所以先插入数据，后返回结果
    @Override
    public List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode) {
        List<FcBuilding> fcBuildings = new ArrayList<>();
        for (int i = 0; i < buildingNumber ; i++) {
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setBuildingCode(estateCode+"B"+(i+1));
            fcBuilding.setBuildingName("第"+(i+1)+"号楼");
            fcBuilding.setEstateCode(estateCode);
            fcBuildings.add(fcBuilding);
            fcBuildingMapper.insert(fcBuilding);
        }
        return fcBuildings;
    }

    @Override
    public Integer updateBuilding(FcBuilding fcBuilding) {
        QueryWrapper<FcBuilding> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",fcBuilding.getId());
        return fcBuildingMapper.update(fcBuilding,queryWrapper);
    }

    @Override
    public List<FcUnit> selectUnit(UnitMessage unitMessage) {
        List<FcUnit> fcUnits= new ArrayList<>();
        for (int i = 0; i < unitMessage.getUnitCount(); i++) {
            FcUnit fcUnit=new FcUnit();
            fcUnit.setBuildingCode(unitMessage.getBuildingCode());
            fcUnit.setUnitCode(unitMessage.getUnitCount()+"U"+(i+1));
            fcUnit.setUnitName("第"+(i+1)+"单元");
            fcUnitMapper.insert(fcUnit);
            fcUnits.add(fcUnit);
        }
        return fcUnits;
    }

    @Override
    public Integer updateUnit(FcUnit fcUnit) {
        return fcUnitMapper.updateById(fcUnit);
    }

    @Override
    public List<FcCell> insertCell(CellMessage cellMessage) {
        List<FcCell> fcCells=new ArrayList<>();
        //楼层
        for (int i = 1; i <= cellMessage.getStopFloor(); i++) {
            //房间号
            for (int j = cellMessage.getStartCellId(); j <= cellMessage.getStopCellId(); j++) {
                FcCell fcCell=new FcCell();
                fcCell.setUnitCode(cellMessage.getUnitCode());
                fcCell.setCellName(i+"0"+j);
                fcCell.setCellCode(cellMessage.getUnitCode()+"C"+i+"0"+j);
                fcCell.setFloorNumber(i);
                fcCellMapper.insert(fcCell);
                fcCells.add(fcCell);
            }
        }
        return fcCells;
    }

    @Override
    public List<FcBuilding> selectBuildingByEstate(String estateCode) {
        QueryWrapper<FcBuilding> queryWrapper=new QueryWrapper<>();
        return fcBuildingMapper.selectList(queryWrapper.eq("estate_code",estateCode).select("building_code","building_name"));
    }

    @Override
    public List<FcUnit> selectUnitByBuildingEstate(String buildingCode) {
        QueryWrapper<FcUnit> queryWrapper=new QueryWrapper<>();
        return fcUnitMapper.selectList(queryWrapper.eq("building_code",buildingCode).select("unit_code","unit_name"));
    }

    @Override
    public List<FcEstate> selectEstate(String company) {
        QueryWrapper<FcEstate> queryWrapper=new QueryWrapper<>();
        return fcEstateMapper.selectList(queryWrapper.eq("company",company));
    }

    @Override
    public List<FcCell> selectCell(String unitCode) {
        QueryWrapper<FcCell> queryWrapper=new QueryWrapper<>();
        return fcCellMapper.selectList(queryWrapper.eq("unit_code",unitCode));
    }


}
