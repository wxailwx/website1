package cn.com.controller;

import cn.com.entity.User;
import cn.com.service.impl.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class profile {
    @Autowired
    private TestServiceImp testServiceImp;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("submitUser.action")
    @ResponseBody
    private boolean submitUser(User user)throws Exception{
        if(testServiceImp.updateUser(user)){
            User user1=testServiceImp.findUserByName(user.getUsername());
            HttpSession session=request.getSession();
            session.setAttribute("username",user1.getUsername());
            session.setAttribute("password",user1.getPassword());
            session.setAttribute("email",user1.getEmail());
            session.setAttribute("date",user1.getDate());
            session.setAttribute("college",user1.getCollege());
            return true;
        }
        else return false;
    }
}
