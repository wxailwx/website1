package cn.com.dto;

import cn.com.entity.Office;
import cn.com.entity.Tip;

import java.util.LinkedList;
import java.util.List;

public class SChangeToS {
    public static String OChangeToS (List<Office> list)throws Exception{
        String s ="";
        s+="[";
        for (int i=0;i<list.size();i++){
            s+="{\"id\":\"";
            s+=list.get(i).getId();
            s+="\",\"name\":\"";
            s+=list.get(i).getName();
            s+="\",\"class1\":\"";
            s+=list.get(i).getClass1();
            if (i<list.size()-1)
                s+="\"},";
            else s+="\"}";
        }
        s+="]";
        return s;
    }
    public static String TChangeToS (int page,int limit,List<Tip> list)throws Exception{
        String s = "";
        s+="[";
        int last = page*limit < list.size() ? page*limit : list.size();
        for(int i=(page-1)*limit;i<last;i++){
            s+="{\"id\":\"";
            s+=list.get(i).getId();
            s+="\",\"name\":\"";
            s+=list.get(i).getName();
            s+="\",\"tip\":\"";
            s+=list.get(i).getTip();
            if (i<last-1)
                s+="\"},";
            else s+="\"}";
        }
        s+="]";
        return s;
    }
}
