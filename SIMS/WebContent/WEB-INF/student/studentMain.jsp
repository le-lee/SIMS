<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>  
<html>
<head>
    <title>学生主页</title>
</head>
<body>
	欢迎用户：  ${username }！
	 <h1>客户关系管理系统</h1>
    <a href="<%=basePath%>/StudentServlet?method=checkPersonalInfo">查看个人信息</a>
    <a href="<%=basePath%>/StudentServlet?method=toUpadtePersonalInfo">修改个人信息</a>
</body>
</html>
