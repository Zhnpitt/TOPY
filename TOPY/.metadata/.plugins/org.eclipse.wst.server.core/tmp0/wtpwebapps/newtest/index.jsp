<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	page import="activityManagement.userModular.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>TOPY</title>
</head>
<%
	User loginUser = (User) session.getAttribute("loginUser");

%>



<tr>
	<%
							if (loginUser == null) {
						%>
	<%   response.setHeader("Refresh", "0;url=./login.jsp"); %>

	<%
							} else {
						%>
	<%
							if ("elderly".equals(loginUser.getUserName())) {
								response.setHeader("Refresh", "0;url=./adminPage.jsp");
						%>
	<%
							} else {
								response.setHeader("Refresh", "0;url=./userPage.jsp");	
							}
						%>

</tr>
</html>

<%
	}
%>



