package com.vitgtk.teacherTime.config.spring;

import com.vitgtk.teacherTime.dao.*;
import com.vitgtk.teacherTime.domain.LessonTime;
import com.vitgtk.teacherTime.domain.TeachersLesson;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.vitgtk.teacherTime"})
public class SpringConfig {
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:8082/teachersTime");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    @Bean
    public MapperFactoryBean<UserDao> userMapper() throws Exception {
        MapperFactoryBean<UserDao> factoryBean = new MapperFactoryBean<>();
        factoryBean.setMapperInterface(UserDao.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<TeacherLessonDao> teacherLessonMapper() throws Exception {
        MapperFactoryBean<TeacherLessonDao> factoryBean = new MapperFactoryBean<>();
        factoryBean.setMapperInterface(TeacherLessonDao.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<GroupDao> groupMapper() throws Exception {
        MapperFactoryBean<GroupDao> factoryBean = new MapperFactoryBean<>();
        factoryBean.setMapperInterface(GroupDao.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<LessonDao> lessonMapper() throws Exception {
        MapperFactoryBean<LessonDao> factoryBean = new MapperFactoryBean<>();
        factoryBean.setMapperInterface(LessonDao.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<LessonTimeDao> lessonTimeMapper() throws Exception {
        MapperFactoryBean<LessonTimeDao> factoryBean = new MapperFactoryBean<>();
        factoryBean.setMapperInterface(LessonTimeDao.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<RoleDao> roleMapper() throws Exception {
        MapperFactoryBean<RoleDao> factoryBean = new MapperFactoryBean<>();
        factoryBean.setMapperInterface(RoleDao.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }
    @Bean
    public MapperFactoryBean<TeacherDao> teacherMapper() throws Exception {
        MapperFactoryBean<TeacherDao> factoryBean = new MapperFactoryBean<>();
        factoryBean.setMapperInterface(TeacherDao.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory());
        return factoryBean;
    }
}
