<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
	欢迎用户：  ${username }！
	 <h1>客户关系管理系统</h1>
    <a href=“”>查看学生信息</a>
    <a href= "<c:url value='/add.jsp'/>">新增学生</a>
    <a href="<c:url value='/CustomerServlet?method=findAll'/>">查看学生信息</a>
    <a href="/DeleteStudentServlet">删除学生</a>
</body>
</html>
