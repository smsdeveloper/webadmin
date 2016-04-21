$(document).ready(function(){
	$('#pagination').hide();
	$('#submit').bind('click',function(){
		$.pagination.done('auth/userlist.json',1,'userlist','tbody');
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
});