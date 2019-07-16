package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.LotteryApplication;
import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.Record;
import cn.edu.zucc.cxw.lottery.entity.User;
import cn.edu.zucc.cxw.lottery.mapper.RecordMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/14 9:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryApplication.class)
public class RecordServiceImplTest {
    @Autowired
    RecordServiceImpl recordService;

    @Resource
    RecordMapper recordMapper;

    @Test
    public void apply() {
        Record record = new Record();
        record.setUserId(1);
        record.setPeriodId(34);
        record.setRecordVal("53223");
        recordMapper.insertSelective(record);
    }

    @Test
    public void selectByUserId() {
        Map<String, Period> map =  recordService.selectByUserId(1);
        System.out.println(map.size());
        System.out.println(map.values());
    }

    @Test
    public void autoGenerate() {
        recordService.autoGenerate(33);
//        List<User> userList =  userService.loadAll();
//        Period period = periodService.selectByPrimaryKey(33);
//        while (recordMapper.selectByPeriodId(33).size() <= period.getJoinNum()) {
//            String val = getValString(33, period);
//            Record record2 = new Record();
//            int i = Integer.parseInt(RecordServiceImpl.genRandomNum(String.valueOf(userList.size()).length()));
//            record2.setUserId(userList.get(i).getId());
//            userList.remove(i);
//            record2.setPeriodId(33);
//            record2.setRecordVal(val);
//            recordMapper.insertSelective(record2);
//        }
    }

    private String getValString(Integer periodId, Period period) {
        String val = "";
        Record record1 = null;
        do {
            val = "";
            if (period.getNumIf() != null && period.getNumIf()) val += RecordServiceImpl.genRandomNum(period.getNumLength());
            if (period.getLetterIf() != null && period.getLetterIf()) val += RecordServiceImpl.genRandomLetter(period.getLetterLength());
            Record record = new Record();
            record.setPeriodId(periodId);
            record.setRecordVal(val);
            record1 = recordMapper.selectByRecordVal(record);
        } while (record1 != null);
        return val;
    }

    @Test
    public void genRandomNum() {
//        System.out.println(RecordServiceImpl.genRandomNum(30));
//        System.out.println(RecordServiceImpl.genRandomLetter(5));
        Random r = new Random();
        System.out.println(r.nextInt());
        for (int i = 0; i < 100; i++)
            System.out.println(r.nextInt(10));
    }
}