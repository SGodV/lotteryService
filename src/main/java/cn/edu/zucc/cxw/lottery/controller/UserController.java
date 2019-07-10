package cn.edu.zucc.cxw.lottery.controller;

import cn.edu.zucc.cxw.lottery.entity.ResultBean;
import cn.edu.zucc.cxw.lottery.entity.User;
import cn.edu.zucc.cxw.lottery.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/10 21:45
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/hello")
    public String hello(Model model){
        return "Hello SpringBoot!";
    }

    @RequestMapping(value = "/login")
    @CrossOrigin
    public ResultBean<User> login(String loginName, String password) {
        return new ResultBean<>(userService.login(loginName, password));
    }
}