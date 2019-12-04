package cn.com.service;

import cn.com.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findDoctorByName(String name)throws Exception;
    List<Doctor> findDoctor() throws Exception;
}
