package cn.com.service;

import cn.com.entity.User;


public interface TestService {
    User findUserByName(String username)throws Exception;
    boolean insertUser(User user)throws Exception;
    boolean updateUser(User user)throws Exception;
    User findUserById(Integer id)throws Exception;
}
