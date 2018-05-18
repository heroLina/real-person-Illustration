package com.ln.admin.service;

import com.ln.admin.entity.Admin;

/**
 * Created by lina on 2018/5/18.
 */
public interface AdminService {
    public Admin queryAdminByMobile(String mobile);
    public void saveAdmin(String mobile);
}
