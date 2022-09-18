package com.test;

import com.test.MybatisUtil;
import com.test.entity.Student;
import com.test.mapper.TestMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("mybatis-config.xml"));
//        try(SqlSession session=sqlSessionFactory.openSession(true)){
//            List<Student> list =session.selectList("selectStudent");
//            list.forEach(System.out::println);
//
//        }
        try (SqlSession session = MybatisUtil.getSession(true)) {
                TestMapper mapper=session.getMapper(TestMapper.class);
            System.out.println(mapper.addStudent(new Student().setName("BBB").setSid(114541)));
            mapper.deleteStudent(65454);
            XMLFormatter xmlFormatter=new XMLFormatter();
            SimpleFormatter simpleFormatter=new SimpleFormatter();
            Logger logger=Logger.getLogger(Main.class.getName());

            FileHandler fileHandler=new FileHandler("test.log",true);
            fileHandler.setFormatter(simpleFormatter);
            fileHandler.setLevel(Level.WARNING);
            logger.addHandler(fileHandler);


            logger.setLevel(Level.WARNING);
            logger.setUseParentHandlers(false);
            ConsoleHandler consoleHandler=new  ConsoleHandler();
            consoleHandler.setLevel(Level.WARNING);
            logger.addHandler(consoleHandler);

            logger.setFilter(record -> !record.getMessage().contains("!"));

            logger.log(Level.SEVERE,"server warning!!!!!");
            logger.log(Level.WARNING,"warning");
            logger.log(Level.INFO,"info!!");
            logger.log(Level.CONFIG,"config!!!");
            System.out.println(logger.getParent().getClass());

//            Map<String,String>map=new HashMap<>();
//            map.put("number",null);
//            System.out.println(map);      区别：map的valuie值可以为空  properties值不能为空

            Properties properties=new Properties();
            properties.load(new FileInputStream("test.properties"));
//            properties.put("number",null);
            properties.store(System.out,"Look here");
            System.getProperties().forEach((k,v)->System.out.println(k+":"+v));










        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}