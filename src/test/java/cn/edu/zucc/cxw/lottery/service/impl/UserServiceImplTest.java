package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.LotteryApplication;
import cn.edu.zucc.cxw.lottery.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/10 22:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryApplication.class)
public class UserServiceImplTest {
    @Autowired
    UserServiceImpl userService;

    @Test
    public void login() {
//        User user = userService.login("cxw@cxw.com","123456");
//        User user = userService.userMapper.selectByUserEmail("cxw@cxw.com");
//        User user = userService.userMapper.selectByUserPhone("13333333333");
        User user = userService.userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUserName());
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPhone());
    }

    @Test
    public void generateUser() {
        for (int i = 0; i < 100; i ++)
        userService.generateUser();
    }
}