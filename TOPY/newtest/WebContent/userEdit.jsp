<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="activityManagement.userModular.dao.UserDao,
activityManagement.userModular.entity.User, java.util.List,java.text.DateFormat,java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Information Page</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
	<script src="layui/layui.js"></script>

	<%
		String userId = request.getParameter("userId");
		UserDao userDao = new UserDao();
		User user = userDao.queryByUserId(Integer.parseInt(userId));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	%>



	<form class="layui-form"
		action="<%=request.getContextPath()%>/userEdit" method="post">
		<input type="hidden" id="userId" name="userId"
			value="<%=user.getId()%>" />
		<div class="layui-form-item">
			<label class="layui-form-label">User name</label>
			<div class="layui-input-inline">
				<input type="text" name="userName" id="userName" required
					lay-verify="required" placeholder="please input User name" autocomplete="off"
					class="layui-input" value="<%=user.getUserName()%>">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">Password</label>
			<div class="layui-input-inline">
				<input type="password" name="password" id="password" required
					lay-verify="required" placeholder="password" autocomplete="off"
					class="layui-input" value="<%=user.getPassword()%>">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">name</label>
			<div class="layui-input-inline">
				<input type="text" name="name" id="name" required
					lay-verify="required" placeholder="name" autocomplete="off"
					class="layui-input" value="<%=user.getNickname()%>">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">Sex</label>
			<div class="layui-input-block">
				<input type="radio" name="sex" id="sex" value="M" title="M"
					<%if (user.getSex() != null && user.getSex().equals("M")) {%>
					checked <%}%>> <input type="radio" name="sex"
					id="sex" value="F" title="F"
					<%if (user.getSex() != null && user.getSex().equals("F")) {%>
					checked <%}%>>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">phone number</label>
			<div class="layui-input-inline">
				<input type="number" name="phoneNum" id="phoneNum" required
					lay-verify="required" placeholder="phone number" autocomplete="off"
					class="layui-input" value="<%=user.getPhoneNum()%>">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo"
					type="submit">revise</button>
				<button type="reset" class="layui-btn layui-btn-primary"
					onclick="javascript:history.go(-1);">return</button>
			</div>
		</div>
	</form>

	<script>
//监听
layui.use('form', function() {
	var form = layui.form;

	
});
</script>


</body>

</html>


