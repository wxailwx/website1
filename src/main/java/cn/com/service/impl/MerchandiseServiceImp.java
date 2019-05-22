package cn.com.service.impl;

import cn.com.entity.Merchandise;
import cn.com.mapping.MerchandiseMapper;
import cn.com.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchandiseServiceImp implements MerchandiseService {
    @Autowired
    private MerchandiseMapper merchandiseMapper;
    public boolean insertMerchandise(Merchandise merchandise)throws Exception{
        return merchandiseMapper.insertMerchandise(merchandise);
    }
}
