package cn.com.mapping;

import cn.com.entity.Doctor;

import java.util.List;

public interface DoctorMapper {
    List<Doctor> findDoctorByName(String name)throws Exception;
    List<Doctor> findDoctor() throws Exception;
}
