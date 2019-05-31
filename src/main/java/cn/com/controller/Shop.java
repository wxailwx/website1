package cn.com.controller;

import cn.com.entity.Shoper;
import cn.com.entity.User;
import cn.com.p1.Test;
import cn.com.service.impl.ShopServiceImp;
import cn.com.service.impl.TestServiceImp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static cn.com.p1.Test.*;

@Controller
public class Shop {
    @Autowired
    private ShopServiceImp shopServiceImp;
    @Autowired
    private TestServiceImp testServiceImp;
    @RequestMapping("shops.action")
    @ResponseBody
    private List<Shoper> shops(int type)throws Exception{
        //type是按照哪种方式排序
        //System.out.println("***"+type);
        List<Shoper> shopers;
        shopers=shopServiceImp.findShop();
        List<User> userList=testServiceImp.findUser();
        //System.out.println("##"+userList.size());
        int []shop=new int[shopers.size()];
        if(type==0){//游客状态下推荐
            int [][]p=new int[userList.size()][];
            for(int j=0;j<userList.size();j++){
                p[j]= toint(userList.get(j).getHistoryString());
//                for (int k=0;k<p[j].length;++k)
//                    System.out.println("$$$"+p[j][k]);
            }
            shop= shopstart2(userList.size(),shopers.size(),p);
        }
        List<Shoper> shopers1=new ArrayList<>();
        for(int j=0;j<shopers.size();++j){
            shopers1.add(shopers.get(shop[j]));
            //System.out.println(shop[j]);
        }

        return shopers1;
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
