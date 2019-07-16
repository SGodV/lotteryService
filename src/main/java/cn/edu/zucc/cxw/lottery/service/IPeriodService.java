package cn.edu.zucc.cxw.lottery.service;

import cn.edu.zucc.cxw.lottery.entity.Period;

import java.util.List;
import java.util.Map;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 10:46
 */
public interface IPeriodService {
    Period selectByPrimaryKey(Integer id);
    Period selectByPrimaryKeyWithBLOBs(Integer id);
    int uploadPic(String pic);
    String downloadPic(Integer id);
    int CreateLottery(String title, Boolean numIf, Integer numLength, Boolean letterIf, Integer letterLength,
                             Integer joinNum, Integer winNum, String pic);
    List<Period> loadAll();
    Map<String,String> lottery(Integer periodId);
    int deleteById(Integer id);
}
