package cn.com.entity;

import java.sql.Date;
/*
* 用户实体类
* */
public class User{
    /*
    * 主键
    */
    private int id;
    /*
    * 用户名
    * */
    private String username;
    /*
    * 登陆密码
    * */
    private String password;
    /*
    * 登陆邮箱
    * */
    private String email;
    /*
    * 注册时间
    * */
    private Date date;
    /*
    * 所在学院
    * */
    private String college;
    /*
     * 用户访问记录
     * */
    private int[] history;
    /*
    * 使用String方式传输到数据库
    * */

    private String historyString;

    public String getHistoryString() {
        return historyString;
    }

    public void setHistoryString(String historyString) {
        this.historyString = historyString;
    }

    public Date getDate() {
        return date;
    }
    public int[] getHistory() {
        return history;
    }

    public void setHistory(int[] history) {
        this.history = history;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
