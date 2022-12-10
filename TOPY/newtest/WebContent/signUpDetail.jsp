<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="activityManagement.activityModular.dao.ActivityDao,
java.util.List,java.util.Map"%>
<!DOCTYPE html>
<html style="height: 80%">
<head>
<meta charset="UTF-8">
<title>Registered events</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body style="height: 80%">
	<script src="layui/layui.js"></script>
	<table width="100%" height="100%">
		<tr align="center" height="10px">
			<td><font size="4"><b>registration</b></font>&nbsp;&nbsp;&nbsp;&nbsp; <a
				onclick="javascript:history.go(-1);"
				class="layui-btn layui-btn-sm layui-btn-radius layui-btn-xs">return</a>
			</td>
		</tr>
		<tr align="center">

			<td valign="top">
				<table class="layui-table">
					<colgroup>
						<col width="150">
						<col width="200">
						<col>
					</colgroup>
					<thead>
						<tr>
							<th>serial number</th>
							<th>name</th>
							<th>Mobile phone number</th>
							<th>registration time</th>
							<th>status</th>
						</tr>
					</thead>
					<tbody>
						<%
							String actId = request.getParameter("id");
							ActivityDao activityDao = new ActivityDao();
							List<Map<String, String>> userList = activityDao.getSingUpListByActId(Integer.parseInt(actId));
							for (int i = 0; i < userList.size(); i++) {
								Map<String, String> map = userList.get(i);
						%>
						<tr>
							<td><%=i + 1%></td>
							<td><%=map.get("nickname")%></td>
							<td><%=map.get("phone_num")%></td>
							<td><%=map.get("sign_up_time")%></td>
							<td>
							<%	if(activityDao.isSignIn(Integer.parseInt(map.get("id")), Integer.parseInt(actId))){
							  %>
							  signed in
							  <%
							}
							 
							    else {
							    							    
							  %>
							  not sign in yet
							    <%
							}
							  %>
							
							
							
							</td>
				
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
