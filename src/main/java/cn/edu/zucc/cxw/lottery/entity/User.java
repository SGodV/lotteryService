package cn.edu.zucc.cxw.lottery.entity;

public class User {
    private Integer id;

    private String userEmail;

    private String userPwd;

    private String userName;

    private Integer rockPeriod;

    private String userPower;

    private String userPhone;

    public User(Integer id, String userEmail, String userPwd, String userName, Integer rockPeriod, String userPower, String userPhone) {
        this.id = id;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.userName = userName;
        this.rockPeriod = rockPeriod;
        this.userPower = userPower;
        this.userPhone = userPhone;
    }

    public Integer getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getRockPeriod() {
        return rockPeriod;
    }

    public String getUserPower() {
        return userPower;
    }

    public String getUserPhone() {
        return userPhone;
    }
}