$(document).ready(function(){
	$('#submit').bind('click',function(){
		$.post("useradd",$(".form-horizontal").serialize()).done(function(data){
			if(data.result == 'success')
			{
				alert("添加成功");
				window.parent.closepanel('dialog1');
			}else{
				alert(data.msg);
			}
		});
	});
});