<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String table = (String)request.getAttribute("table");
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team Profiles</title>
</head>
<body>
<a href="index.jsp"> Go Back</a>

<h1> Teams: </h1>
<%= table %>
<br />



</body>
</html>