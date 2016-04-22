$(document).ready(function(){
	$('#submit').bind('click',function(){
		if(window.confirm("确定要修改吗？"))
		{
			$.post("usermodify",$(".form-horizontal").serialize()).done(function(data){
				if(data.result == 'success')
				{
					alert("修改成功");
					window.parent.closepanel('dialog0');
				}else{
					alert(data.msg);
				}
			});
		}
	});
});