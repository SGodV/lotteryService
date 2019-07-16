package cn.edu.zucc.cxw.lottery.service;

import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.Record;

import java.util.List;
import java.util.Map;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 10:48
 */
public interface IRecordService {
    List<Record> selectListByUserId(Integer userId);
    List<Record> selectByPeriodId(Integer periodId);
    int apply(Integer userId, Integer periodId);
    Map<String, Period> selectByUserId(Integer userId);
    int autoGenerate(Integer periodId);
}
