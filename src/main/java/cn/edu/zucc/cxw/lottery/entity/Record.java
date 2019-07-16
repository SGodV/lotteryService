package cn.edu.zucc.cxw.lottery.entity;

public class Record {
    private Integer id;

    private Integer periodId;

    private Integer userId;

    private String recordVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecordVal() {
        return recordVal;
    }

    public void setRecordVal(String recordVal) {
        this.recordVal = recordVal == null ? null : recordVal.trim();
    }
}