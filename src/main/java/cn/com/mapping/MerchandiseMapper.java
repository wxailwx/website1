package cn.com.mapping;

import cn.com.entity.Merchandise;

import java.util.List;

public interface MerchandiseMapper {
    boolean insertMerchandise(Merchandise merchandise)throws Exception;
    List<Merchandise> selectMerchandise(int shop_id)throws Exception;
}
