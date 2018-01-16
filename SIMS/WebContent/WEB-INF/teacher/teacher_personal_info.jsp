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

    <title>个人信息</title>

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
            <li><a href="<%=basePath%>/TeacherServlet?method=student_manage">学生管理</a></li>
            <li><a href="<%=basePath%>/TeacherServlet?method=grade_manage">成绩管理</a></li>
            <li class="active"><a href="<%=basePath%>/TeacherServlet?method=toPersonalInfo">个人信息</a></li>
            <li><a href="<%=basePath%>/TeacherServlet?method=toResetPwd">修改密码</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/"><span class="glyphicon glyphicon-user"></span>&nbsp;欢迎X老师</a></li>
            
            <li><a href="login.html"><span class="glyphicon glyphicon-log-out"></span>&nbsp;退出</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>


    <div class="col-xs-6 col-md-offset-3" style="position: relative;top: 25%">
      <div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">个人信息</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="firstname" 
									   placeholder="X老师">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">学院</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="lastname" 
									   placeholder="信息学院">
							</div>
						</div>
					</form>
				</div>
			</div>
    </div> <!-- /container -->
  </body>
</html>

