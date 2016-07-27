package Test1;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.taony.mybatis.entity.SysUserInfo;
import com.taony.mybatis.util.MyBatisUtil;

public class TestUser {

	@Test
	public void testAdd() {
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
