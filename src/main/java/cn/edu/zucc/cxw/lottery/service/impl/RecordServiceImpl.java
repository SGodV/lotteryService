package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.Record;
import cn.edu.zucc.cxw.lottery.entity.User;
import cn.edu.zucc.cxw.lottery.exception.CheckException;
import cn.edu.zucc.cxw.lottery.mapper.RecordMapper;
import cn.edu.zucc.cxw.lottery.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 10:59
 */
@Service
public class RecordServiceImpl implements IRecordService {
    @Resource
    RecordMapper recordMapper;

    @Autowired
    PeriodServiceImpl periodService;

    @Autowired
    UserServiceImpl userService;

    @Override
    public List<Record> selectListByUserId(Integer userId) {
        return recordMapper.selectByUserId(userId);
    }

    @Override
    public List<Record> selectByPeriodId(Integer periodId) {
        return recordMapper.selectByPeriodId(periodId);
    }

    @Override
    public int apply(Integer userId, Integer periodId) {
        Period period = periodService.selectByPrimaryKey(periodId);
        List<Record> recordList1 = selectByPeriodId(periodId);
        if (recordList1.size() >= period.getJoinNum()) throw new CheckException("申请人数已满");
        List<Record> recordList2 = recordMapper.selectByUserId(userId);
        for (Record record : recordList2) {
            if (record.getPeriodId().equals(periodId))
                throw new CheckException("不能重复申请");
        }
        String val = getValString(periodId, period);
        Record record2 = new Record();
        record2.setUserId(userId);
        record2.setPeriodId(periodId);
        record2.setRecordVal(val);
        return recordMapper.insertSelective(record2);
    }

    @Override
    public Map<String, Period> selectByUserId(Integer userId) {
        List<Record> recordList = recordMapper.selectByUserId(userId);
        Map<String, Period> resultMap = new HashMap<>();
        for (Record record : recordList) {
            resultMap.put(record.getRecordVal(), periodService.selectByPrimaryKey(record.getPeriodId()));
        }
        return resultMap;
    }

    @Override
    public int autoGenerate(Integer periodId) {
        List<User> userList =  userService.loadAll();
        Period period = periodService.selectByPrimaryKey(periodId);
        int i = 1;
        while (recordMapper.selectByPeriodId(periodId).size() <= period.getJoinNum()) {
            if (userList.get(i).getId() == 2) continue;
            String val = getValString(periodId, period);
            Record record2 = new Record();
//            int i;
//            do {
//                i = Integer.parseInt(genRandomNum(String.valueOf(userList.size()).length()));
//            } while (i >= userList.size());
            record2.setUserId(userList.get(i).getId());
//            userList.remove(i);
            record2.setPeriodId(periodId);
            record2.setRecordVal(val);
            recordMapper.insertSelective(record2);
            i++;
        }
        return 1;
    }

    private String getValString(Integer periodId, Period period) {
        String val = "";
        Record record1 = null;
        do {
            val = "";
            if (period.getNumIf() != null && period.getNumIf()) val += genRandomNum(period.getNumLength());
            if (period.getLetterIf() != null && period.getLetterIf()) val += genRandomLetter(period.getLetterLength());
            Record record = new Record();
            record.setPeriodId(periodId);
            record.setRecordVal(val);
            record1 = recordMapper.selectByRecordVal(record);
        } while (record1 != null);
        return val;
    }


    /**
     * 生成随即密码
     *
     * @param pwd_len
     *            生成的密码的总长度
     * @return 密码的字符串
     */
    public static String genRandomNum(int pwd_len) {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 10;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度
		/*char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };*/

        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

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
    public static String genRandomLetter(int pwd_len) {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 26;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度
		/*char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };*/

        char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z'};

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
