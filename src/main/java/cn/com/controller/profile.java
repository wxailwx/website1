package cn.com.controller;

import cn.com.entity.User;
import cn.com.service.impl.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class profile {
    @Autowired
    private TestServiceImp testServiceImp;
    @RequestMapping("submitUser.action")
    @ResponseBody
    private boolean submitUser(User user)throws Exception{
        return testServiceImp.updateUser(user);
    }
}
