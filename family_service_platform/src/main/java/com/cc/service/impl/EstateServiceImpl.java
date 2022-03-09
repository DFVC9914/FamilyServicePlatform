package com.cc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.bean.FcBuilding;
import com.cc.bean.FcEstate;
import com.cc.bean.TblCompany;
import com.cc.mapper.FcBuildingMapper;
import com.cc.mapper.FcEstateMapper;
import com.cc.mapper.TblCompanyMapper;
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
            fcBuilding.setBuildingCode("B"+(i+1));
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
}
