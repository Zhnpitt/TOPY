<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="activityManagement.activityModular.dao.ActivityDao,
activityManagement.activityModular.entity.Activity, java.util.List,java.text.DateFormat,java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event updated</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body style="height: 80%">
	<script src="layui/layui.js"></script>
	<%
		String actId = request.getParameter("id");
		Activity act = null;
		if (actId == null) {
			act = new Activity();
		} else {
			ActivityDao activityDao = new ActivityDao();
			act = activityDao.queryById(Integer.parseInt(actId));
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<form class="layui-form" id="actForm"
		action="<%=request.getContextPath()%>/activityEdit" method="post"
		enctype="multipart/form-data">
		<input type="hidden" id="actId" name="actId"
			value="<%=act.getId() != null ? act.getId() : ""%>" />
		<div class="layui-form-item">
			<label class="layui-form-label"></label>
			<td>
				<%
								if (act.getActPicture() != null && !"".equals(act.getActPicture())) {
							%> <img alt="" src="<%=act.getActPicture()%>" width="100">
				<%
								}
							%>
			</td>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">Activity name</label>
			<div class="layui-input-inline">
				<input type="text"
					value="<%=act.getActName() != null ? act.getActName() : ""%>"
					name="actName" id="actName" required lay-verify="required"
					placeholder="The name of activity" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">Organizer</label>
			<div class="layui-input-inline">
				<input type="text"
					value="<%=act.getSponsor() != null ? act.getSponsor() : ""%>"
					name="sponsor" id="sponsor" required lay-verify="required"
					placeholder="Organizer" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">Event participant</label>
			<div class="layui-input-inline">
				<input type="text"
					value="<%=act.getCoOrganizer() != null ? act.getCoOrganizer() : ""%>"
					name="coOrganizer" id="coOrganizer" required lay-verify="required"
					placeholder="Event participants" autocomplete="off" class="layui-input">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">Registration start time</label>
			<div class="layui-input-inline">
				<input type="date"
					value="<%=act.getSignUpStartDate() != null ? df.format(act.getSignUpStartDate()) : ""%>"
					name="signUpStart" id="signUpStart" required lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">Registration close time</label>
			<div class="layui-input-inline">
				<input type="date"
					value="<%=act.getSignUpEndDate() != null ? df.format(act.getSignUpEndDate()) : ""%>"
					name="signUpEnd" id="signUpEnd" required lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">The event start time</label>
			<div class="layui-input-inline">
				<input type="date"
					value="<%=act.getActStartDate() != null ? df.format(act.getActStartDate()) : ""%>"
					name="actStart" id="actStart" required lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">The event end time</label>
			<div class="layui-input-inline">
				<input type="date"
					value="<%=act.getActEndDate() != null ? df.format(act.getActEndDate()) : ""%>"
					name="actEnd" id="actEnd" required lay-verify="required"
					autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">Event content</label>
			<div class="layui-input-block">
				<textarea placeholder="Content" class="layui-textarea" rows="5"
					form="actForm" name="actContent" id="actContent"><%=act.getActContent() != null ? act.getActContent() : ""%></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">Submit</button>
				<button type="reset" class="layui-btn layui-btn-primary"
					onclick="javascript:history.go(-1);">return</button>
			</div>
		</div>
	</form>

	<script>
					//Demo
					layui.use('form', function() {
						var form = layui.form;

						//监听提交
						form.on('submit(formDemo)', function(data) {
							return;
						});
					});
				</script>
</body>
</html>
