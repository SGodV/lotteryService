package cn.edu.zucc.cxw.lottery.mapper;

import cn.edu.zucc.cxw.lottery.entity.Record;

import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);

    List<Record> selectByUserId(Integer userId);

    List<Record> selectByPeriodId(Integer periodId);

    Record selectByRecordVal(Record record);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}