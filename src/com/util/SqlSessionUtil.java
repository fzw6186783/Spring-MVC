package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlSessionUtil {
	static private SqlSessionFactory factory;
	static private SqlSession session;

public static SqlSession getSqlSession() throws IOException {

    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//2.ͨ���ļ���,����һ��sqlSessionFactory
    factory = new SqlSessionFactoryBuilder().build(is);
//3.ͨ����������һ�����ݿ������session
    session = factory.openSession();
    return session;
}}
