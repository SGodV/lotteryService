package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.entity.User;
import cn.edu.zucc.cxw.lottery.exception.CheckException;
import cn.edu.zucc.cxw.lottery.mapper.UserMapper;
import cn.edu.zucc.cxw.lottery.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/10 21:41
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User login(String loginName, String password) {
        User user1=userMapper.selectByUserEmail(loginName);
        User user2=userMapper.selectByUserPhone(loginName);
        if (user1==null) {
            if (user2 == null) {
                throw new CheckException("用户不存在");
            }
            else {
                if (!user2.getUserPwd().equals(password)) {
                    throw new CheckException("密码错误");
                }
                else {
                    return user2;
                }
            }
        }
        else {
            if (!user1.getUserPwd().equals(password)) {
                throw new CheckException("密码错误");
            }
            else {
                return user1;
            }
        }
    }
}
