package test.java.cn.com.db;

import cn.com.entity.Judge;
import cn.com.service.impl.JudgeServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class JudgeTest {
    @Autowired
    private JudgeServiceImp judgeServiceImp;
    @Test
    public void insertJudgeTest()throws Exception{
        Judge judge=new Judge();
        judge.setShoperId(1);
        judge.setUserId(2);
        judge.setStar(3);
        judge.setJudge("服务挺好的");
        boolean isWork=judgeServiceImp.insertJudge(judge);
        if(isWork){
            System.out.println("添加评价成功！");
        }
        else
        {
            System.out.println("添加评价失败！");
        }
    }
}
