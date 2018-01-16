<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
	欢迎用户：  ${teacher.teacherName }！
	 <h1>客户关系管理系统</h1>
   
