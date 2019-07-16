package cn.edu.zucc.cxw.lottery.service;

import cn.edu.zucc.cxw.lottery.entity.User;

import java.util.List;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/10 21:40
 */
public interface IUserService {
    User selectByPrimaryKey(Integer id);
    User login(String loginName, String password);
    List<User> loadAll();
}
