package cn.com.dto;

import cn.com.entity.Doctor;
import cn.com.entity.DoctorShow;

import java.util.*;

public class DChangeToS {
    public static LinkedList<DoctorShow> DChangeToS (List<Doctor> doctors){
        LinkedList<DoctorShow> doctorShows = new LinkedList<>();
        for (int i=0;i<doctors.size();i++){
            DoctorShow doctorShow = new DoctorShow();
            doctorShow.setName(doctors.get(i).getName());
            doctorShow.setProfession(doctors.get(i).getProfession());
            doctorShows.add(doctorShow);
        }
        return doctorShows;
    }
    public static String ChangeToString(List<DoctorShow> doctorShows){
        String s="" ;
        s+="[";
        for (int i=0;i<doctorShows.size();i++){
            s+="{\"name\":\"";
            s+=doctorShows.get(i).getName();
            s+="\",\"profession\":\"";
            s+=doctorShows.get(i).getProfession();
            if (i<doctorShows.size()-1)
                s+="\"},";
            else s+="\"}";
        }
        s+="]";
        return s;
    }
}
