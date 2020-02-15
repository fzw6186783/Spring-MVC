<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息输入</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"">
    function validate()
    {
    var name=document.forms[0].name.value;
    var sql=document.forms[0].sql.value;
    var jee=document.forms[0].jee.value;
    var android=document.forms[0].android.value;
    if(name.length<=0){
    	alert("姓名不能为空，请输入姓名！");
    	return false;
    }
    else if(isNaN(Number(sql))||sql<=0){
    	alert("请输入正确成绩！");
    	return false;
    }
    else if(isNaN(Number(jee))||jee<=0){
    	alert("请输入正确成绩！");
    	return false;
    }
    else if(isNaN(Number(android))||android<=0){
    	alert("请输入正确成绩！");
    	return false;
    }
    else{
    	return true;
    }
    	//document.getElementById("form").submit();
    }
    </script>
  </head>
  
  <body>
     <br>
  <center>
  <h2>学生信息输入</h2><hr>
   <form action="insert" method="post" id="form" onSubmit="return validate()" >
 <input type="hidden" name="methodName" value="0"/>
<h4>  姓名：<input type="text" name="name"title="姓名不能为空"></input><br></h4>
<h4>  班级：<input type="radio" name="classes" value="1" checked/>1班
          <input type="radio" name="classes" value="2"/>2班
            <input type="radio" name="classes" value="3"/>3班
            </h4>
<h4>  sql：<input type="text" name="sql"title="成绩不能为空"></input><br></h4>
<h4>  jee：<input type="text" name="jee"title="成绩不能为空"></input><br></h4>
<h4>  android：<input type="text" name="android"title="成绩不能为空"></input><br></h4>
 <input type="submit" value="提交"/>
  </form>
  <br>
  <a href="select">查看已输入信息</a>
  </center>
  </body>
</html>
