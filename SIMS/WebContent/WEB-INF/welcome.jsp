<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
	欢迎用户：  ${username }！
	 <h1>客户关系管理系统</h1>
    <a href="<c:url value='/add.jsp'/>">查看成绩</a>
    <a href="<c:url value='/CustomerServlet?method=findAll'/>">修改信息</a>
</body>
</html>
