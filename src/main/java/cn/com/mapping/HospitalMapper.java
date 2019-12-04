package cn.com.mapping;

import cn.com.entity.Hospital;

import java.util.List;

public interface HospitalMapper {
    List<Hospital> findHospitalByName(String name) throws Exception;
    List<Hospital> findHospital() throws Exception;
}
