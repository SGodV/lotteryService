package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.Record;
import cn.edu.zucc.cxw.lottery.entity.Result;
import cn.edu.zucc.cxw.lottery.mapper.ResultMapper;
import cn.edu.zucc.cxw.lottery.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 10:59
 */
@Service
public class ResultServiceImpl implements IResultService {
    @Resource
    ResultMapper resultMapper;

    @Autowired
    RecordServiceImpl recordService;

    @Autowired
    PeriodServiceImpl periodService;

    @Override
    public Map<String, String> getWinList(Integer userId) {
        Map<String, String> map = new HashMap<>();
        List<Record> recordList = recordService.selectListByUserId(userId);
        for (Record record : recordList) {
            if (resultMapper.selectByPeriodId(record.getPeriodId()).size() > 0) {
                map.put(record.getRecordVal(), periodService.selectByPrimaryKey(record.getPeriodId()).getTitle());
            }
        }
        return map;
    }

    @Override
    public int insert(Integer periodId, String val) {
        Result result = new Result();
        result.setResultPeriod(periodId);
        result.setResultVal(val);
        return resultMapper.insertSelective(result);
    }
}
