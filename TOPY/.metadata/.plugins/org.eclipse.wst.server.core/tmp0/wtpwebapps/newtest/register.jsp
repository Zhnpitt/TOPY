<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>New User Register</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="layui/css/layui.css">

<!--布局框架-->
<link rel="stylesheet" type="text/css" href="layui/css/util.css">

<!--主要样式-->
<link rel="stylesheet" type="text/css" href="layui/css/main.css">
</head>
<body>
	<script src="layui/layui.js"></script>

	<div class="login">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="layui/img/img-01.png" alt="IMG">
				</div>

				<form class="layui-form"
					action="<%=request.getContextPath()%>/register" method="post">
					<span class="login100-form-title"> User registration </span>
					<div class="layui-form-item">
						<label class="layui-form-label">User name</label>
						<div class="layui-input-block">
							<input type="text" name="userName" id="userName" required
								lay-verify="required" placeholder="input User name" autocomplete="off"
								class="layui-input">
						</div>
					</div>


					<div class="layui-form-item">
						<label class="layui-form-label">Password</label>
						<div class="layui-input-block">
							<input type="password" name="password" id="password" required
								lay-verify="required" placeholder="input password" autocomplete="off"
								class="layui-input">
						</div>
						<div class="layui-form-mid layui-word-aux"></div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">User type</label>
						<div class="layui-input-block">
							<select name="name" id="name" >
								<option value="elderly">elderly</option>
								<option value="parent">parent</option>
								<option value="pets">pets</option>
							</select>

						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">Sex</label>
						<div class="layui-input-block">
							<input type="radio" name="sex" id="sex" value="M" title="M"
								checked> <input type="radio" name="sex" id="sex"
								value="F" title="F">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">phone number</label>
						<div class="layui-input-block">
							<input type="number" name="phoneNum" id="phoneNum" required
								lay-verify="required" placeholder="phone number" autocomplete="off"
								class="layui-input">
						</div>
						<div class="layui-form-mid layui-word-aux"></div>
					</div>

					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo"
								type="submit">enroll</button>
							<button type="reset" class="layui-btn layui-btn-primary">reset</button>
							<button type="reset" class="layui-btn layui-btn-primary"
								onclick="javascript:history.go(-1);">return</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		//Demo
		layui.use('form', function() {
			var form = layui.form;

		});
	</script>

</body>
</html>

