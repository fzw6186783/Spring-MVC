<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.pojo.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript">
    function confirmdialog(){
       if(window.confirm("您确定要删除此条信息？")){
       return true;
       }
       else{
     //  alert("取消删除！");
       return false;
       }      
    }
    
    
    function validate()
    {
    var id=document.getElementById('select').id.value;
    var name=document.getElementById('select').name.value;
   if(isNaN(Number(id))||id<=0){
		alert("请输入正确学号！");
    	return false;
   }
   else if(name.length<=0){
    	alert("姓名不能为空，请输入姓名！");
    	return false;
    }
    else{
    	return true;
    }
    
    }
 </script>
  </head>
  
  <body>
 

    <br>
    <h1>学生信息</h1>  <br>  <hr>    
  
     <br>
  <h3>学生信息如下</h3>
   <table width="510" border="100" cellSpacing=1 style="border: 1pt dashed ; font-size: 15pt;" height="31">
    <tr>
    <td>学号</td>
    <td>姓名</td>
    <td>班级</td>
    <td>sql</td>
    <td>jee</td>
    <td>android</td>
    <td>总成绩</td>
    <td>操作</td>
    <td>操作</td>
    </tr>
    <%
     response.setCharacterEncoding("UTF-8");
     request.setCharacterEncoding("UTF-8");
     PageBean pb=(PageBean)request.getAttribute("pb");
     List<Student> subResult= (List<Student>)pb.getPd();
     int all=0;
       if(!subResult.isEmpty()){
       for(Student st:subResult){
    	 all=st.getAndroid()+st.getSql()+st.getJee();
            out.print("<tr>");
            out.print("<td>"+st.getId()+"</td>");
            out.print("<td>"+st.getName()+"</td>");
            out.print("<td>"+st.getClasses()+"</td>");
            out.print("<td>"+st.getSql()+"</td>");
            out.print("<td>"+st.getJee()+"</td>"); 
            out.print("<td>"+st.getAndroid()+"</td>"); 
            out.print("<td>"+all+"</td>"); 
            
     %>
     <td><a onclick="return confirmdialog()" href="delete?id=<%=st.getId() %>" >删除</a></td>
     
     <td><a href="jump?id=<%=st.getId() %>">修改</a></td>
    <% 
    out.print("</tr>");
         }
       }
       
     %>
     </table>
  
                              第${requestScope.pb.cp }页/共 ${pb.pc }页
                              <div>
		 <form action="select" method="post"style="float:left;" >
    <input type="hidden"  name="classes" value="${classes}"/>
     <input type="hidden" name="id" value="${id}"/>
      <input type="hidden" name="name" value="${name}"/>
     
       <input type="submit" value="首页"/></form>
	  <!--  因为首页也是第一页，所以我们没有加当前页码参数，servlet会自动认为是第一页 -->
		
		<c:if test="${pb.cp > 1 }">        <!-- 如果当前页面是第一页德华，那摩就禁用上一页 -->
				 <form action="select" method="post"style="float:left;" >
    <input type="hidden"  name="classes" value="${classes}"/>
     <input type="hidden" name="id" value="${id}"/>
      <input type="hidden" name="name" value="${name}"/>
       <input type="hidden" name="cp" value="${pb.cp - 1 }"/>
       <input type="submit" value="上一页"/></form>
		</c:if>
		<c:if test="${pb.cp < pb.pc }">  <!-- 如果当前页面时最后一页的话，我们就禁用下一页 -->
		
		 <form action="select" method="post"style="float:left;" >
    <input type="hidden"  name="classes" value="${classes}"/>
     <input type="hidden" name="id" value="${id}"/>
      <input type="hidden" name="name" value="${name}"/>
       <input type="hidden" name="cp" value="${pb.cp + 1 }"/>
       <input type="submit" value="下一页"/>
		</form>
		</c:if>
		 <form action="select" method="post" >
    <input type="hidden"  name="classes" value="${classes}"/>
     <input type="hidden" name="id" value="${id}"/>
      <input type="hidden" name="name" value="${name}"/>
       <input type="hidden" name="cp" value="${pb.pc }"/>
       <input type="submit" value="尾页"/></form>
	
       </div>



<h3>全部人数为:${pb.dt}</h3>

     <br>
    <form action="select" method="post" id="select" >
 
      <h3>按条件查询:</h3>
                              学号：<input type="text" name="id"  value="" title="学号必须为数字" ></input>
                              姓名：<input type="text" name="name" value="" title=""></input>
                               班级：<select name="classes">
                                 <option value="">全部班级</option>
           <option value="1">1</option>
           <option value="2">2</option>
             <option value="3">3</option>
            
          </select>
      <input type="submit" value="查询" />
    </form>
 <br>
<h3><a href=putin.jsp>返回信息输入页面</a></h3> 
<br>
  </body>
</html>

