<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@	page
	import="activityManagement.userModular.entity.User,activityManagement.activityModular.dao.ActivityDao,activityManagement.activityModular.entity.Defen,
activityManagement.userModular.dao.UserDao,activityManagement.activityModular.entity.Activity, java.util.List,java.text.DateFormat,java.text.SimpleDateFormat,
activityManagement.activityModular.dao.DefenDao"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>TOPY for Parents & Pet owners</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="layui/css/layui.css">


</head>
<%
	User loginUser = (User) session.getAttribute("loginUser");
	ActivityDao activityDao = new ActivityDao();
	List<Activity> actList = activityDao.queryAllList();
	ActivityDao activityDao1 = new ActivityDao();
	List<Activity> actList1 = activityDao1.querySignUpList(loginUser.getId());
	
	
	DateFormat df = new SimpleDateFormat("yyyy / MM / dd ");
%>
<body>
	<script src="layui/layui.js"></script>
	<div class="layui-tab">
		<ul class="layui-tab-title">
			<li class="layui-this">Event HomePage</li>
			<li>Registered event</li>
			<li>Personal Information</li>
			<li>My wish List</li>
			<li>Rating List</li>
			<li class="layui-nav-item layui-layout-right"><a
				href="${pageContext.request.contextPath}/logout">${sessionScope.loginUser.userName}-The user logs out</a></li>
				
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">

				<table>
					
							<%
									for (int i = 0; i < actList.size(); i++) {
											Activity act = actList.get(i);
								%>
						
					<tr>
						<td><img src="" width="0">&nbsp;&nbsp;</td>
						<td><%=act.getActName()%><br /> Organizer：<%=act.getSponsor()%><br />
							Event participants ：<%=act.getCoOrganizer()%><br /> Registration Time ： <%=act.getSignUpStartDate() == null ? "" : df.format(act.getSignUpStartDate())%>&nbsp;—&nbsp;
							<%=act.getSignUpEndDate() == null ? "" : df.format(act.getSignUpEndDate())%><br />
							Event Time ： <%=act.getActStartDate() == null ? "" : df.format(act.getActStartDate())%>&nbsp;—&nbsp;
							<%=act.getActEndDate() == null ? "" : df.format(act.getActEndDate())%><br />
							<br /> <a
							href="${pageContext.request.contextPath}/activityDetail.jsp?id=<%=act.getId()%>"
							class="layui-btn layui-btn-sm layui-btn-radius">Event details</a><br />
						<br /></td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
					<%
									}
								%>
					
				</table>

			</div>
			<div class="layui-tab-item">

				<table class="layui-table">
					<colgroup>
						<col width="150">
						<col width="200">
						<col>
					</colgroup>
					<thead>
						<tr>
							<th>serial number</th>
							<th>Activity name</th>
							<th>The event start time</th>
							<th>The event end time</th>
							<th>Details</th>
							<th>Cancellation</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < actList1.size(); i++) {
							Activity act = actList1.get(i);
					%><tr>
							<td><%=i + 1%></td>
							<td><%=act.getActName()%></td>
							<td><%=act.getActStartDate() == null ? "" : df.format(act.getActStartDate())%>
							</td>
							<td><%=act.getActEndDate() == null ? "" : df.format(act.getActEndDate())%>
							</td>
							<td><a
								href="${pageContext.request.contextPath}/activityDetail.jsp?id=<%=act.getId()%>"
								class="layui-btn layui-btn-sm layui-btn-radius">Event details</a>
							<td><a
								href="${pageContext.request.contextPath}/cancelSign?userId=<%=loginUser.getId()%>&actId=<%=act.getId()%>"
								class="layui-btn layui-btn-sm layui-btn-radius">Cancel your registration</a></td>
							</td>
						</tr>
						<%
}
%>
					</tbody>
				</table>
				<%

UserDao userDao = new UserDao();
User user = userDao.queryByUserId(loginUser.getId());
								%>


			</div>
			<div class="layui-tab-item">

				<form class="layui-form"
					action="<%=request.getContextPath()%>/userEdit" method="post">
					<input type="hidden" id="userId" name="userId"
						value="<%=user.getId()%>" />
					<div class="layui-form-item">
						<label class="layui-form-label">User name</label>
						<div class="layui-input-inline">
							<input type="text" name="userName" id="userName" required
								lay-verify="required" placeholder="User name" autocomplete="off"
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
						<label class="layui-form-label">User type</label>
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
						</div>
					</div>
				</form>

			</div>
			
			<!-- aspiration -->
			<div class="layui-tab-item">

				<form class="layui-form"
					action="<%=request.getContextPath()%>/yuanwangadd" method="post">
					<input type="hidden" id="userId" name="userId"
						value="<%=user.getId()%>" />
					<div class="layui-form-item">
						<label class="layui-form-label">WishBox</label>
						<div class="layui-input-inline">
							<textarea rows="10" cols="60" name="content" ></textarea>
							
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">User type</label>
						<div class="layui-input-inline">
							<input type="text" name="leixing" id="leixing" required
								lay-verify="required"  
								class="layui-input" value="<%=user.getNickname()%>">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">User name</label>
						<div class="layui-input-inline">
							<input type="text" name="name" id="name" required
								lay-verify="required" 
								class="layui-input" value="<%=user.getUserName()%>">
						</div>
					</div>
					

					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo"
								type="submit">Submit</button>
						</div>
					</div>
				</form>

			</div>
			<div class="layui-tab-item">

				<table class="layui-table">
					<colgroup>
						<col width="150">
						<col width="200">
						<col>
					</colgroup>
					<thead>
						<tr>
							<th>Senior name</th>
							<th>Activity name</th>
							<th>Seniors score</th>
							<th>Activity rating</th>
							<th>Evaluator</th>
						</tr>
					</thead>
					<tbody>
						<%
						DefenDao dao1 = new DefenDao();
						List<Defen> deList = dao1.queryAllList();
						for (int i = 0; i < deList.size(); i++) {
							Defen act = deList.get(i);
					%><tr>
							<td><%=act.getUserid()%></td>
							<td><%=act.getActname()%></td>
							<td><%=act.getFenshu()%></td>
							<td><%=act.getType()%></td>
							<td><%=act.getDafenren()%></td>
						</tr>
						<%
}
%>
					</tbody>
				</table>

			</div>
			
			
		</div>
	</div>

	<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
layui.use('form', function() {
	var form = layui.form;

	
});
</script>
</body>

</html>

