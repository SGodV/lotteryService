package cn.edu.zucc.cxw.lottery.controller;

import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.ResultBean;
import cn.edu.zucc.cxw.lottery.service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Sprou
 * @email sproutgod667@gmail.com
 * @date 2019/7/13 11:16
 */
@RequestMapping(value = "/record")
@RestController
public class RecordController {
    @Autowired
    RecordServiceImpl recordService;

    @RequestMapping(value = "/apply")
    @CrossOrigin
    public ResultBean<Integer> apply(Integer userId, Integer periodId) {
        return new ResultBean<>(recordService.apply(userId, periodId));
    }

    @RequestMapping(value = "/loadall")
    @CrossOrigin
    public ResultBean<Map<String, Period>> loadAll(Integer userId) {
        return new ResultBean<>(recordService.selectByUserId(userId));
    }

    @RequestMapping(value = "/autogenerate")
    @CrossOrigin
    public ResultBean<Integer> autoGenerate(Integer periodId) {
        return new ResultBean<>(recordService.autoGenerate(periodId));
    }

}
