package cn.com.dto;

import cn.com.entity.Hospital;
import cn.com.entity.HospitalShow;

import java.util.LinkedList;
import java.util.List;

public class HChangeToS {
    public static List<HospitalShow> HChangeToS(int page,int limit,List<Hospital> list){
        List<HospitalShow> list1 = new LinkedList<>();
        for (int i=(page-1)*limit;i<page*limit && i<list.size();i++){
            HospitalShow hospitalShow = new HospitalShow();
            hospitalShow.setName(list.get(i).getHos_name());
            hospitalShow.setAddress(list.get(i).getAddress());
            hospitalShow.setCity(list.get(i).getCity());
            hospitalShow.setClass1(list.get(i).getClass1());
            hospitalShow.setIntroduction(list.get(i).getIntroduction());
            hospitalShow.setHID(list.get(i).getHID());
            list1.add(hospitalShow);
        }
        return list1;
    }
    public static String ChangeToString(List<HospitalShow> list){
        String s="";
        s+="[";
        for (int i=0;i<list.size();i++){
            s+="{\"id\":\"";
            s+=list.get(i).getHID();
            s+="\",\"name\":\"";
            s+=list.get(i).getName();
            s+="\",\"address\":\"";
            s+=list.get(i).getAddress();
            s+="\",\"city\":\"";
            s+=list.get(i).getCity();
            s+="\",\"class1\":\"";
            s+=list.get(i).getClass1();
            //s+="\",\"introduction\":\"";
            //s+=list.get(i).getIntroduction();
            if (i<list.size()-1)
                s+="\"},";
            else s+="\"}";
        }
        s+="]";
        return s;
    }
    public static String HosChangeToString(int page,int limit,List<Hospital> list){
        int count = list.size();
        List<HospitalShow> list1 = HChangeToS.HChangeToS(page,limit,list);
        String js = HChangeToS.ChangeToString(list1);
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        return jso;
    }
}
