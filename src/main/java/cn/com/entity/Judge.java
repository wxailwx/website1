package cn.com.entity;

public class Judge {
    /*
    * 评价记录id
    * */
    private int id;
    /*
    * 用户id
    * */
    private int userId;
    /*
    * 评价
    * */
    private String judge;
    /*
    * 商家id
    * */
    private int shoperId;
    /*
    * 评星
    * */
    private int star;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public int getShoperId() {
        return shoperId;
    }

    public void setShoperId(int shoperId) {
        this.shoperId = shoperId;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
