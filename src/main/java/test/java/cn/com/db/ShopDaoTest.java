package test.java.cn.com.db;

import cn.com.entity.Shoper;
import cn.com.service.impl.ShopServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class ShopDaoTest {
    @Autowired
    private ShopServiceImp shopServiceImp;
    @Test
    public void TestFindShopById()throws Exception{
        Shoper shoper=shopServiceImp.findShopById(1);
        if(shoper==null){
            System.out.println("error in shopDaoTest");
        }
        else {
            System.out.println(shoper.getShopname());
            //将二进制转成图片
            System.out.println(shoper.getPicture());
        }
    }
    @Test
    public void TestInsertShop()throws Exception{
        Shoper shoper=new Shoper();
        shoper.setShopname("小龙坎");
        shoper.setAddress("成都市锦江区大业路47号");
        shoper.setEstimate("特色火锅");
        shoper.setMessage("营业时间：周一至周日，11：00-03：00");

        //将图片文件转成二进制
        byte[] btImg=new byte[1];
        try{
            File imageFile = new File("D:\\Myprojects\\IdeaProjects\\MyFirstSSM\\src\\main\\webapp\\images\\xiaolongkang.jpg");
            InputStream inputStream=new FileInputStream(imageFile);
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            byte[] buffer = new byte[10240];
            int len=0;
            while ((len=inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,len);
            }
            inputStream.close();
            btImg=outputStream.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        shoper.setPicture(btImg);
        if(shopServiceImp.insertShop(shoper)){
            System.out.println("success!");
        }
        else System.out.println("fail");
    }
}
