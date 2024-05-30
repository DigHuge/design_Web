package com.lzh.mybatis.test;

import com.lzh.mybatis.mapper.VtuberMapper;
import com.lzh.mybatis.pojo.Vtuber;
import com.lzh.mybatis.service.VtuberService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybaitsTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VtuberService vtuberServiceimpl = (VtuberService) context.getBean("VtuberServiceimpl");
        List<Vtuber> date = vtuberServiceimpl.get_120();
        for( Vtuber v : date){
            System.out.println(v.getTop120());
        }

    }
    /*
    public  void test() throws IOException {
        //加载配置文件
        InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        VtuberMapper mapper = sqlSession.getMapper(VtuberMapper.class);
        //测试功能
        Integer i = mapper.test_mybaits();
        System.out.println("result: "+i);
    }

    @Test
    public  void test_update_delete() throws IOException{
        InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VtuberMapper mapper = sqlSession.getMapper(VtuberMapper.class);
        Integer i = mapper.test_update();
        //Integer i = mapper.test_delete();
        System.out.println("result: "+i);
    }

    @Test
    public  void test_select() throws IOException{
        InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        VtuberMapper mapper = sqlSession.getMapper(VtuberMapper.class);
        //Vtuber v = mapper.test_select();
        //System.out.println(v);
        List<Vtuber> v = mapper.test_select_list();
        v.forEach(vtuber -> System.out.println(vtuber));

    }
*/
}
