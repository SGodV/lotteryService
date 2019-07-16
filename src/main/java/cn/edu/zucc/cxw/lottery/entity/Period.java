package cn.edu.zucc.cxw.lottery.entity;

import java.util.Date;

public class Period {
    private Integer id;

    private String title;

    private Date beginDate;

    private Date endTime;

    private Boolean numIf;

    private Integer numLength;

    private Boolean letterIf;

    private Integer letterLength;

    private Integer joinNum;

    private Integer winNum;

    private byte[] pic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getNumIf() {
        return numIf;
    }

    public void setNumIf(Boolean numIf) {
        this.numIf = numIf;
    }

    public Integer getNumLength() {
        return numLength;
    }

    public void setNumLength(Integer numLength) {
        this.numLength = numLength;
    }

    public Boolean getLetterIf() {
        return letterIf;
    }

    public void setLetterIf(Boolean letterIf) {
        this.letterIf = letterIf;
    }

    public Integer getLetterLength() {
        return letterLength;
    }

    public void setLetterLength(Integer letterLength) {
        this.letterLength = letterLength;
    }

    public Integer getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

    public Integer getWinNum() {
        return winNum;
    }

    public void setWinNum(Integer winNum) {
        this.winNum = winNum;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}