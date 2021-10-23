package com.zhu.mybatis_plusdemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/8/22
 *   Time: 16:18
 */

@EnableTransactionManagement
@Configuration
@MapperScan("com.zhu.mybatis_plusdemo.mapper")
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());  //乐观锁
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));   //分页
//        interceptor.addInnerInterceptor(new LogicSqlInjector());          //逻辑删除,高版本不需要配置此行代码
        return interceptor;
    }
}
