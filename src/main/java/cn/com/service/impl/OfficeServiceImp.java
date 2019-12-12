package cn.com.service.impl;

import cn.com.entity.*;
import cn.com.mapping.OfficeMapper;
import cn.com.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficeServiceImp implements OfficeService {
    @Autowired
    private OfficeMapper officeMapper;
    public List<Office> findOffice() throws Exception{
        return officeMapper.findOffice();
    }
    public List<Tip> findTip()throws Exception{
        return officeMapper.findTip();
    }
    public List<Tip> findTipByName(String name)throws Exception{
        return officeMapper.findTipByName(name);
    }
    public Boolean insertUser(User user)throws Exception{
        return officeMapper.insertUser(user);
    }
    public Boolean updateUser(User user)throws Exception{
        return officeMapper.updateUser(user);
    }
    public User findUser(String name)throws Exception{
        return officeMapper.findUser(name);
    }
    public List<Doctor> findUserFavDoc(int userid)throws Exception{
        return officeMapper.findUserFavDoc(userid);
    }
    public boolean insertUserFavDoc(UserFavDoc userFavDoc)throws Exception{
        return officeMapper.insertUserFavDoc(userFavDoc);
    }
    public boolean deleteUserFavDoc(UserFavDoc userFavDoc)throws Exception{
        return officeMapper.deleteUserFavDoc(userFavDoc);
    }
    public List<Hospital> findUserFavHos(int userid) throws Exception{
        return officeMapper.findUserFavHos(userid);
    }
    public boolean insertUserFavHos(UserFavHos userFavHos)throws Exception{
        return officeMapper.insertUserFavHos(userFavHos);
    }
    public boolean deleteUserFavHos(UserFavHos userFavHos)throws Exception{
        return officeMapper.deleteUserFavHos(userFavHos);
    }
}
