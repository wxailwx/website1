package cn.com.controller;

import cn.com.entity.User;
import cn.com.service.impl.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {
    @Autowired
    private TestServiceImp testServiceImp;
    @RequestMapping("login.action")
    @ResponseBody
    private boolean login(User user)throws Exception{
        User user1=testServiceImp.findUserByName(user.getUsername());
        if(user1!=null&&user1.getPassword().equals(user.getPassword())){
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
}
