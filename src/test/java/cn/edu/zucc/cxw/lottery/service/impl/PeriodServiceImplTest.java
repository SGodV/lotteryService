package cn.edu.zucc.cxw.lottery.service.impl;

import cn.edu.zucc.cxw.lottery.LotteryApplication;
import cn.edu.zucc.cxw.lottery.entity.Period;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 20:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryApplication.class)
public class PeriodServiceImplTest {
    @Autowired
    PeriodServiceImpl periodService;

    @Test
    public void uploadPic() {
    }

    @Test
    public void downloadPic() {
        System.out.println();
//        System.out.println(periodService.downloadPic(33));
        System.out.println(periodService.downloadPic(34));
//        System.out.println(periodService.downloadPic(34).lastIndexOf("data"));
//        System.out.println(periodService.downloadPic(34).lastIndexOf("base64"));
//        System.out.println(periodService.downloadPic(34).replaceAll("data", "data:").replaceAll("base64", ";base64,"));
        System.out.println("结束");
    }

    @Test
    public void createLottery() {
    }

    @Test
    public void lottery() {
        Map<String, String> map = periodService.lottery(33);
        System.out.println(map.size());
        System.out.println(map.values());
    }

    @Test
    public void loadAll() {
        List<Period> lp= periodService.loadAll();
        System.out.println(lp.get(0).getTitle());
    }
}