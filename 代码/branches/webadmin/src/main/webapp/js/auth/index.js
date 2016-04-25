function topage(url)
{
	$('#content').load( url , false);
}
$(document).ready(function(){
	topage("auth/usermanage");
});