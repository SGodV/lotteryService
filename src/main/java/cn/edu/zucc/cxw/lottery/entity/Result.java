package cn.edu.zucc.cxw.lottery.entity;

public class Result {
    private Integer id;

    private Integer resultPeriod;

    private String resultVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResultPeriod() {
        return resultPeriod;
    }

    public void setResultPeriod(Integer resultPeriod) {
        this.resultPeriod = resultPeriod;
    }

    public String getResultVal() {
        return resultVal;
    }

    public void setResultVal(String resultVal) {
        this.resultVal = resultVal == null ? null : resultVal.trim();
    }
}