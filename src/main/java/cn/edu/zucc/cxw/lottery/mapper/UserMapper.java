package cn.edu.zucc.cxw.lottery.mapper;

import cn.edu.zucc.cxw.lottery.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUserEmail(String userEmail);

    User selectByUserPhone(String userPhone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}