package cn.edu.zucc.cxw.lottery.controller;

import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.ResultBean;
import cn.edu.zucc.cxw.lottery.service.impl.PeriodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 11:15
 */
@RequestMapping(value = "/period")
@RestController
public class PeriodController {
    @Autowired
    PeriodServiceImpl periodService;

    @RequestMapping(value = "/uploadpic")
    @CrossOrigin
    public ResultBean<Integer> uploadPic(String pic) {
        return new ResultBean<>(periodService.uploadPic(pic));
    }

    @RequestMapping(value = "/downloadpic")
    @CrossOrigin
    public ResultBean<String> downloadPic(Integer id) {
        return new ResultBean<>(periodService.downloadPic(id));
    }

    @RequestMapping(value = "/createlottery")
    @CrossOrigin
    public ResultBean<Integer> CreateLottery(String title, Boolean numIf, Integer numLength, Boolean letterIf,
                                             Integer letterLength, Integer joinNum, Integer winNum, String pic) {
        return new ResultBean<>(periodService.CreateLottery(title, numIf, numLength, letterIf, letterLength, joinNum,
                winNum, pic));
    }

    @RequestMapping(value = "/loadall")
    @CrossOrigin
    public ResultBean<List<Period>> loadAll() {
        return new ResultBean<>(periodService.loadAll());
    }


    @RequestMapping(value = "/lottery")
    @CrossOrigin
    public  ResultBean<Map<String,String>> lottery(Integer periodId){
        return new ResultBean<>(periodService.lottery(periodId));
    }

    @RequestMapping(value = "/deletebyid")
    @CrossOrigin
    public ResultBean<Integer> deleteById(Integer id) {
        return new ResultBean<>(periodService.deleteById(id));
    }
}
