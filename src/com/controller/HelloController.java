package com.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.CharacterEncodingFilter;
//创建一个SpringMVC的服务类

import com.mapper.IStudentImpl;
import com.pojo.PageBean;
import com.pojo.Student;

@Controller      //定义一个集合
public class HelloController  {
	
	private IStudentImpl service;
//第一种 *简单类型的数据接收
	//服务都是方法
	
	@RequestMapping("insert")
	public String insert(String name,int classes,int sql,int jee,int android) throws Exception {
		 Student stu=new Student(null, name, classes, sql, jee, android);
		 System.out.print("name:"+name+"age:"+classes+sql+jee+android);
			service=new IStudentImpl();
			service.insert(stu);
			
		return "redirect:select";
	}
	//第二种 页面的参数和控制类的参数名不一样
	//@RequestParam(value = "name")表示接受的参数名
	@RequestMapping("select")
	public String select(HttpServletRequest request,Integer id,String name,Integer classes,String cp) throws Exception {
		PageBean<Student> pb=new PageBean<Student>();
		if(cp!= null && !cp.trim().isEmpty()) {
			 int cpp = Integer.parseInt(cp);
		 	 pb.setCp(cpp);
		 }	
		 else {
			 pb.setCp(1);
		 }
		pb.setMd(10);
		service=new IStudentImpl();
		int result=service.select(id, name, classes, null, null).size();
   	 pb.setPd(service.select(id, name, classes,(pb.getCp()-1)*pb.getMd(),pb.getMd()));
		 pb.setDt(result);
		 pb.setPc(pb.getDt()/pb.getMd()+1);
//		 String url2 =request.getQueryString().toString();
//		 String url=url2;
//		 if(url2.indexOf("&cp")!=-1) {
//			url=url2.substring(0, url2.indexOf("&cp"));
//		 }
//		pb.setUrl(url);
		 request.setAttribute("pb",pb);
		 request.setAttribute("id",id); request.setAttribute("name",name); request.setAttribute("classes",classes);
		return "layout.jsp";
	}
	
	//第三种 简单数据类类型如果出现空值的现象  1包装类冲 2设定缺省值
	//第四种  3  @RequestParam(value = "name" required=true)必定填写
	@RequestMapping("update")
	public String update(Integer id,String name,Integer classes,Integer sql,int jee,Integer android) throws Exception {
		service=new IStudentImpl();
		Student stu=new Student(id, name, classes, sql, jee, android);
		service.update(stu);
	return "redirect:select";
	}
	@RequestMapping("delete")
	public String delete(Integer id) throws Exception {
		service=new IStudentImpl();
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(id);
		service.delete(ids);
	return "redirect:select";
	}
	@RequestMapping("jump")
	public String jump(Integer id,HttpServletRequest request) throws Exception {
		service=new IStudentImpl();
		List<Student> result=new ArrayList<Student>();
		result=service.select(id, null, null, null, null);
		request.setAttribute("subResult", result);
	return "update.jsp";
	}
	
	//*第五种 对象类型的参数接受
	//简单的域模型方式
//	@RequestMapping("demo3")
//	public String Hello3(Student s) {
//		System.out.print(s);
//		return "main.jsp";
//	}
//	
//	//第六种 集合参数的接受
//	@RequestMapping("demo6")
//	public String Hello6(@RequestParam("Hover")List<String> hover) {
//		System.out.print(hover);
//		return "main.jsp";
//	}
//	//*第七种 对象中的对象类型
//	@RequestMapping("demo7")
//	public String Hello7(Student s) {
//		System.out.print(s);
//		return "main.jsp";
//	}
//	
//	//第八种 restful传值  路径传值法
//	@RequestMapping("demo8/(id)/(name)")
//	public String Hello8(String name,int id) {
//		System.out.print(name+id);
//		return "/main.jsp";
//	}
	
	
	
	
	
	
	
}
