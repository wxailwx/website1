package cn.com.mapping;

import cn.com.entity.Shoper;

import java.util.List;

public interface ShopMapper {
    Shoper findShopByName(String shopname)throws Exception;
    List<Shoper> findShopByType(String type)throws Exception;
    boolean insertShop(Shoper shoper)throws Exception;
    Shoper findShopById(Integer id)throws Exception;
    boolean updateShop(Shoper shoper)throws Exception;
    List<Shoper> findShop()throws Exception;
}
