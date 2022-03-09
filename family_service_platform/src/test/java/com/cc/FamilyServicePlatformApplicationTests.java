package com.cc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.bean.FcBuilding;
import com.cc.bean.FcEstate;
import com.cc.mapper.FcBuildingMapper;
import com.cc.mapper.FcEstateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class FamilyServicePlatformApplicationTests {
    @Autowired
    private FcBuildingMapper fcBuildingMapper;
    @Test
    void contextLoads() {
        QueryWrapper<FcBuilding> queryWrapper=new QueryWrapper<>();
        List<FcBuilding> fcBuildings = fcBuildingMapper.selectList(queryWrapper);
        for (FcBuilding fcBuilding : fcBuildings) {
            System.out.println(fcBuilding);
        }
    }

}
