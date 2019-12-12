package cn.com.controller;

import cn.com.dto.DChangeToS;
import cn.com.entity.Doctor;
import cn.com.entity.DoctorShow;
import cn.com.service.impl.DoctorServiceImp;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
@Controller
public class DoctorController {
    @Autowired
    private DoctorServiceImp doctorServiceImp;
    @RequestMapping(value="DoctorName.action",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    private String findDoctorByName(int page,int limit,String name)throws Exception{
//        String[] source = name.split(" ");
//        String newname="";
        List<Doctor> doctorList;
        if (name==null)
            doctorList = doctorServiceImp.findDoctor();
        else
        {
//            for(int i=0;i<source.length;i++){
//                newname+=source[i];
//            }
            doctorList = doctorServiceImp.findDoctorByName(name);
        }
//        Collections.sort(doctorList, new Comparator<Doctor>() {
//            @Override
//            public int compare(Doctor o1, Doctor o2) {
//                return 1;
//            }
//        });
        return DChangeToS.DoctorToString(page,limit,doctorList);
    }
    @RequestMapping(value = "DoctorFaculty.action",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    private String findDoctorByOffic(int page,int limit,String name)throws Exception{
        System.out.println(name);
        List<Doctor> list ;
        if(name == null)
            list = doctorServiceImp.findDoctor();
        else list = doctorServiceImp.findDoctorByOffice(name);
        return DChangeToS.DoctorToString(page,limit,list);
    }
    @RequestMapping(value = "DoctorDetail.action",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    private Doctor DoctorDetail(String id)throws Exception{
        System.out.println(id);
        Doctor doctor = doctorServiceImp.doctorDetail(id);
        System.out.println("111");
        System.out.println(doctor.getName());
        return doctor;
    }
}
