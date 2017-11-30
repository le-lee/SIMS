<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
	${contextPath}
	<form action="${contextPath}/servet/LoginServlet" method="post">
		<br>
		用户名：<input type="text" name="username"></input>
		<br>
		密码：<input type="password" name="password"></input>
		<br>
		<input type="submit" value="提交"/>
		
		<br>
	</form>
</body>
</html>
