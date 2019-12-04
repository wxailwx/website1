package cn.com.service;

import cn.com.entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> findHospitalByName(String name) throws Exception;
    List<Hospital> findHospital() throws Exception;
}
