package cn.edu.zucc.cxw.lottery.service;

import cn.edu.zucc.cxw.lottery.entity.User;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/10 21:40
 */
public interface IUserService {
    public User login(String loginName, String password);
}
