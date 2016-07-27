package com.taony.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.taony.mybatis.entity.SysUserInfo;

public class TestUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = MyBatisUtil.getFactory();
		SqlSession session = factory.openSession();

		String statement = "com.taony.mybatis.mapping.sysUserMapper.addUser";
		SysUserInfo user = new SysUserInfo();
		user.setUsername("22");

		int insert = session.insert(statement, user);
		// 提交
		session.commit();

		session.close();

		System.out.println(insert);
	}

}
