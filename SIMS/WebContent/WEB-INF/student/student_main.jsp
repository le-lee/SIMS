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
    
    <title>学生成绩管理系统</title>
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
            <li><a href="<%=basePath%>/StudentServlet?method=toGradeInfo">我的成绩</a></li>
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

    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h2>欢迎登录</h2>
        <p>该系统基于Servlet技术</p>
      </div>
    </div> <!-- /container -->
  </body>
</html>

