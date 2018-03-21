package com.devnotes.mybatis.sys.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.devnotes.mybatis.sys.bean.Test;

public class MybatisUtil {

	public static SqlSessionFactory getFactory() {

		//mybatis的配置文件
		String resource = "app-config.xml";
		//使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		return factory;
	}
}
