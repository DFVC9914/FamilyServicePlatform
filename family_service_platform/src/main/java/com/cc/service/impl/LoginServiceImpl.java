package com.cc.service.impl;

import com.cc.bean.TblUserRecord;
import com.cc.mapper.TblUserRecordMapper;
import com.cc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/08 - 03 - 08 - 18:52
 * @Description: com.cc.service.impl
 * @Version: 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username,String password){
        return tblUserRecordMapper.login(username,password);
    }
}
