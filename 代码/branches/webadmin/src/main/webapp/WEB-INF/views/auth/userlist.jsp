<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="row">
	<ol class="breadcrumb">
		<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
		<li class="active">用户管理</li>
	</ol>
</div><!--/.row-->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">用户管理</div>
			<div class="panel-body">
				<form class="form-inline">
				<div class="form-group col-md-offset-1">
					<label class="control-label" for="name">帐号</label>
					<input id="name" name="name" type="text" placeholder="查询帐号" class="form-control">
				</div>
				<div class="form-group col-md-offset-1">
					<label class="control-label" for="name">帐号</label>
					<input id="name" name="name" type="text" placeholder="查询帐号" class="form-control">
				</div>
				<div class="form-group col-md-offset-1">
					<label class="control-label" for="name">帐号</label>
					<input id="name" name="name" type="text" placeholder="查询帐号" class="form-control">
				</div>
				<div class="form-group col-md-offset-1">
					<label class="control-label" for="name">帐号</label>
					<input id="name" name="name" type="text" placeholder="查询帐号" class="form-control">
				</div>
				<div class="form-group col-md-offset-1">
					<label class="control-label" for="name">帐号</label>
					<input id="name" name="name" type="text" placeholder="查询帐号" class="form-control">
				</div>
				<div class="form-group col-md-offset-1">
					<label class="control-label" for="name">帐号</label>
					<input id="name" name="name" type="text" placeholder="查询帐号" class="form-control">
				</div>
				<div class="form-group col-md-offset-1">
					<label class="control-label" for="name">注册时间</label>
					<input readonly="readonly" class="datepicker form-control">
				</div>
				<div class="form-group">
					<input readonly="readonly" class="datepicker form-control">
				</div>
				<div class="form-group col-md-offset-1">
					<label class="control-label" for="name">注册时间</label>
					<input readonly="readonly" class="datepicker form-control">
				</div>
				<div class="form-group">
					<input readonly="readonly" class="datepicker form-control">
				</div>
				<button type="button" id="submit" class="btn btn-primary pull-right">查询</button>
				<button type="button" id="add" class="btn btn-default pull-right">新增用户</button>
				</form>
				<table class="table table-striped table-hover">
				    <thead>
				    <tr>
				        <th><input type="checkbox"/></th>
				        <th>注册时间</th>
				        <th>注册时间</th>
				        <th>状态</th>
				        <th>操作</th>
				    </tr>
				    </thead>
				    <tbody id="tbody">
					    <script id="userlist" type="text/html">
						{{each rows as item}}
				    	<tr>
				    		<td><input type="checkbox" value="{{item.userid}}"/></td>
				    		<td>{{item.username}}</td>
				    		<td>{{item.addtime}}</td>
				    		<td>{{item.status}}</td>
							<td><a href="javascript:void(0)" onclick="openpanel({{item.userid}})">修改</a></td>
				    	</tr>
						{{/each}}
						</script>
				    </tbody>
				</table>
				<nav  class="text-center">
					<ul id="pagination"></ul>
				</nav>
			</div>
		</div>
	</div>
</div><!--/.row-->	
<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-paginator.min.js"></script>
<script src="../js/template.js"></script>
<script src="../js/common.js"></script>
<script src="../js/bootstrap-datepicker.js"></script>
<script src="../js/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="../js/dialog-plus-min.js"></script>
<script src="../js/auth/userlist.js"></script>

