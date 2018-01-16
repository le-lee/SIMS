<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>学生管理</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath %>/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="<%=basePath%>/resources/css/navbar-static-top.css" rel="stylesheet">
    
  </head>

  <body>
    <!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">学生成绩管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=basePath%>/TeacherServlet?method=student_manage">学生管理</a></li>
            <li><a href="<%=basePath%>/TeacherServlet?method=grade_manage">成绩管理</a></li>
            <li><a href="teacher_info.html">个人信息</a></li>
            <li><a href="teacher_reset_pwd.html">修改密码</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/"><span class="glyphicon glyphicon-user"></span>&nbsp;欢迎X老师</a></li>
            <li><a href="logout.html"><span class="glyphicon glyphicon-log-out"></span>&nbsp;退出</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>


	<div>
    	<form  method="post" action="reader_querybook_do.html" class="form-inline"  id="searchform">
        <div class="col-lg-6">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="输入学生姓名或学号">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								搜索
							</button>
						</span>
						
						<div class="input-group-btn">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							选择年级 
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">大一</a></li>
							<li><a href="#">大二</a></li>
							<li><a href="#">大三</a></li>
							<li><a href="#">大四</a></li>
						</ul>
					</div><!-- /btn-group -->
					<input type="text" class="form-control">
					</div><!-- /input-group -->
				</div><!-- /.col-lg-6 -->
    	</form>
	</div>
	
    <div>
		<table class="table table-hover" >
		<caption>学生信息</caption>
	 	<thead>
            <tr>
		 		<th>姓名</th>
		 		<th>学号</th>	
		 		<th>班级</th>
		 		<th>年级</th>
		 		<th>电话号码</th>
		 		<th>操作</th>
	 		</tr>
        </thead>
	 	<tbody>
		 		<tr>
		 			<td>李晓旭</td>
		 			<td>2013310200315</td>
		 			<td>计科1303</td>
		 			<td>大一</td>
		 			<td>15207156686</td>
		 			<td>
		 				<a href="<%=basePath%>/TeacherServlet?method=updateStudent&studentId=${student.studentId}">编辑</a>
		 				<a href="<%=basePath%>/TeacherServlet?method=deleteStudent&studentId=${student.studentId}">删除</a>
		 			</td>
		 		</tr>
		 		<tr>
		 			<td>张德成</td>
		 			<td>2013310200316</td>
		 			<td>计科1303</td>
		 			<td>大一</td>
		 			<td>13866823383</td>
		 			<td>
		 				<a href="<%=basePath%>/TeacherServlet?method=updateStudent&studentId=${student.studentId}">编辑</a>
		 				<a href="<%=basePath%>/TeacherServlet?method=deleteStudent&studentId=${student.studentId}">删除</a>
		 			</td>
		 		</tr>
		 		<tr>
		 			<td>杨晓</td>
		 			<td>2013310200317</td>
		 			<td>计科1303</td>
		 			<td>大一</td>
		 			<td>18671563389</td>
		 			<td>
		 				<a href="<%=basePath%>/TeacherServlet?method=updateStudent&studentId=${student.studentId}">编辑</a>
		 				<a href="<%=basePath%>/TeacherServlet?method=deleteStudent&studentId=${student.studentId}">删除</a>
		 			</td>
		 		</tr>
		</tbody>
      <table border="1">
    </div> <!-- /container -->
    
    <div>
		<ul class="pagination ">
			<li><a href="#">&laquo;</a></li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>    	
    </div>

  </body>
</html>

