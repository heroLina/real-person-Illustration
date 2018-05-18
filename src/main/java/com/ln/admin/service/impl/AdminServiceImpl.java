package com.ln.admin.service.impl;

import com.ln.admin.entity.Admin;
import com.ln.admin.mapper.AdminMapper;
import com.ln.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lina on 2018/5/18.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin queryAdminByMobile(String mobile) {
        //从库里查询手机号是否存在
        Admin admin = adminMapper.selectAdminByMobile(mobile);
        return admin;
    }

    @Override
    public void saveAdmin(String mobile) {
        adminMapper.insertAdmin(mobile);
    }
}
