package test.java.cn.com.db;

import cn.com.entity.User;
import cn.com.mapping.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    @Test
    public void testSelect()throws Exception{
        sqlSession=getSqlSession();
        User user=sqlSession.selectOne("cn.com.mapping.UserMapper.findUserByName","张三");
        System.out.println("取出的用户信息：");
        System.out.println("ID:"+user.getId());
        System.out.println("password:"+user.getPassword());
        System.out.println("username"+user.getUsername());
    }
}
