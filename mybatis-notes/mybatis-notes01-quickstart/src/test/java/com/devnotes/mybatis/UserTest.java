package com.devnotes.mybatis;

import com.devnotes.mybatis.beans.UserInfo;
import com.devnotes.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class UserTest {

    /**
     * 测试新增
     */
    @Test
    public void testAdd() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.devnotes.mybatis.sys.mappers.userMapper.addUser";

        UserInfo user = new UserInfo();
        user.setUserName("user_" + new Random().nextInt(1000));
        user.setUserPwd(UUID.randomUUID().toString());
        user.setEmail("user@126.com");
        int rs = sqlSession.insert(statement, user);
        System.out.println(rs);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.devnotes.mybatis.sys.mappers.userMapper.updateUser";

        UserInfo user = new UserInfo();
        user.setUserId(1);
        user.setUserName("user_" + new Random().nextInt(1000));
        user.setUserPwd(UUID.randomUUID().toString());
        user.setEmail("user@126.com");
        user.setCreateTime(new Date());

        int rs = sqlSession.update(statement, user);
        System.out.println(rs);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetAllUser() {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.devnotes.mybatis.sys.mappers.userMapper.getAllUser";

        List<UserInfo> users = sqlSession.selectList(statement);

        if (null != users) {
            for (UserInfo user : users) {
                System.out.println(user.toString());
            }
        }
        sqlSession.close();
    }

    @Test
    public void testSelectOne(){
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.devnotes.mybatis.sys.mappers.userMapper.getUser";

        UserInfo user = sqlSession.selectOne(statement,1);
        System.out.println(user.toString());

        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSessionFactory factory=MybatisUtil.getFactory();
        SqlSession sqlSession=factory.openSession();
        String statement="com.devnotes.mybatis.sys.mappers.userMapper.delUser";
        int i=sqlSession.delete(statement,1);
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();
    }
}
