<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
System.out.println("basePath:"+basePath);
%>  
<html>
<head>
	<base href="<%=basePath%>">  
    <title>首页</title>
    <meta http-equiv="description" content="This is my page"> 
</head>
<body>
	<h2>欢迎来到首页！请登录！</h2>
	<h2>111  <%=basePath%></h2>
 	<br>
	<form action="<%=basePath%>/LoginServlet" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></input></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></input></td>
			</tr>
			<tr>
				<td>登录类型：</td>
				<td>
				<input type="radio" name="userType" value="teacher" >老师
				<input type="radio" name="userType" value="student">学生
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"/></td>
				<td><input type="reset" value="重置"/></td>
			</tr>
			<tr><td>${message }<td></tr>
		</table>
	</form>
</body>
</html>
