package com.cc.service;

import com.cc.bean.TblUserRecord;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/08 - 03 - 08 - 18:51
 * @Description: com.cc.service
 * @Version: 1.0
 */
public interface LoginService {

    TblUserRecord login(String username, String password);

}
