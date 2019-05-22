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
/*
* 测试UserMapper连接User数据库的各种方法
* */
public class UserDaoTest {
    @Autowired
    private TestService testService;
    /*
    * 测试查找方法
    * */
    @Test
    public void testUser() throws Exception{
        User user=testService.findUserByName("张三");
        if(user!=null)
        System.out.println(user.getUsername());
        else{
            System.out.println("查无此人");
        }
    }

    /*
    * 测试插入user方法
    * */
    @Test
    public void testInsertUser()throws Exception{
        User user=new User();
        user.setCollege("数学");
        user.setEmail("222@123.com");
        user.setPassword("222");
        user.setUsername("杜月笙");
        java.util.Date utilDate=new java.util.Date();
        user.setDate(new java.sql.Date(utilDate.getTime()));

        User user1=testService.findUserByName(user.getUsername());
        if(user1!=null){
            System.out.println("该用户已存在！");
            return;
        }
        boolean isSuccess=testService.insertUser(user);
        if(isSuccess){
            System.out.println("success");
        }
        else{
            System.out.println("error in testInsertUser");
        }
    }
    /*
    * 测试更新方法
    * */
    @Test
    public void testUpdateUser()throws Exception{
        User user=new User();
        user.setEmail("222@123.com");
        user.setCollege("生物");
        user.setPassword("222");
        user.setUsername("杜月笙");
        User user1=testService.findUserByName(user.getUsername());
        if(user1==null){
            System.out.println("该用户不存在。更新失败！");
        }
        boolean isSuccess=testService.updateUser(user);
        if(isSuccess){
            System.out.println("更新成功！");
        }
        else{
            System.out.println("更新失败！");
        }
    }
    @Test
    public void testFindUserById()throws Exception{
        User user=testService.findUserById(3);
        System.out.println(user.getUsername());
        System.out.println(user.getDate());
    }
}
