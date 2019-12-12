package cn.com.controller;

import cn.com.dto.DChangeToS;
import cn.com.dto.HChangeToS;
import cn.com.dto.SChangeToS;
import cn.com.entity.*;
import cn.com.service.impl.OfficeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SmallController {
    @Autowired
    private OfficeServiceImp officeServiceImp;
    @RequestMapping(value="findOffice.action", produces = "application/json; charset=utf-8")
    @ResponseBody
    private String findOffice(int page,int limit)throws Exception{
        List<Office> list ;
        list = officeServiceImp.findOffice();
        String js = SChangeToS.OChangeToS(list);
        int count = list.size();
        System.out.println(js);
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        return jso;
    }
    @RequestMapping(value = "findTip.action",produces = "application/json; charset=utf-8")
    @ResponseBody
    private String findTip(int page,int limit,String name)throws Exception{
        System.out.println("page:"+page);
        System.out.println("limit"+limit);
        List<Tip> list ;
        if (name == null){
            list = officeServiceImp.findTip();
        }else {
            list = officeServiceImp.findTipByName(name);
        }
        System.out.println("tip is over");
        String js = SChangeToS.TChangeToS(page,limit,list);
        System.out.println("tip String is over");
        //System.out.println(js);
        int count = list.size();
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        System.out.println(jso);
        return jso;
    }
    @Autowired HttpServletRequest request;
    @RequestMapping(value = "login.action")
    @ResponseBody
    private boolean login(User user)throws Exception{
        User user1 = officeServiceImp.findUser(user.getUsername());
        if(user1!=null&&user1.getPassword().equals(user.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("username",user1.getUsername());
            session.setAttribute("userid",user1.getUserid());
            session.setAttribute("password",user1.getPassword());
            session.setAttribute("usercase",user1.getUsercase());
            return true;
        }
        return false;
    }
    @RequestMapping(value = "sign.action")
    @ResponseBody
    private boolean sign(User user)throws Exception{
        User user1 = officeServiceImp.findUser(user.getUsername());
        if(user1!=null){
            return false;
        }
        else {
            user.setUsercase("");
            boolean isUse = officeServiceImp.insertUser(user);
            return isUse;
        }
    }
    @RequestMapping(value = "findUserFavDoc.action",produces = "application/json; charset=utf-8")
    @ResponseBody
    private String findUserFavDoc(Integer page,Integer limit, Integer userid)throws Exception{
        List<Doctor> list;
        System.out.println("page:"+page+" limit"+limit+" userid"+userid);
        if(page==null) page=1;
        if(limit==null) limit=10;
        if (userid == null) {
            System.out.println("11111111111");
           return  "{\"code\":0,\"msg\":\"\",\"count\":"+"0"+",\"data\":"+"{}"+"}";
        }else {
            list= officeServiceImp.findUserFavDoc(userid);
            System.out.println("22222222");
            System.out.println(list.size());
            return DChangeToS.DoctorToString(page,limit,list);
        }
        //return DChangeToS.DoctorToString(page,limit,list);
    }
    @RequestMapping(value = "deleteUserFavDoc.action",produces = "application/json;charset=utf-8")
    @ResponseBody
    private boolean deleteUserFavDoc(Integer page, Integer limit, UserFavDoc userFavDoc)throws Exception{
        System.out.println(userFavDoc.getDID());
        return officeServiceImp.deleteUserFavDoc(userFavDoc);
    }
    @RequestMapping(value = "insertUserFavDoc.action",produces = "application/json;charset=utf-8")
    @ResponseBody
    private boolean insertUserFavDoc(Integer page,Integer limit,UserFavDoc userFavDoc)throws Exception{
        System.out.println(userFavDoc.getDID());
        return officeServiceImp.insertUserFavDoc(userFavDoc);
    }
    @RequestMapping(value = "findUserFavHos.action",produces = "application/json; charset=utf-8")
    @ResponseBody
    private String findUserFavHos(Integer page,Integer limit,Integer userid)throws Exception{
        List<Hospital> list;
        if(page==null) page=1;
        if(limit==null) limit=10;
        if (userid == null) {
            System.out.println("11111111111");
            return  "{\"code\":0,\"msg\":\"\",\"count\":"+"0"+",\"data\":"+"{}"+"}";
        }else {
            list = officeServiceImp.findUserFavHos(userid);
            return HChangeToS.HosChangeToString(page,limit,list);
        }
    }
    @RequestMapping(value = "deleteUserFavHos.action",produces = "application/json;charset=utf-8")
    @ResponseBody
    private boolean deleteUserFavHos(Integer page,Integer limit,UserFavHos userFavHos)throws Exception{
        System.out.println(userFavHos.getHID());
        return officeServiceImp.deleteUserFavHos(userFavHos);
    }
    @RequestMapping(value = "insertUserFavHos.action",produces = "application/json;charset=utf-8")
    @ResponseBody
    private boolean insertUserFavHos(Integer page,Integer limit,UserFavHos userFavHos)throws Exception{
        System.out.println(userFavHos.getHID());
        return officeServiceImp.insertUserFavHos(userFavHos);
    }
}
