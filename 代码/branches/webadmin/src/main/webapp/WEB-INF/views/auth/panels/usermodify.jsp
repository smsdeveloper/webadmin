<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Widgets</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>
<body>
<div class="row">
	<div class="col-md-8">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal">
					<input type="hidden" name="userid" value="${result.userid}">
					<fieldset>
						<!-- Name input-->
						<div class="form-group">
							<label class="col-md-3 control-label" for="name">用户名</label>
							<div class="col-md-9">
							<input id="name" name="username" type="text" placeholder="Your name" value="${result.username}" class="form-control">
							</div>
						</div>
						<!-- Form actions -->
						<div class="form-group">
							<div class="col-md-12 widget-right">
								<button id="submit" type="button" class="btn btn-default btn-md pull-right">修改</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/auth/usermodify.js"></script>
</body>
</html>
