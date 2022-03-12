package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
import com.cc.bean.TblUserRecord;

import com.cc.returnjson.Permission;
import com.cc.returnjson.Permissions;
import com.cc.returnjson.ReturnObject;
import com.cc.returnjson.UserInfo;
import com.cc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Chao Cui
 * @Date: 2022/03/08 - 03 - 08 - 18:15
 * @Description: com.cc.controller
 * @Version: 1.0
 */
@RestController
//@CrossOrigin(originPatterns={"*"},methods ={} ,allowedHeaders = "*",allowCredentials = "true")
public class LoginController {

    @Autowired
    private LoginService loginServiceImpl;

    @RequestMapping("/auth/2step-code")
    //取消前端自带的无用验证方法
    public boolean Step2_Code_Check(){
        return true;
    }

    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session){
        TblUserRecord tblUserRecord = loginServiceImpl.login(username, password);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        ReturnObject returnObject=new ReturnObject(tblUserRecord);
        session.setAttribute("userRecordData",tblUserRecord);
        System.err.println(session);
        return JSONObject.toJSONString(returnObject);
    }

    //退出登录
    @RequestMapping("/auth/logout")
    public void logOut(HttpSession session){
        System.out.println("logout");
        session.invalidate();
    }

    //用户信息加载
    @RequestMapping("/user/info")
    public String getInfo(HttpSession session,HttpServletRequest request){
        TblUserRecord tblUserRecord = (TblUserRecord) session.getAttribute("userRecordData");
        //获取用户权限模块信息
        //String[] split = tblUserRecord.getTblRole().getRolePrivileges().split("-");
        String[] split={"221","223","226","901"};
        //创建权限集合对象
        Permissions permissions=new Permissions();
        List<Permission> permissionList=new ArrayList<>();
        for (String s : split) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);
        UserInfo userInfo=new UserInfo();
       /* userInfo.setName(tblUserRecord.getUserName());*/
        userInfo.setName("admin");
        userInfo.setRole(permissions);
        //返回值的结果
        return JSONObject.toJSONString(new ReturnObject(userInfo));
    }


}
