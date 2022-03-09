package com.cc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.bean.FcEstate;
import com.cc.mapper.FcEstateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class FamilyServicePlatformApplicationTests {
    @Autowired
    private FcEstateMapper fcEstateMapper;
    @Test
    void contextLoads() {
        QueryWrapper<FcEstate> queryWrapper=new QueryWrapper<>();
        List<FcEstate> fcEstates = fcEstateMapper.selectList(queryWrapper);
        for (FcEstate fcEstate : fcEstates) {
            System.out.println(fcEstate);
        }
    }

}
