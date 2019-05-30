package cn.com.controller;

import cn.com.entity.Shoper;
import cn.com.service.impl.ShopServiceImp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class Shop {
    @Autowired
    private ShopServiceImp shopServiceImp;
    @RequestMapping("shops.action")
    @ResponseBody
    private List<Shoper> shops()throws Exception{
        //type是按照哪种方式排序
        List<Shoper> shopers;
        shopers=shopServiceImp.findShop();
        return shopers;
    }
    @RequestMapping("searchshop.action")
    @ResponseBody
    private List<Shoper> search(Shoper shoper)throws Exception{
        //System.out.println(shopname);
        System.out.println("Controller!");
        Shoper shoper1=shopServiceImp.findShopByName(shoper.getShopname());
        List<Shoper> shoperList=new ArrayList<>();
        shoperList.add(shoper1);
        return shoperList;
    }
}
