package cn.com.entity;
/*
* 商家实体类
* */
public class Shoper extends BaseBean{
    /*
    * 主键
    * */
    private int id;
    /*
    *商家名
    * */
    private String shopname;
    /*
    * 商家地址
    * */
    private String address;
    /*
    * 商店图片存放地址
    * */
    private String picture;
    /*
    * 商店简介
    * */
    private String message;
    /*
    * 商店评价
    * */
    private String estimate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }
}
