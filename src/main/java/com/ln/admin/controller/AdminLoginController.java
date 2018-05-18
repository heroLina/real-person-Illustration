package com.ln.admin.controller;

import com.ln.admin.entity.Admin;
import com.ln.admin.service.impl.AdminServiceImpl;
import com.ln.commons.core.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by lina on 2018/5/18.
 */
@RestController
public class AdminLoginController {
    @Autowired
    private AdminServiceImpl adminServiceImpl;
    @GetMapping("getSmsCode")
    public Result getSmsCode(String mobile, HttpSession session,Map map){
        //查询该手机号是否存在，存在即为登录，不存在即为注册
        Admin admin = adminServiceImpl.queryAdminByMobile(mobile);
        //发送验证码
        session.setAttribute(mobile,"1234");
        Boolean exit=false;
        if (null!=admin){
            exit=true;
        }
        map.put("exitFlag", exit);
        Result result = new Result(map);
        return result;
    }
    @PostMapping("login")
    public Result adminLogin(String mobile,Boolean exitFlag,String code,HttpSession session){
        Object attribute = session.getAttribute(mobile);
        if (null==attribute){
            //没有验证码
            return new Result(10001,"请输入验证码！",null);
        }else{
            if (!code.equals(attribute)){
                return new Result(10001,"验证码错误！",null);
            }
            session.removeAttribute(mobile);
        }
        if (exitFlag.equals(false)){
            //注册
            adminServiceImpl.saveAdmin(mobile);
        }
        Admin admin = adminServiceImpl.queryAdminByMobile(mobile);
        return new Result(admin);
    }
}
