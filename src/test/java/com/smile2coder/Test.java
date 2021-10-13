package com.smile2coder;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

import java.io.Reader;
import java.util.List;

public class Test {
    private static SqlSessionFactory sqlMapper;

    @BeforeClass
    public static void setup() throws Exception {
        final String resource = "resources/mybatis-config.xml";
        final Reader reader = Resources.getResourceAsReader(resource);
        sqlMapper = new SqlSessionFactoryBuilder().build(reader);
    }

    @org.junit.Test
    public void test() {
        SqlSession sqlSession = sqlMapper.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> list = mapper.list();
        list.forEach(e -> System.out.println(e));

        SqlSession sqlSession2 = sqlMapper.openSession();
        AccountMapper mapper2 = sqlSession2.getMapper(AccountMapper.class);
        int update = mapper2.updateById("xiaohu", 1L);
        System.out.println("update = " + update);

        list = mapper.list();
        list.forEach(e -> System.out.println(e));
        sqlSession.close();

        list = mapper2.list();
        list.forEach(e -> System.out.println(e));
        sqlSession.close();
    }

    @org.junit.Test
    public void test2() {
        SqlSession sqlSession = sqlMapper.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.getById(1L);
        System.out.println("account = " + account);

        sqlSession.close();

    }

}
