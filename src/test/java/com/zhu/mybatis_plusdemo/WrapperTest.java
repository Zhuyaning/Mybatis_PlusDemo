package com.zhu.mybatis_plusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import com.zhu.mybatis_plusdemo.mapper.UserMapper;
import com.zhu.mybatis_plusdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/8/22
 *   Time: 18:36
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1() {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age", 21);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test2() {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("name", "万佳林").eq("email", "1544040692@qq.com");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void test3() {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.between("age", 20, 25);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
    public void test4() {
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.notLike("name", "e");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        Map<String, Object> map = maps.get(0);
        System.out.println(map.keySet());
    }

    @Test
    public void test5() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("com.zhu.mybatis_plusdemo.pojo.User");
        Class<User> aClass = User.class;
        User user = (User) clazz.newInstance();
        System.out.println(user);
        System.out.println(user.getClass());
    }

    @Test
    public void test6() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class userClass = new ClassLoader().getParent().loadClass("com.zhu.mybatis_plusdemo.pojo.User");
        Method setName = userClass.getDeclaredMethod("setName", String.class);
        User user = (User) userClass.newInstance();
        setName.invoke(user, "朱亚宁");
        System.out.println(user.getName());
    }

    @Test
    public void test7() {
    }
}
