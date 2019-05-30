package cn.com.mapping;

import cn.com.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper{
     //输入用户名查找
     User findUserByName(String username)throws Exception;
     //插入用户
     boolean insertUser(User user)throws Exception;
     //更新用户信息
     boolean updateUser(User user)throws Exception;
     //通过id唯一查找用户
     User findUserById(Integer id)throws Exception;
     //查找所有用户
     List<User> findUser()throws Exception;
}
