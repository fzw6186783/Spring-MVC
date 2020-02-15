package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Student;

public interface IStudent {
	
	public List<Student> select(@Param("id") Integer id, @Param("name") String name, @Param("classes") Integer classes,
			@Param("cd") Integer cd, @Param("md") Integer md) throws Exception;

	public int update(Student stu) throws Exception;

	public int delete(List<Integer> ids) throws Exception;

	public int insert(Student stu) throws Exception;
}
