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
        List<Doctor> doctorList;
        if (name==null)
            doctorList = doctorServiceImp.findDoctor();
        else
        {
            System.out.println(name);
            doctorList = doctorServiceImp.findDoctorByName(name);
        }
//        Collections.sort(doctorList, new Comparator<Doctor>() {
//            @Override
//            public int compare(Doctor o1, Doctor o2) {
//                return 1;
//            }
//        });
        System.out.println(doctorList.get(0).getName());
        System.out.println(doctorList.get(0).getDID());
        LinkedList<DoctorShow> doctorShows = DChangeToS.DChangeToS(doctorList);
        System.out.println(doctorShows.size());

        int count = doctorShows.size();
        String js= DChangeToS.ChangeToString(doctorShows);
        System.out.println(js);
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        //System.out.println("1"+jso);
        //String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+"1"+",\"data\":"+"[{\"name\":\"刘山\",\"profession\":\"教授\"}]"+"}";
        return jso;
    }
}
