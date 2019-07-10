package cn.edu.zucc.cxw.lottery.entity;

import java.util.Date;

public class Period {
    private Integer id;

    private String title;

    private Date beginDate;

    private Date endTime;

    private String rule;

    private byte[] pic;

    public Period(Integer id, String title, Date beginDate, Date endTime, String rule, byte[] pic) {
        this.id = id;
        this.title = title;
        this.beginDate = beginDate;
        this.endTime = endTime;
        this.rule = rule;
        this.pic = pic;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getRule() {
        return rule;
    }

    public byte[] getPic() {
        return pic;
    }
}