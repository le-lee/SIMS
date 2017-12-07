<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>  
<html>
<head>
    <title>查看个人信息</title>
</head>
<body>
	
	 <h1>个人信息</h1>
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
    
</body>
</html>
