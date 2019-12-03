package test.java.cn.com.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
* 测试数据库连接
* */
public class DBConnectionTest {
    private String resource="spring/applicationContext.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    public SqlSession getSqlSession()throws Exception{
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(resource);
        sqlSessionFactory=(SqlSessionFactory)context.getBean("sessionFactory");
        sqlSession=sqlSessionFactory.openSession();
        if(sqlSession==null){
            System.out.println("数据库连接成功");
        }
        return sqlSession;
    }
    @Test
    public void testConnection()throws Exception{
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(resource);
        sqlSessionFactory=(SqlSessionFactory)context.getBean("sessionFactory");
        sqlSession=sqlSessionFactory.openSession();
        if(sqlSession!=null){
            System.out.println("数据库连接成功");
        }
        else{
            System.out.println("数据库连接失败");
        }
    }
}
