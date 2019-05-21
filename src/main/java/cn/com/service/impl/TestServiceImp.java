package cn.com.service.impl;

import cn.com.entity.User;
import cn.com.mapping.UserMapper;
import cn.com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImp implements TestService {
    @Autowired
    private UserMapper userMapper;
    //private UserMapperImp userMapperImp;
    public User findUserByName(String username) throws Exception{
        User user=userMapper.findUserByName(username);
        //User user=userMapperImp.findUserByName(username);
        if(user==null){
            System.out.println("error in service");
        }
        return user;
    }
    public boolean insertUser(User user)throws Exception{
         return userMapper.insertUser(user);
    }
    public boolean updateUser(User user)throws Exception{
        return userMapper.updateUser(user);
    }
    public User findUserById(Integer id)throws Exception{
        return userMapper.findUserById(id);
    }
}
