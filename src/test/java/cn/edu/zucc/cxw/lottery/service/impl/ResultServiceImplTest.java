package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.LotteryApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/16 20:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryApplication.class)
public class ResultServiceImplTest {
    @Autowired
    ResultServiceImpl resultService;

    @Test
    public void getWinList() {
        Map<String, String> map = resultService.getWinList(3286);
        System.out.println(map.size());
        System.out.println(map.values());
    }

    @Test
    public void insert() {
    }
}