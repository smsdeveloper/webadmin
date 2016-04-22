;(function($) {

    var Plugin = $.pagination = function(){};
    var doquery = function(url,page,tpid,bodyid)
    {
		var params = {pageno:page};
	    $.post(url,params).done(function(data){
			if(data.result == 'success')
			{
				console.log(data);
				var pagecount = 1;
				if(data.total>10)
				{
					pagecount = data.total%10 == 0 ? data.total/10 : data.total/10 + 1;
				}
				console.log(pagecount);
				var options = {
				    currentPage: page,
				    bootstrapMajorVersion: 3,
				    numberOfPages:5,
				    totalPages: pagecount,
				    itemContainerClass: function (type, page, current) {
				        return (page === current) ? "active" : "pointer-cursor";
				    },
				    onPageClicked: function(e,originalEvent,type,page){
				    	doquery(url,page,tpid,bodyid);
				    }
				};
				$('#pagination').bootstrapPaginator(options);
				$('#pagination').show();
		 		var html = template(tpid,data);
		 		$('#'+bodyid).html(html);
			}else{
				alert(data.msg);
			}
		});
    };
    
    
    Plugin.done = function(url,page,tpid,bodyid)
	{
    	doquery(url,page,tpid,bodyid);
	};
}(jQuery));