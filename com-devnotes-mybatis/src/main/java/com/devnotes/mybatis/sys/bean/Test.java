package com.devnotes.mybatis.sys.bean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.devnotes.mybatis.sys.util.MybatisUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String resource = "app-config.xml"; 
		//InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		
		//SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSessionFactory factory=MybatisUtil.getFactory();
		
		SqlSession session = factory.openSession();
		
		String statement = "com.devnotes.mybatis.sys.mappers.userMapper.getUser";
		
		UserInfo user = session.selectOne(statement, "1234");
		
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		
	}

}
