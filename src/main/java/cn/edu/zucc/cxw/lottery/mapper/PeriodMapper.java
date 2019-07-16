package cn.edu.zucc.cxw.lottery.mapper;

import cn.edu.zucc.cxw.lottery.entity.Period;

import java.util.List;

public interface PeriodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Period record);

    int insertSelective(Period record);

    List<Period> selectAll();

    Period selectByPrimaryKey(Integer id);

    Period selectByPrimaryKeyWithBLOBs(Integer id);

    int updateByPrimaryKeySelective(Period record);

    int updateByPrimaryKeyWithBLOBs(Period record);

    int updateByPrimaryKey(Period record);
}