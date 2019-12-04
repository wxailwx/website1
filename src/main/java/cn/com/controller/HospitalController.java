package cn.com.controller;

import cn.com.dto.HChangeToS;
import cn.com.entity.Hospital;
import cn.com.entity.HospitalShow;
import cn.com.service.impl.HospitalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HospitalController {
    @Autowired
    private HospitalServiceImp hospitalServiceImp;
    @RequestMapping(value="Hospital.action",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    private String findHospital(int page,int limit,String name)throws Exception{
        List<Hospital> list;
        if(name==null){
            list = hospitalServiceImp.findHospital();
        }
        else {
            System.out.println(name);
            list = hospitalServiceImp.findHospitalByName(name);
        }
        int count = list.size();
        List<HospitalShow> list1 = HChangeToS.HChangeToS(list);
        String js = HChangeToS.ChangeToString(list1);
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        return jso;
    }
}
