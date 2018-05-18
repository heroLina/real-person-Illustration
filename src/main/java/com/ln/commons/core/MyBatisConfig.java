package com.ln.commons.core;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 * Created by lina on 2018/5/18.
 */
@Repository
@ConditionalOnProperty(value = "spring.datasource.driver-class-name",havingValue = "com.mysql.jdbc.Driver")
@MapperScan(basePackages = {"com.ln"})
public class MyBatisConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc=new MapperScannerConfigurer();
        msc.setBasePackage("com.ln..mapper.*");
        return msc;
    }
}
