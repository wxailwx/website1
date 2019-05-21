package cn.com.service;

import cn.com.entity.Shoper;

public interface ShopService {
    Shoper findShopById(Integer id)throws Exception;
    boolean insertShop(Shoper shoper)throws Exception;
}
