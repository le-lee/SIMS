var login = function(){
	var flushVcode = function(){
		var time = new Date();
		var imgPath = getBasePath() + "/VCodeServlet"
		var img = document.getElementById("randImage");
		img.src=imgPath+"?time=" + time;
		
	}
	//提交表单
	var submitForm = function(){
		console.log(getBasePath() + "/LoginServlet");
		console.log("hello");
//		var loginForm = $("#loginForm");
		document.getElementById("loginForm").attr("action",getBasePath() + "/LoginServlet");
		document.getElementById("loginForm").submit();
	}
	
	var init = function(){
		
	}
	return {
		init : init,
		flushVcode : flushVcode,
		submitForm : submitForm
	}
}();
login.init();