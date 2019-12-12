package cn.com.service.impl;

import cn.com.entity.Doctor;
import cn.com.mapping.DoctorMapper;
import cn.com.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorServiceImp implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<Doctor> findDoctorByName(String name) throws Exception {
        return doctorMapper.findDoctorByName(name);
    }
    @Override
    public List<Doctor> findDoctor() throws Exception{
        return doctorMapper.findDoctor();
    }
    @Override
    public List<Doctor> findDoctorByOffice(String name)throws Exception{
        return doctorMapper.findDoctorByOffice(name);
    }
    @Override
    public Doctor doctorDetail(String id)throws Exception{
        return doctorMapper.doctorDetail(id);
    }
}
