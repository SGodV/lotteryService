package cn.edu.zucc.cxw.lottery.entity;

public class Result {
    private Integer id;

    private Integer resultPeriod;

    private String resultVal;

    public Result(Integer id, Integer resultPeriod, String resultVal) {
        this.id = id;
        this.resultPeriod = resultPeriod;
        this.resultVal = resultVal;
    }

    public Integer getId() {
        return id;
    }

    public Integer getResultPeriod() {
        return resultPeriod;
    }

    public String getResultVal() {
        return resultVal;
    }
}