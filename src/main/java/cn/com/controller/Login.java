package cn.com.controller;

import cn.com.entity.User;
import cn.com.service.impl.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class Login {
    @Autowired
    private TestServiceImp testServiceImp;
    @Autowired HttpServletRequest request;
    @RequestMapping("login.action")
    @ResponseBody
    private boolean login(User user)throws Exception{
        User user1=testServiceImp.findUserByName(user.getUsername());
        if(user1!=null&&user1.getPassword().equals(user.getPassword())){
            //HttpSession session=httpServletRequest.getSession();
            HttpSession session=request.getSession();
            session.setAttribute("username",user1.getUsername());
            return true;
        }
        return false;
    }
    @RequestMapping("sign.action")
    @ResponseBody
    private boolean sign(User user)throws Exception{
        User user1=testServiceImp.findUserByName(user.getUsername());
        if (user1!=null){
            return false;
        }
        else {
            java.util.Date utilDate=new java.util.Date();
            user.setDate(new java.sql.Date(utilDate.getTime()));
            boolean isUse=testServiceImp.insertUser(user);
            if(isUse)
                return true;
            else return false;
        }
    }
    @RequestMapping("logout.action")
    @ResponseBody
    private void logout()throws Exception{
        HttpSession session=request.getSession();
        session.removeAttribute("username");
    }
}
