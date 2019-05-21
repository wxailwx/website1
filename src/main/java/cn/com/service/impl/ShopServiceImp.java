package cn.com.service.impl;

import cn.com.entity.Shoper;
import cn.com.mapping.ShopMapper;
import cn.com.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImp implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    public Shoper findShopById(Integer id)throws Exception{
        return shopMapper.findShopById(id);
    }
    public boolean insertShop(Shoper shoper)throws Exception{
        return shopMapper.insertShop(shoper);
    }
}
