$(document).ready(function(){
	$('#login').bind('click',function(){
		document.forms[0].submit();
	});
	$(document).keydown(function(e){
		if(e.keyCode==13) {
	    	document.forms[0].submit();
	    }
	});
});