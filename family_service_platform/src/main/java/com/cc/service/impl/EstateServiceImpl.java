package com.cc.service.impl;

import com.cc.bean.FcEstate;
import com.cc.bean.TblCompany;
import com.cc.mapper.FcEstateMapper;
import com.cc.mapper.TblCompanyMapper;
import com.cc.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<TblCompany> selectCompany() {
        return tblCompanyMapper.selectCompanyName();
    }

    @Override
    public int insertEstate(FcEstate fcEstate) {
        return fcEstateMapper.insert(fcEstate);
    }
}