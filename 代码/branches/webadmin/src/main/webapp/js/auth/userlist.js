$(document).ready(function(){
	$('#pagination').hide();
	$('#submit').bind('click',function(){
		querySub();
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
});

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
