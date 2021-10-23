package com.zhu.mybatis_plusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhu.mybatis_plusdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/8/11
 *   Time: 21:46
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
