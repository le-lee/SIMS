var login = function(){
	var flushVcode = function(){
//		$("#randImage").src
		var time = new Date();
		var imgPath = getBasePath() + "/VCodeServlet"
		var img = document.getElementById("randImage");
		img.src=imgPath+"?time=" + time;
		
	}
	//提交表单
	var submitForm = function(){
		
	}
	
	var init = function(){
		
	}
	return {
		init : init,
		flushVcode : flushVcode
	}
}();
login.init();