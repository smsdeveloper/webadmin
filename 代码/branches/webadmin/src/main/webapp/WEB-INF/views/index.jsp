<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Dashboard</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link rel="stylesheet" href="css/ui-dialog.css">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
		  	<div class="navbar-header">
			    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			      <span class="sr-only">Toggle navigation</span>
			      <span class="icon-bar"></span>
			      <span class="icon-bar"></span>
			    </button>
		  	</div>
			<a class="navbar-brand" href="#"><span>Lumino</span>Admin</a>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
			    <ul class="nav navbar-nav">
			      <li class="active"><a href="#">Link</a></li>
			      <li><a href="#">Link</a></li>
			      <li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${user.username} <span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
					  <li><a href="#"><span class="glyphicon glyphicon-cog"></span> 设置</a></li>
					  <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
			        </ul>
			      </li>
			    </ul>
			</div>
		</div><!-- /.navbar-collapse -->
	</nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="/index"><span class="glyphicon glyphicon-dashboard"></span> 首页</a></li>
			<c:forEach items="${menuList}" var="list">
			<c:if test="${list.supmenucode eq '0'}">
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> ${list.menuname} <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<c:forEach items="${menuList}" var="childlist">
					<c:if test="${childlist.supmenucode eq list.menucode}">
					<li>
						<a class="" href="#" onclick="topage('${childlist.menuurl}')">
							<span class="glyphicon glyphicon-share-alt"></span> ${childlist.menuname}
						</a>
					</li>
					</c:if>
					</c:forEach>
				</ul>
			</li>
			</c:if>
			</c:forEach>
			<li role="presentation" class="divider"></li>
		</ul>
	</div><!--/.sidebar-->
		
	<div id="content" class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
	</div>	<!--/.main-->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/auth/index.js"></script>
	<script>
		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");    
		    }); 
		  	/* $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus"); */
		}(window.jQuery);
	
		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>
