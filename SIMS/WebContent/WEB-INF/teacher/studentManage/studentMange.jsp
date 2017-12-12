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
	 <table border="1">
	 	<thead>
            <tr>
		 		<td>姓名</td>		
		 		<td>班级</td>
		 		<td>年级</td>
		 		<td>电话号码</td>
	 		</tr>
        </thead>
	 	<tbody>
		 	<c:forEach items="${studentList }" var="student">
		 		<tr>
		 			<td>${student.studentName}</td>
		 			<td>${student.classId}</td>
		 			<td>${student.grade}</td>
		 			<td>${student.phoneNo}</td>
		 			<td><a href="<%=basePath%>/TeacherServlet?method=updateStudent&studentId=${student.studentId}">修改信息</a></td>
		 			<td><a href="<%=basePath%>/TeacherServlet?method=deleteStudent&studentId=${student.studentId}">删除</a></td>
		 		</tr>
		 	</c:forEach>
		 </tbody>
	 </table>
	
	<div class="layerWindow" id="updateStudentWindow">
		<div class="layerContent">
		<form style="margin:0;padding:0" id="studentForm">
			<table class="tableBasic" width="100%" border="0" cellspacing="0">
				<tr>
					<td class="label">姓名<label style="color:red !important;">*</label></td>
					<td class="data fullw">
						<input value=""  name="studentName" class="m-input validate[required]"/>
					</td>
				</tr>
				<tr>
					<td class="label">班级<label style="color:red !important;">*</label></td>
					<td class="data fullw">
						<input value=""  required name="classId" class="m-input validate[required]"/>
					</td>
				</tr>
				
				<tr>
					<td class="label">年级<label style="color:red !important;">*</label></td>
					<td class="data fullw">
						<input value="" required name="grade" class="m-input validate[required]"/>
					</td>
				</tr>
				<tr>
					<td class="label">电话号码<label style="color:red !important;">*</label></td>
					<td class="data fullw">
						<input value="" required name="phoneNo" class="m-input validate[required]"/>
					</td>
				</tr>
			</table>			
		</form>
		</div>
	</div> 
	
		 
	 <script src="<%=basePath%>/resources/plugins/layui/layui.js"></script>
	 <!-- TODO -->
	 <script src=""></script>
<script>
//一般直接写在一个js文件中
layui.use(['layer', 'form'], function(){
  var layer = layui.layer
  ,form = layui.form;
  
  layer.msg('Hello World');
});


</script> 
	 
</body>
</html>
