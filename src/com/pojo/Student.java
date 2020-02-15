package com.pojo;

public class Student {
private Integer id;
private String name;
private Integer classes;
private Integer sql;
private Integer jee;
private Integer android;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getClasses() {
	return classes;
}
public void setClasses(Integer classes) {
	this.classes = classes;
}
public Integer getSql() {
	return sql;
}
public void setSql(Integer sql) {
	this.sql = sql;
}
public Integer getJee() {
	return jee;
}
public void setJee(Integer jee) {
	this.jee = jee;
}
public Integer getAndroid() {
	return android;
}
public void setAndroid(Integer android) {
	this.android = android;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", classes=" + classes + ", sql=" + sql + ", jee=" + jee
			+ ", android=" + android + "]";
}
public Student(Integer id, String name, Integer classes, Integer sql, Integer jee, Integer android) {
	super();
	this.id = id;
	this.name = name;
	this.classes = classes;
	this.sql = sql;
	this.jee = jee;
	this.android = android;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}


}
