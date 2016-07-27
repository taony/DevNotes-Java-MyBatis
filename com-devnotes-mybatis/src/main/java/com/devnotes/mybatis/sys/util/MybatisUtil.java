package com.devnotes.mybatis.sys.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.devnotes.mybatis.sys.bean.Test;

public class MybatisUtil {

	public static SqlSessionFactory getFactory() {
		
		String resource = "app-config.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		return factory;
	}
}
