package cn.com.service;

import cn.com.entity.Merchandise;

import java.util.List;

public interface MerchandiseService {
    boolean insertMerchandise(Merchandise merchandise)throws Exception;
    List<Merchandise> selectMerchandise(int shop_id)throws Exception;
}
