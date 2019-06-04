package cn.com.entity;

public class Judge {
    /*
    * 评价记录id
    * */
    private int id;
    /*
    * 用户id
    * */
    private int userid;
    /*
    * 评价
    * */
    private String judge;
    /*
    * 商家id
    * */
    private int shoperid;
    /*
    * 评星
    * */
    private int star;
    /*
    * 用户名
    * */
    private String username;
    /*
    * 消费价格
    * */
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getShoperid() {
        return shoperid;
    }

    public void setShoperid(int shoperid) {
        this.shoperid = shoperid;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
