package test.java.cn.com.db;

import cn.com.entity.Merchandise;
import cn.com.service.impl.MerchandiseServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class MerchandiseTest {
    @Autowired
    private MerchandiseServiceImp merchandiseServiceImp;
    @Test
    public void TestSelect()throws Exception{
        List<Merchandise> list=merchandiseServiceImp.selectMerchandise(1);
        for(Merchandise merchandise:list){
            System.out.println(merchandise.getName()+":"+merchandise.getPrice()+":"+merchandise.getStar());
        }
    }
}
