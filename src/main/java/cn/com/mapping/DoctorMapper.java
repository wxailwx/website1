package cn.com.mapping;

import cn.com.entity.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorMapper {
    List<Doctor> findDoctorByName(String name)throws Exception;
    List<Doctor> findDoctor() throws Exception;
    List<Doctor> findDoctorByOffice(String name)throws Exception;
    Doctor doctorDetail(String id)throws Exception;
}
