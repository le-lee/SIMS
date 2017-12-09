<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;  
%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录</title>
		<!-- 免费 CDN  -->
	
		<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>
		<!-- <link rel='stylesheet' href='resources/plugins/bootstrap-3.3.7/css/bootstrap.min.css'> -->
		
		<link rel="stylesheet" type="text/css" href="resources/css/login.css"/>
		
	</head>
	<body>
	<div id="header">
	</div>
	
	<div class="container">
      <form id="loginForm" class="form-signin" action="<%=basePath%>/LoginServlet">
        <h2 class="form-signin-heading">登录</h2>
        <label for="inputEmail" class="sr-only"></label>
        <input type="text" id="username" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only"></label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
        
        <span class="col-xs-6">
        	<input name="randomCode" class="form-control .col-xs-2" placeholder="请输入验证码"/>
        </span>
        <div class="random">
        	<img id="randImage" alt="验证码,点击刷新" 
								src="<%=basePath%>/VCodeServlet" title="点击刷新验证码">
								<a 	href="#" onclick="login.flushVcode();">看不清？</a>
        </div>
        <div class="checkbox">
          <label>
            <input type="radio" name="userType" value="student"> 学生
            <input type="radio" name="userType" value="teacher"> 老师
          </label>
        </div>
        <input class="btn btn-lg btn-primary btn-block" type="submit"></input>
      </form>

    </div> <!-- /container -->
    <script src="./resources/js/common.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/login/login.js"></script> 
    
	</body>
</html>
