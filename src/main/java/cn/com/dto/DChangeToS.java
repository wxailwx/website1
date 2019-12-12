package cn.com.dto;

import cn.com.entity.Doctor;
import cn.com.entity.DoctorShow;

import java.util.*;

public class DChangeToS {
    public static LinkedList<DoctorShow> DChangeToS (int page,int limit,List<Doctor> doctors){
        LinkedList<DoctorShow> doctorShows = new LinkedList<>();
        int last = page*limit < doctors.size() ? page*limit :doctors.size();
        for (int i=(page-1)*limit;i<last;i++){
            DoctorShow doctorShow = new DoctorShow();
            doctorShow.setName(doctors.get(i).getName());
            doctorShow.setProfession(doctors.get(i).getProfession());
            doctorShow.setFaculty(doctors.get(i).getFaculty());
            doctorShow.setDID(doctors.get(i).getDID());
            doctorShows.add(doctorShow);
        }
        return doctorShows;
    }
    public static String ChangeToString(List<DoctorShow> doctorShows){

        String s="" ;
        s+="[";
        for (int i=0;i<doctorShows.size();i++){
            s+="{\"id\":\"";
            s+=doctorShows.get(i).getDID();
            s+="\",\"name\":\"";
            s+=doctorShows.get(i).getName();
            s+="\",\"faculty\":\"";
            s+=doctorShows.get(i).getFaculty();
            s+="\",\"profession\":\"";
            s+=doctorShows.get(i).getProfession();
            if (i<doctorShows.size()-1)
                s+="\"},";
            else s+="\"}";
        }
        s+="]";
        return s;
    }
    public static String DoctorToString(int page,int limit,List<Doctor> list){
        //System.out.println("Doc1");
        List<DoctorShow> list1 = DChangeToS(page, limit,list);
        //System.out.println("Doc2");
        String js = ChangeToString(list1);
        //System.out.println("Doc3");
        System.out.println(js);
        int count = list.size();
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";
        return jso;
    }
}
