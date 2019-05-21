package cn.com.controller;

import cn.com.entity.User;
import cn.com.service.impl.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private TestServiceImp testService;
    @RequestMapping("findUser.action")
    @ResponseBody
    private User findUser(User user)throws Exception{
        User user1=testService.findUserByName(user.getUsername());
        System.out.println(user1.getId()+user1.getCollege());
        return user1;
    }
}
