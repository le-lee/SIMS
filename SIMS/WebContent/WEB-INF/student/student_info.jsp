<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>  
<html>
<head>
    <title>修改个人信息</title>
</head>
<body>
	欢迎用户：  ${username }！
	 <h1>客户关系管理系统</h1>
	 <form id="infoForm" action="<%=basePath %>/StudentServlet?method=updatePersonalInfo" method="post">
	 	 <table>
	    	<tr>
	    		<td>姓名</td>
	    		<td><input id="username" name="username" type=“text" value="${username }"/></td>
	    	</tr>
	    	<tr>
	    		<td>电话号码</td>
	    		<td><input id="phoneNo" name="phoneNo" type=“text" value="${phoneNo }"/></td>
	    	</tr>
   	 	</table>
   	 	<input type="submit" ></input>
	 </form>
   
</body>
</html>
