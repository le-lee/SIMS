<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <meta name="description" content="resetPwd">
    <meta name="author" content="lile">

    <title>成绩信息</title>
    <link href="<%=basePath %>/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/resources/css/navbar-fixed-top.css" rel="stylesheet">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>

  <body>
		<!-- Static navbar -->
		<nav class="navbar navbar-default navbar-fixed-top">
		  <div class="container">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="<%=basePath%>/StudentServlet?method=toMain">学生成绩管理系统</a>
	    	</div>
	    	<div id="navbar" class="navbar-collapse collapse">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="<%=basePath%>/StudentServlet?method=toGradeInfo">我的成绩</a></li>
            	<li><a href="<%=basePath%>/StudentServlet?method=toPersonalInfo">个人信息</a></li>
            	<li><a href="<%=basePath%>/StudentServlet?method=reset_pwd">修改密码</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="../navbar/"><span class="glyphicon glyphicon-user"></span>&nbsp;欢迎张同学</a></li>
		        
		        <li><a href="login.html"><span class="glyphicon glyphicon-log-out"></span>&nbsp;退出</a></li>
		      </ul>
	    	</div><!--/.nav-collapse -->
			</div>
		</nav>
						
		<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 25%">
		  <div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">姓名：张楠    &nbsp;&nbsp;院系：信息学院</h3>
					</div>
					
					<div class="panel-footer">
						<form  role="form">
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control col-sm-2" placeholder="输入课程名或编号">
									<span class="input-group-btn">
										<button class="btn btn-default" type="button">搜索</button>
									</span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
										选择学年 
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#">大一</a></li>
										<li><a href="#">大二</a></li>
										<li><a href="#">大三</a></li>
										<li><a href="#">大四</a></li>
									</ul>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
										课程性质
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#">必修</a></li>
										<li><a href="#">选修</a></li>
									</ul>
								</div>
							</div>
						</form>
				</div>
						
				<div class="panel-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">java程序设计</label>
							<div class="col-sm-10">
								<input type="text" value="92" class="form-control" id="lastname" 
									   placeholder="92">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">数据结构与算法</label>
							<div class="col-sm-10">
								<input type="text" value="83" class="form-control" id="lastname" 
									   placeholder="83">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">离散数学</label>
							<div class="col-sm-10">
								<input type="text" value="79" class="form-control" id="lastname" 
									   placeholder="79">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div> <!-- /container -->
  </body>
</html>

