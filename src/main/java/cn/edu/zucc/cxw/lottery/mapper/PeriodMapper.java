package cn.edu.zucc.cxw.lottery.mapper;

import cn.edu.zucc.cxw.lottery.entity.Period;

public interface PeriodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Period record);

    int insertSelective(Period record);

    Period selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Period record);

    int updateByPrimaryKeyWithBLOBs(Period record);

    int updateByPrimaryKey(Period record);
}