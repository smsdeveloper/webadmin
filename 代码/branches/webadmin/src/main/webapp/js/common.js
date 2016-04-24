;(function($) {

    var Plugin = $.pagination = function(){};
    var doquery = function(url,page,tpid,bodyid)
    {
		var params = {pageno:page};
	    $.post(url,params).done(function(data){
			if(data.result == 'success')
			{
				var pagecount = 1;
				if(data.total>10)
				{
					pagecount = data.total%10 == 0 ? data.total/10 : data.total/10 + 1;
				}
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
    
    Plugin.dateformat = function(date ,format){
    	date = new Date(date);
	    var map = {
	        "M": date.getMonth() + 1, //月份 
	        "d": date.getDate(), //日 
	        "h": date.getHours(), //小时 
	        "m": date.getMinutes(), //分 
	        "s": date.getSeconds(), //秒 
	        "q": Math.floor((date.getMonth() + 3) / 3), //季度 
	        "S": date.getMilliseconds() //毫秒 
	    };
	    format = format.replace(/([yMdhmsqS])+/g, function(all, t){
	        var v = map[t];
	        if(v !== undefined){
	            if(all.length > 1){
	                v = '0' + v;
	                v = v.substr(v.length-2);
	            }
	            return v;
	        }
	        else if(t === 'y'){
	            return (date.getFullYear() + '').substr(4 - all.length);
	        }
	        return all;
	    });
	    return format;
    };
    
    Plugin.done = function(url,page,tpid,bodyid)
	{
    	doquery(url,page,tpid,bodyid);
	};
}(jQuery));