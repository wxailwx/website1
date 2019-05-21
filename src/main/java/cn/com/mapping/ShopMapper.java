package cn.com.mapping;

import cn.com.entity.Shoper;

public interface ShopMapper {
    Shoper findShopById(Integer id)throws Exception;
    boolean insertShop(Shoper shoper)throws Exception;
}
