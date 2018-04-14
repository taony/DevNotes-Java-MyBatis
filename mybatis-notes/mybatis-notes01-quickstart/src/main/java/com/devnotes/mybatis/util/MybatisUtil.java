package com.devnotes.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

    public static SqlSessionFactory getFactory() {

        //Mybatis 配置文件路径
        String resource = "app-config.xml";

        //获取资源配置文件流
        InputStream is = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);

        //构件session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        return factory;

    }
}
