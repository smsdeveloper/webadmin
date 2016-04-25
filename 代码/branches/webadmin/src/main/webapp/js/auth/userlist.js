$(document).ready(function(){
	var chargestatus = function(url,status){
		if($('tbody input:checkbox:checked').length == 0)
		{
			return;
		}
		var users = new Array();
		$('tbody input:checkbox:checked').each(function(){
			var user = {useid:$(this).val(),status:status};
			users.push(user);
		});
		/*服务端接收对象数组，必须加上contentType=application/json，然后对数组对象进行序列化JSON.stringify*/
		$.ajax({
			type: 'post',
			url:url,
			contentType:'application/json',
			data:JSON.stringify(users),
			success:function(data){
				if(data.result == 'success'){
					alert('操作成功！');
				}
			}
		});
	};
	$('#pagination').hide();
	$('#submit').bind('click',function(){
		querySub();
	});
	$('#stopuser').bind('click',function(){
		if(window.confirm("确定要停用这些用户吗？"))
		{
			chargestatus('auth/chargestatus','停用');
		}
	});
	$('#openuser').bind('click',function(){
		if(window.confirm("确定要恢复这些用户吗？"))
		{
			chargestatus('auth/chargestatus','正常');
		}
	});
	$('.datepicker').each(function() {
	    $(this).datepicker({
	    	format:'yyyy-mm-dd',
	    	autoclose: true,
	    	language:'zh-CN',
	    	todayBtn:true,
	    	todayHighlight:true
	    });
	});
	/**
	 * 打开新增用户面板
	 */
	$('#add').bind('click',function(){
		var d = dialog({
			id:'dialog1',
			url:'auth/inuseradd',
			title:'新增用户',
			onclose: function(){
				querySub();
			}
		});
		d.showModal();
	});
	/**
	 * 全选或者全不选
	 */
	$('#all').bind('click',function(){
		if($(this).is(':checked'))
		{
			//select all
			$('tbody input:checkbox').prop('checked',true);
		}else{
			$('tbody input:checkbox').prop('checked',false);
		}
	});
	template.config('escape',false); //输出html代码，不转义
	/**
	 * 格式化时间
	 */
	template.helper('dateformat', function (date ,format) {
		format = $.pagination.dateformat(date,format);
		return format;
	});
	/**
	 * 输出模板状态
	 */
	template.helper('chargestatus', function (userid ,status) {
		var html = "";
		if(status == "正常"){
			html = '<a href=\"javascript:void(0)\" onclick=\"onestatus(\''+ status + '\',' + userid + ')\">停用</a>';
		}else{
			html = '<a href=\"javascript:void(0)\" onclick=\"onestatus(\''+ status + '\',' + userid + ')\">启用</a>';
		}
		return html;
	});
});
function onestatus(status,userid)
{
	var user = {userid:userid};
	var msg = '';
	if(status == '正常'){
		msg = '确定要停用此用户吗？';
		user.status = '停用';
	}else{
		msg = '确定要启用此用户吗？';
		user.status = '正常';
	}
	var users = new Array();
	users.push(user);
	if(window.confirm(msg)){
		console.log(users);
		$.ajax({
			type: 'post',
			url:'auth/chargestatus',
			contentType:'application/json',
			data:JSON.stringify(users),
			success:function(data){
				if(data.result == 'success'){
					alert('操作成功！');
				}
			}
		});
	}
}
function querySub()
{
	$.pagination.done('auth/userlist.json',1,'userlist','tbody');
}
function openpanel(id)
{
	var d = dialog({
		id:'dialog0',
		url:'auth/inusermodify?userid=' + id,
		title:'用户修改',
		onclose: function(){
			querySub();
		}
	});
	d.showModal();
}
function closepanel(id)
{
	dialog.get(id).close().remove();
}
