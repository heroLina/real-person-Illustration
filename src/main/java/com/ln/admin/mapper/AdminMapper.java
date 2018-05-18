package com.ln.admin.mapper;

import com.ln.admin.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by lina on 2018/5/18.
 */
@Repository
public interface AdminMapper{
    @Select("select * from ln_admin where mobile = #{mobile} ")
    Admin selectAdminByMobile(@Param("mobile") String mobile);
    @Insert("insert into ln_admin(mobile) values(#{mobile} ) ")
    void insertAdmin(@Param("mobile") String mobile);
}
