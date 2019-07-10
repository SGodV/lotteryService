package cn.edu.zucc.cxw.lottery.entity;

public class Record {
    private Integer id;

    private Integer periodId;

    private Integer userId;

    private String recordVal;

    public Record(Integer id, Integer periodId, Integer userId, String recordVal) {
        this.id = id;
        this.periodId = periodId;
        this.userId = userId;
        this.recordVal = recordVal;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getRecordVal() {
        return recordVal;
    }
}