package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.Record;
import cn.edu.zucc.cxw.lottery.entity.Result;
import cn.edu.zucc.cxw.lottery.exception.CheckException;
import cn.edu.zucc.cxw.lottery.mapper.PeriodMapper;
import cn.edu.zucc.cxw.lottery.service.IPeriodService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 10:58
 */
@Service
public class PeriodServiceImpl implements IPeriodService {
    @Resource
    PeriodMapper periodMapper;

    @Autowired
    RecordServiceImpl recordService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ResultServiceImpl resultService;

    @Override
    public Period selectByPrimaryKey(Integer id) {
        return periodMapper.selectByPrimaryKey(id);
    }

    @Override
    public Period selectByPrimaryKeyWithBLOBs(Integer id) {
        return periodMapper.selectByPrimaryKeyWithBLOBs(id);
    }

    @Override
    public int uploadPic(String pic) {
        System.out.println(pic);
        return 1;
    }

    @Override
    public String downloadPic(Integer id) {
        Period period = selectByPrimaryKeyWithBLOBs(id);
        return Base64.encodeBase64String(period.getPic()).replaceAll("data", "data:").replaceAll("base64", ";base64,");
    }

    @Override
    public int CreateLottery(String title, Boolean numIf, Integer numLength, Boolean letterIf, Integer letterLength,
                             Integer joinNum, Integer winNum, String pic) {
        if (title == null || "".equals(title)) throw new CheckException("标题未填写");
        if ((numIf == null || !numIf) && (!letterIf || letterIf == null)) throw new CheckException("未定义规则");
        if ((numIf == null || !numIf) && numLength != null && numLength != 0) throw new CheckException("数字规则不正确");
        if ((letterIf == null || !letterIf) && letterLength != null && letterLength != 0) throw new CheckException("字母规则不正确");
        if (joinNum == null || joinNum == 0) throw new CheckException("参与人数不正确");
        if (winNum == null || winNum == 0 || winNum >= joinNum) throw new CheckException("中签人数不正确");
        Period period = new Period();
        period.setTitle(title);
        period.setNumIf(numIf);
        period.setNumLength(numLength);
        period.setBeginDate(new Timestamp(System.currentTimeMillis()));
        period.setLetterIf(letterIf);
        period.setLetterLength(letterLength);
        period.setJoinNum(joinNum);
        period.setWinNum(winNum);
        period.setPic(Base64.decodeBase64(pic));
        return periodMapper.insertSelective(period);
    }

    @Override
    public List<Period> loadAll() {
        return periodMapper.selectAll();
    }

    @Override
    public Map<String, String> lottery(Integer periodId) {
        Map<String, String> lotteryResult = new HashMap<>();
        Period period = periodMapper.selectByPrimaryKeyWithBLOBs(periodId);
        List<Record> periodList = recordService.selectByPeriodId(periodId);
        for (int i = 0; i < period.getWinNum(); i++) {
            int j;
            do {
                j = Integer.parseInt(RecordServiceImpl.genRandomNum(String.valueOf(periodList.size()).length()));
            }while (j >= periodList.size());
            lotteryResult.put(periodList.get(j).getRecordVal(), userService.selectByPrimaryKey(periodList.get(j).getUserId()).getUserEmail());
            Result result = new Result();
            result.setResultPeriod(periodId);
            result.setResultVal(periodList.get(j).getRecordVal());
            resultService.insert(periodId, periodList.get(j).getRecordVal());
        }
        period.setEndTime(new Timestamp(System.currentTimeMillis()));
        periodMapper.updateByPrimaryKeySelective(period);
        return lotteryResult;
    }


    @Override
    public int deleteById(Integer id) {
        Period period = new Period();
        period.setId(id);
        period.setBeginDate(new Timestamp(0));
        return periodMapper.updateByPrimaryKeySelective(period);
    }
}
