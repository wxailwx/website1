package test.java.cn.com.db;

import cn.com.entity.Judge;
import cn.com.service.impl.JudgeServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class JudgeTest {
    @Autowired
    private JudgeServiceImp judgeServiceImp;
    @Test
    public void insertJudgeTest()throws Exception{
        Judge judge=new Judge();
        judge.setUserid(1);
        judge.setShoperid(2);
        judge.setStar(3);
        judge.setJudge("服务挺好的");
        judge.setUsername("张三");
        boolean isWork=judgeServiceImp.insertJudge(judge);
        if(isWork){
            System.out.println("添加评价成功！");
        }
        else
        {
            System.out.println("添加评价失败！");
        }
    }
    @Test
    public void selectJudgeTest()throws Exception{
        List<Judge> judges=judgeServiceImp.searchJudge(1);
        for(int i=0;i<judges.size();i++){
            System.out.println(judges.get(i).getJudge());
        }
    }
}
