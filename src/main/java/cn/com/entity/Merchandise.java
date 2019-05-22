package cn.com.entity;
/*
* 商品与商店之间的表是多对1的关系
* */
public class Merchandise{
    /*
    * 商品名称
    * */
    private String name;
    /*
    * 商品价格
    * */
    private int price;
    /*
    * 商品图片地址
    * */
    private String address;
    /*
    * 商品评分星级
    * */
    private int star;
    /*
    * 商品编号，不可重复
    * */
    private int id;
    /*
    * 商品所属店家,需要和商家的id一致
    * */
    private int shop_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }
}
