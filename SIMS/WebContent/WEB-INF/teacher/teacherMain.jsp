<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<html>
<head>
    <title>老师主页</title>
</head>
<body>
	<%-- <jsp:include page="<%=basePath%>/common/header.jsp"></jsp:include> --%>
   	欢迎老师：  ${sessionScope.teacher.teacherName}！
	 <h1>客户关系管理系统</h1>
	 
    <a href= "<%=basePath%>/TeacherServlet?method=checkPersonalInfo">查看个人信息</a>
    <a href="<%=basePath%>/TeacherServlet?method=checkStudentInfo">学生信息管理</a>
    <a href="<%=basePath%>/LogoutServlet">退出登录</a>
</body>
</html>
