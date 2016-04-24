$(document).ready(function(){
	var chargestatus = function(url,status){
		if($('tbody input:checkbox:checked').length == 0)
		{
			return;
		}
		var userids = new Array();
		$('tbody input:checkbox:checked').each(function(){
			userids.push($(this).val());
		});
		var user = {userids:userids,status:status};
		$.post(url,user).done(function(data){
			if(data.result == 'success'){
				alert('操作成功！');
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
			chargestatus('auth/stopuser','停用');
		}
	});
	$('#openuser').bind('click',function(){
		if(window.confirm("确定要恢复这些用户吗？"))
		{
			chargestatus('auth/stopuser','正常');
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
			html = "<a href=\"javascript:void(0)\" onclick=\"onestatus('"+ status + "'," + userid + ")\"”>停用</a>";
		}else{
			html = "<a href=\"javascript:void(0)\" onclick=\"onestatus('"+ status + "'," + userid + ")\">启用</a>";
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
	if(window.confirm(msg)){
		
		$.post("auth/chargestatus",user).done(function(data){
			if(data.result == 'success'){
				alert('操作成功');
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
