package cn.edu.zucc.cxw.lottery.mapper;

import cn.edu.zucc.cxw.lottery.entity.Result;

public interface ResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Result record);

    int insertSelective(Result record);

    Result selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKey(Result record);
}