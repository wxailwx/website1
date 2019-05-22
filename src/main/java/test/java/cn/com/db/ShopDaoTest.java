package test.java.cn.com.db;

import cn.com.entity.Merchandise;
import cn.com.entity.Shoper;
import cn.com.service.impl.MerchandiseServiceImp;
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
/*
* 测试商家数据库连接
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class ShopDaoTest {
    @Autowired
    private ShopServiceImp shopServiceImp;
    @Autowired
    private MerchandiseServiceImp merchandiseServiceImp;
    @Test
    public void TestInsertShop()throws Exception{
        Shoper shoper=new Shoper();
        shoper.setShopname("小龙坎");
        shoper.setAddress("成都市锦江区大业路47号");
        shoper.setEstimate("特色火锅");
        shoper.setMessage("营业时间：周一至周日，11：00-03：00");
        shoper.setStar(4);
        shoper.setType("美食");

        boolean isWork=shopServiceImp.insertShop(shoper);
        if(isWork){
            System.out.println("插入成功");
        }
        else {
            System.out.println("插入失败");
        }
        /*
        * 测试查找功能
        * */
        shoper=shopServiceImp.findShopByName(shoper.getShopname());//获得商家id，创建文件，添加图片
        /*
        * 图片文件上传数据库，模拟由前端传输的过程
        * */
        String path=null;//文件路径
        String type=null;//文件类型
        String fileName=null;//原文件名
        fileName="xiaolongkang";
        type="jpg";//这里是直接硬编码
        path="images/shop/"+shoper.getId()+"/"+fileName+"."+type;
        shoper.setPicture(path);
        /*
         *测试更新功能
         * */
        isWork=shopServiceImp.updateShop(shoper);
        if(isWork){
            System.out.println("更新成功！");
        }else {
            System.out.println("更新失败！");
        }
    }
    @Test
    public void TestInsertMerchandise()throws Exception{
        Merchandise merchandise=new Merchandise();
        merchandise.setName("鹅肠");
        merchandise.setPrice(10);
        merchandise.setShop_id(1);//id需要和所在的店铺的id一致,如果是不存在的店铺id,则数据库会报错，插入失败
        merchandise.setStar(3);
        //暂无图片
        boolean isWork=merchandiseServiceImp.insertMerchandise(merchandise);
        if(isWork){
            System.out.println("插入成功!");
        }
        else{
            System.out.println("插入失败!");
        }
    }
}
