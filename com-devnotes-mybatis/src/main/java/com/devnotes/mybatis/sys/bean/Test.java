package com.devnotes.mybatis.sys.bean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.devnotes.mybatis.sys.util.MybatisUtil;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String resource = "app-config.xml";

		InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);*/
		
		SqlSessionFactory sqlSessionFactory=MybatisUtil.getFactory();
		
		SqlSession session = sqlSessionFactory.openSession();
		
		String statement = "com.devnotes.mybatis.sys.mappers.userMapper.getUser";
		
		UserInfo user = session.selectOne(statement, 1);
		if(null!=user){
			System.out.println(user.getUserId());
			System.out.println(user.getUserName());
		}


		statement = "com.devnotes.mybatis.sys.mappers.userMapper.addUser";
		user=new UserInfo();
		user.setUserName("taony2");
		session.insert(statement,user);
		session.commit();
	}

}
