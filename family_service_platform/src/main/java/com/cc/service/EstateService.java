package com.cc.service;

import com.cc.bean.FcBuilding;
import com.cc.bean.FcEstate;
import com.cc.bean.TblCompany;
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

}
