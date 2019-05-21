package test.java.cn.com.db;

import cn.com.entity.User;
import cn.com.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class UserDaoTest {
    @Autowired
    private TestService testService;
    @Test
    public void testUser() throws Exception{
        User user=testService.findUserByName("张三");
        if(user!=null)
        System.out.println(user.getUsername());
        else{
            System.out.println("error in test!");
        }
    }
    @Test
    public void testInsertUser()throws Exception{
        User user=new User();
        user.setCollege("数学");
        user.setEmail("444@123.com");
        user.setPassword("222");
        user.setUsername("杜月笙");
        java.util.Date utilDate=new java.util.Date();
        user.setDate(new java.sql.Date(utilDate.getTime()));
        boolean isSuccess=testService.insertUser(user);
        if(isSuccess){
            System.out.println("success");
        }
        else{
            System.out.println("error in testInsertUser");
        }
    }
    @Test
    public void testUpdateUser()throws Exception{
        User user=new User();
        user.setEmail("444@123.com");
        user.setCollege("生物");
        user.setPassword("222");
        user.setUsername("杜月笙");
        user.setId(3);//需要id来唯一确认
        java.util.Date utilDate=new java.util.Date();
        user.setDate(new java.sql.Date(utilDate.getTime()));
        boolean isSuccess=testService.updateUser(user);
        System.out.println(isSuccess);
    }
    @Test
    public void testFindUserById()throws Exception{
        User user=testService.findUserById(3);
        System.out.println(user.getUsername());
        System.out.println(user.getDate());
    }
}
