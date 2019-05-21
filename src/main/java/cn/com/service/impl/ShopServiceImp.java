package cn.com.service.impl;

import cn.com.entity.Shoper;
import cn.com.mapping.ShopMapper;
import cn.com.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImp implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    public Shoper findShopByName(String shopname)throws Exception{
        return shopMapper.findShopByName(shopname);
    }
    public List<Shoper> findShopByType(String type)throws Exception{
        return shopMapper.findShopByType(type);
    }
    public Shoper findShopById(Integer id)throws Exception{
        return shopMapper.findShopById(id);
    }
    public boolean insertShop(Shoper shoper)throws Exception{
        return shopMapper.insertShop(shoper);
    }
    public boolean updateShop(Shoper shoper)throws Exception{
        return shopMapper.updateShop(shoper);
    }
}
