package com.test;



import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mapper.IStudent;
import com.mapper.IStudentImpl;
import com.pojo.Student;

import com.sun.org.apache.bcel.internal.generic.Select;

public class TeacherTest {
	 private SqlSession session=null;
	 
	 private IStudent daoITeacher;//声明的接口对象
	@Before
	public void init() throws IOException {
	    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
	    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	    session = factory.openSession();
	}
	@After
	public void destory() {
		if(session!=null) {
		session.close();}
	}
	@Test
	public void testss() throws Exception {
		
//		daoITeacher=session.getMapper(IStudent.class);List<Integer> ids=new ArrayList<Integer>();
//		ids.add(42);ids.add(43);
//		daoITeacher.delete(ids);
			IStudentImpl kkImpl=new IStudentImpl();
//			List<Integer> kkIntegers=new ArrayList<Integer>();
//			kkIntegers.add(42);kkIntegers.add(43);
//			kkImpl.delete(kkIntegers);
			Student ssStudent=new Student(null,"吐了",3,44,55,66);
			List<Student> list=kkImpl.select(null, null, null, null, null);
			
			for(Student t:list) {
			System.out.print(t);
			}
			
		session.commit();
		
		
		}
		
	}
	
	
	
	
	
	
	
	
	

