package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.Record;
import cn.edu.zucc.cxw.lottery.entity.User;
import cn.edu.zucc.cxw.lottery.exception.CheckException;
import cn.edu.zucc.cxw.lottery.mapper.UserMapper;
import cn.edu.zucc.cxw.lottery.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

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
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

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

    @Override
    public List<User> loadAll() {
        return userMapper.selectAll();
    }

    public void generateUser() {
        List<User> userList = userMapper.selectAll();
        String part = genRandomLetter(6);
        String email = part + "@" + part + ".com";
        for (User u : userList) {
            if (!u.getUserEmail().equals(email)) {
                User user = new User();
                user.setUserEmail(email);
                user.setUserPwd(part);
                user.setUserName(part);
                user.setUserPower("A");
                userMapper.insertSelective(user);
                break;
            }
        }
    }

    public static String genRandomLetter(int pwd_len) {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 26;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z'};

        /*char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z'};*/

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            // 生成随机数，取绝对值，防止生成负数，

            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }

        return pwd.toString();
    }

}
