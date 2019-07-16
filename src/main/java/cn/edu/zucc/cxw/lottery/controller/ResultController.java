package cn.edu.zucc.cxw.lottery.controller;

import cn.edu.zucc.cxw.lottery.entity.Period;
import cn.edu.zucc.cxw.lottery.entity.ResultBean;
import cn.edu.zucc.cxw.lottery.service.impl.ResultServiceImpl;
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
@RequestMapping(value = "/result")
@RestController
public class ResultController {
    @Autowired
    ResultServiceImpl resultService;

    @RequestMapping(value = "/getwinlist")
    @CrossOrigin
    public ResultBean<Map<String, String>> getWinList(Integer userId) {
//        Map<String, String> map = resultService.getWinList(userId);
        return new ResultBean<>(resultService.getWinList(userId));
    }
}
