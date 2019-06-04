package cn.com.controller;

import cn.com.entity.Shoper;
import cn.com.service.impl.JudgeServiceImp;
import cn.com.service.impl.ShopServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Judge {
    @Autowired
    private JudgeServiceImp judgeServiceImp;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ShopServiceImp shopServiceImp;
    @RequestMapping("serachJudge.action")
    @ResponseBody
    private List<cn.com.entity.Judge> judges(int id)throws Exception{
        List<cn.com.entity.Judge> judges=judgeServiceImp.searchJudge(id);
        System.out.println(judges.size()+"!!!!");
        return judgeServiceImp.searchJudge(id);
    }
    @RequestMapping("insertJudge.action")
    @ResponseBody
    private boolean insertJudge(cn.com.entity.Judge judge)throws Exception{
        HttpSession session=request.getSession();
        if(session.getAttribute("username")==null){
            return false;
        }
        else {
            judge.setUsername((String)session.getAttribute("username"));
            judge.setUserid((int)session.getAttribute("id"));
            //修改商家评价人数和价格、星级
            Shoper shoper=shopServiceImp.findShopById(judge.getShoperid());
            int price=shoper.getPrice();
            int people=shoper.getPeople();
            int star=shoper.getStar();
            price=(price*people+judge.getPrice())/(people+1);
            star=(star*people+judge.getStar())/(people+1);
            people++;
            shoper.setPeople(people);
            shoper.setPrice(price);
            shoper.setStar(star);
            shopServiceImp.updateShop(shoper);
            return judgeServiceImp.insertJudge(judge);
        }
    }
}
