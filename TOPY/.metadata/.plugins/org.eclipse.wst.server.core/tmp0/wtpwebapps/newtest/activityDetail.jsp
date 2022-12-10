<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@
page
	import="activityManagement.userModular.entity.User,activityManagement.activityModular. dao.ActivityDao,
 
activityManagement.activityModular.entity.Activity, java.util.List,java.text.DateFormat,java.text.SimpleDateFormat,java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Event details</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<%
	User loginUser = (User) session.getAttribute("loginUser");
	String actId = request.getParameter("id");
	Activity act = null;
	ActivityDao activityDao = new ActivityDao();

	if (actId == null) {
		act = new Activity();
	} else {
		act = activityDao.queryById(Integer.parseInt(actId));
	}
	DateFormat df = new SimpleDateFormat("yyyy / MM / dd ");	
%>
<body style="height: 80%">
	<script src="layui/layui.js"></script>
	<table width="100%" height="100%">
		<tr align="center">
			<td valign="top">
				<form action="<%=request.getContextPath()%>/dafen" method="post">
				<table>

					<tr align="center">
						<td colspan="2">
							<h1>Event details</h1>
							<br />
						<br />
						</td>
					</tr>
					<tr>
					<!-- <%=act.getActPicture()%> -->
						<td></td>
						<td>Organizer：<%=act.getSponsor()%><br /> Participant：<%=act.getCoOrganizer()%><br />
							Registration time ： <%=act.getSignUpStartDate() == null ? "" : df.format(act.getSignUpStartDate())%>&nbsp;—&nbsp;
							<%=act.getSignUpEndDate() == null ? "" : df.format(act.getSignUpEndDate())%><br />
							Event time ： <%=act.getActStartDate() == null ? "" : df.format(act.getActStartDate())%>&nbsp;—&nbsp;

							<%=act.getActEndDate() == null ? "" : df.format(act.getActEndDate())%><br />
							<br />
							Signed Up number：<%=activityDao.getSingUpNum(act.getId())%>
							<br>
							Total Number：<%=act.getCount_tmp()%>
							 <br />  <br /> Event content： <%
							
								if (act.getActContent() != null) {
							%> <%=act.getActContent().replaceAll("\n", "<br/>")
									
							%> <%
 	}
 %> <br /> 
 

<%
if (loginUser.getNickname().equals(act.getCoOrganizer())){
System.out.print(loginUser.getNickname());
%>

 <br /> <%
 	          if (loginUser == null) {
                           %> <a
							href="<%=request.getContextPath()%>/login.jsp">Please first login</a> <%
 	}
 %> <%
 	          if (activityDao.isSignUp(loginUser.getId(), act.getId())) {
                              %> <label>Registered</label><br /> <br />
							<%
                              if(activityDao.isSignIn(loginUser.getId(), act.getId())){
                            	  %> <label>Checked in</label><br /> <br />
							<%    
                              }
                              else{
                              %> <a
							href="<%=request.getContextPath()%>/signIn?userId=<%=loginUser.getId()%>&actId=<%=act.getId()%>"
							class="layui-btn layui-btn-sm layui-btn-radius">check in</a> <br />
						<br /> <%
                              }
 	           } else {
 	        	   	      if (activityDao.getSingUpNum(act.getId()) < Integer.parseInt(act.getCount_tmp())){  	    	        	   	        	   
                           %> <a
							href="<%=request.getContextPath()%>/signUp?userId=<%=loginUser.getId()%>&actId=<%=act.getId()%>"
							class="layui-btn layui-btn-sm layui-btn-radius">sign up</a> <br />
						<br /> <%
 	        	   	      }}
							%> 
						<a href="http://localhost:8080/newtest/index.jsp"
							class="layui-btn layui-btn-sm layui-btn-radius">return </a>
							
							<br><br><br>
							=======================================<br>
							Please rate this event：
							<select class="layui-input-inline" name="type">
								<option value="very good">Very good</option>
								<option value="not bad">Not bad</option>
								<option value="just soso">Just so-so</option>
								<option value="not recommend">Not recommend</option>
							</select>
							<br>
							Please rate the organizer：
							<input class="layui-input-inline" type="text" name ="fenshu" value="100" style ="width:50px;"> points
							<input type="hidden" name ="userid" value="<%=act.getSponsor()%>">
							<input type="hidden" name ="activity_id" value="<%=act.getId()%>">
							<input type="hidden" name ="actname" value="<%=act.getActName()%>">
							<input type="hidden" name ="dafenren" value="${sessionScope.loginUser.userName}">
							<br>
							<input class="layui-btn layui-btn-sm layui-btn-radius" type="submit">
<%} else {%>	

<br><br>
	<a href="http://localhost:8080/newtest/index.jsp"
							class="layui-btn layui-btn-sm layui-btn-radius">return</a>
<%} %>						

						</td>
					</tr>

					<tr>

						<td></td>
					</tr>
				</table>
				</form>
			</td>
		</tr>

	</table>
</body>
</html>

