package cn.edu.zucc.cxw.lottery.service;

import cn.edu.zucc.cxw.lottery.entity.Period;

import java.util.List;
import java.util.Map;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 10:55
 */
public interface IResultService {
    Map<String, String> getWinList(Integer userId);
    int insert(Integer periodId, String val);
}
