package com.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pojo.Student;
import com.util.SqlSessionUtil;

public class IStudentImpl implements IStudent {
    private SqlSession session=null;
	 
	 private IStudent daoITeacher;
	
	@Override
	public List<Student> select(Integer id, String name, Integer classes, Integer cd, Integer md) throws Exception {
		
		session=SqlSessionUtil.getSqlSession();
		IStudent daoITeacher=session.getMapper(IStudent.class);
		List<Student> result=daoITeacher.select(id, name, classes, cd, md);
		session.close();
		return result;
	}

	@Override
	public int update(Student stu) throws Exception {
		session=SqlSessionUtil.getSqlSession();
		IStudent daoITeacher=session.getMapper(IStudent.class);
		int result=daoITeacher.update(stu);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int delete(List<Integer> ids) throws Exception {
		session=SqlSessionUtil.getSqlSession();
		IStudent daoITeacher=session.getMapper(IStudent.class);
		int result=daoITeacher.delete(ids);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int insert(Student stu) throws Exception {
		session=SqlSessionUtil.getSqlSession();
		IStudent daoITeacher=session.getMapper(IStudent.class);
		int result=daoITeacher.insert(stu);
		session.commit();
		session.close();
		return result;
	}

}
