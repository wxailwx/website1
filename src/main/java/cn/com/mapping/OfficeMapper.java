package cn.com.mapping;

import cn.com.entity.*;

import java.util.List;

public interface OfficeMapper {
    List<Office> findOffice()throws Exception;
    List<Tip> findTip()throws Exception;
    List<Tip> findTipByName(String name)throws Exception;
    Boolean insertUser(User user)throws Exception;
    Boolean updateUser(User user)throws Exception;
    User findUser(String name)throws Exception;
//    收藏医生
    List<Doctor> findUserFavDoc(int userid)throws Exception;
    boolean insertUserFavDoc(UserFavDoc userFavDoc)throws Exception;
    boolean deleteUserFavDoc(UserFavDoc userFavDoc)throws Exception;
//    收藏医院
    List<Hospital> findUserFavHos(int userid) throws Exception;
    boolean insertUserFavHos(UserFavHos userFavHos)throws Exception;
    boolean deleteUserFavHos(UserFavHos userFavHos)throws Exception;
}
