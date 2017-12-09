<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<html>
<head>
    <title>老师主页</title>
</head>
<body>
	欢迎用户：  ${username }！
	 <h1>学生管理</h1>
	 学生姓名：<input type="text" id="studentName" name="studentName"/>
	 班级：<input type="text" id="class" name="class"/>
	 年级：<input type="text" id="grade" name="grade"/>
	 <button id="addStudentBtn" onclick="">增加学生</button>
	 <button id="importStudentListBtn" onclick="">导入学生</button>
	
	 <br>
	 <table>
	 	<thead>
            <tr>
		 		<td>姓名</td>		
		 		<td>班级</td>
		 		<td>年级</td>
		 		<td>电话号码</td>
	 		</tr>
        </thead>
	 	<tbody>
		 	<c:forEach items="${studentList }" var="student	">
		 		<tr>
		 			<td>${student.studentName }</td>
		 			<td>${student.classId }</td>
		 			<td>${student.grade }</td>
		 			<td>${student.phoneNo }</td>
		 			<td><a href="<%=basePath%>/TeacherServlet?method=updateStudent&studentId=${student.studentId}">修改信息</a></td>
		 			<td><a href="<%=basePath%>/TeacherServlet?method=deleteStudent&studentId=${student.studentId}">删除</a></td>
		 		</tr>
		 	</c:forEach>
		 </tbody>
	 </table>
</body>
</html>
