package cn.com.dto;

import cn.com.entity.Hospital;
import cn.com.entity.HospitalShow;

import java.util.LinkedList;
import java.util.List;

public class HChangeToS {
    public static List<HospitalShow> HChangeToS(List<Hospital> list){
        List<HospitalShow> list1 = new LinkedList<>();
        for (int i=0;i<list.size();i++){
            HospitalShow hospitalShow = new HospitalShow();
            hospitalShow.setName(list.get(i).getHos_name());
            hospitalShow.setAddress(list.get(i).getAddress());
            hospitalShow.setClass1(list.get(i).getClass1());
            hospitalShow.setIntroduction(list.get(i).getIntroduction());
            list1.add(hospitalShow);
        }
        return list1;
    }
    public static String ChangeToString(List<HospitalShow> list){
        String s="";
        s+="[";
        for (int i=0;i<list.size();i++){
            s+="{\"name\":\"";
            s+=list.get(i).getName();
            s+="\",\"address\":\"";
            s+=list.get(i).getAddress();
            s+="\",\"introduction\":\"";
            s+=list.get(i).getIntroduction();
            if (i<list.size()-1)
                s+="\"},";
            else s+="\"}";
        }
        s+="]";
        return s;
    }
}
