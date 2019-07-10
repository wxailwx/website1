package cn.com.controller;

import cn.com.entity.Merchandise;
import cn.com.entity.Shoper;
import cn.com.entity.User;
import cn.com.p1.Test;
import cn.com.service.impl.MerchandiseServiceImp;
import cn.com.service.impl.ShopServiceImp;
import cn.com.service.impl.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static cn.com.p1.Test.*;

@Controller
public class Shop {
    @Autowired
    private ShopServiceImp shopServiceImp;
    @Autowired
    private TestServiceImp testServiceImp;
    @Autowired
    private MerchandiseServiceImp merchandiseServiceImp;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("shops.action")
    @ResponseBody
    private List<Shoper> shops(final int type)throws Exception{
        //type是按照哪种方式排序
        List<Shoper> shopers;
        shopers=shopServiceImp.findShop();
        List<User> userList=testServiceImp.findUser();
        int []shop=new int[shopers.size()];
        if(type==1){//游客状态下推荐
            HttpSession session=request.getSession();
            List<Shoper> shopers1=new ArrayList<>();
            if (session.getAttribute("username")==null){
                int [][]p=new int[userList.size()][];
                for(int j=0;j<userList.size();j++){
                    p[j]= toint(userList.get(j).getHistoryString());
                }
                shop= shopstart2(userList.size(),shopers.size(),p);
                for(int j=0;j<shopers.size();++j){
                    shopers1.add(shopers.get(shop[j]));
                }
            }else {
                int [][]p=new int[userList.size()][];
                for(int j=0;j<userList.size();j++){
                    p[j]= toint(userList.get(j).getHistoryString());
                }
                shop=shopstart1(userList.size(),shopers.size(),(int)session.getAttribute("id"),p);
                for(int j=0;j<shopers.size();++j){
                    shopers1.add(shopers.get(shop[j]));
                }

            }
            return shopers1;
        }
        else{//按人数、价格排序
            Collections.sort(shopers, new Comparator<Shoper>() {
                @Override
                public int compare(Shoper o1, Shoper o2) {
                    if(type==2)
                    {
                        if(o1.getPeople() < o2.getPeople())
                            return 1;
                        else if(o1.getPeople()==o2.getPeople())return 0;
                        else return -1;
                    }
                    else{
                        if(o1.getPrice() > o2.getPrice())
                            return 1;
                        else if(o1.getPrice()==o2.getPrice())return 0;
                        else return -1;
                    }
                }
            });
        }
//        else if (type==3){
//            Collections.sort(shopers, new Comparator<Shoper>() {
//                @Override
//                public int compare(Shoper o1, Shoper o2) {
//                    if(o1.getPrice()<o2.getPrice())
//                        return 1;
//                    else return 0;
//                }
//            });
//        }
        return shopers;
    }
    @RequestMapping("searchshop.action")
    @ResponseBody
    private List<Shoper> search(Shoper shoper)throws Exception{
        System.out.println("Controller!");
        Shoper shoper1=shopServiceImp.findShopByName(shoper.getShopname());
        List<Shoper> shoperList=new ArrayList<>();
        shoperList.add(shoper1);
        return shoperList;
    }
    @RequestMapping("merchandise.action")
    @ResponseBody
    private List<Merchandise> searchMerchandise(int id)throws Exception{
        return merchandiseServiceImp.selectMerchandise(id);
    }
    @RequestMapping("searchone.action")
    @ResponseBody
    private Shoper searchone (int id)throws Exception{
        return shopServiceImp.findShopById(id);
    }
}
