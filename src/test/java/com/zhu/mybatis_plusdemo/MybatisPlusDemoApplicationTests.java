package com.zhu.mybatis_plusdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhu.mybatis_plusdemo.mapper.UserMapper;
import com.zhu.mybatis_plusdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("朱亚宁");
        user.setAge(22);
        user.setEmail("2495454242@qq.com");

        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1429370060031455233L);
        user.setName("郑大龙");
        user.setAge(22);
        user.setEmail("2495454242@qq.com");

        userMapper.updateById(user);
    }

    @Test
    public void testOptimisticLock() {             //测试乐观锁成功的案例
        User user = userMapper.selectById(1429370060031455233L);
        user.setName("万佳林");
        user.setEmail("1544040692@qq.com");
        int updateById = userMapper.updateById(user);
        System.out.println(updateById);
    }

    @Test
    public void testOptimisticLock2() throws InterruptedException {             //测试乐观锁失败的案例
        User user = userMapper.selectById(1429370060031455233L);
        user.setName("万佳林111");
        user.setEmail("1544040692@qq.com");
        User user2 = userMapper.selectById(1429370060031455233L);
        user.setName("万佳林222");
        user.setEmail("1544040692@qq.com");
        userMapper.updateById(user2);
        userMapper.updateById(user);
    }

    /***
     * 测试批量查询
     */
    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 1429370060031455233L));
        users.forEach(System.out::println);
    }

    /***
     * 测试条件查询
     */
    @Test
    public void testSelectList2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "万佳林");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<User>(2, 5);
        Page<User> userPage = userMapper.selectPage(page, null);
        userPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void testLogicDelete() {
        userMapper.deleteById(1429370060031455233L);
    }
}
