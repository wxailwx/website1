package cn.com.entity;
/*
* 商家实体类
* */
public class Shoper{
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
    /*
    * 店铺星级
    * */
    private int star;
    /*
    * 店铺类别
    * */
    private String type;
    /*
    * 评价人数
    * */
    private int people;
    /*
    * 人均价格
    * */
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
