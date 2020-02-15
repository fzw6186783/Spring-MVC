package com.pojo;

public class Dog {
private String dname;
private String dsex;
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getDsex() {
	return dsex;
}
public void setDsex(String dsex) {
	this.dsex = dsex;
}
@Override
public String toString() {
	return "Dog [dname=" + dname + ", dsex=" + dsex + "]";
}
public Dog(String dname, String dsex) {
	super();
	this.dname = dname;
	this.dsex = dsex;
}
public Dog() {
	super();
	// TODO Auto-generated constructor stub
}

}
