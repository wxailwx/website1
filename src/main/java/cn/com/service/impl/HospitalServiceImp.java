package cn.com.service.impl;

import cn.com.entity.Hospital;
import cn.com.mapping.HospitalMapper;
import cn.com.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImp implements HospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;
    public List<Hospital> findHospitalByName(String name) throws Exception{
        return hospitalMapper.findHospitalByName(name);
    }
    public List<Hospital> findHospital() throws Exception{
        return hospitalMapper.findHospital();
    }
}
