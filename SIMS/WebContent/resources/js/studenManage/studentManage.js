var studentManage = function (){
	//TODO
	var updateStudent = function(){
		layer.open({
			type:1,
			title:'修改学生信息',
			area:['400px'],
			btn:['确定','关闭'],
			closeBtn:1,
			shadeClose:false,
			content:document.getElementById(""),
		});
	}
	
	return {
		updateStudent : updateStudent
	}
}();
