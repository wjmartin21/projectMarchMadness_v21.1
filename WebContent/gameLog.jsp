<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String gameLog = (String)request.getAttribute("gameLog");
	String message = (String)request.getAttribute("result");
%>
    
    
<!DOCTYPE html>
<html>
<script type="text/javascript">
function alertName(){
	alert(<%= message%>);
} 
</script> 
<head>
<meta charset="UTF-8">
<title>Game log</title>
</head>
<body>
<a href="index.jsp"> Go Back</a>

<h1> Games: </h1>
<%= gameLog %>
<br />

<script type="text/javascript">
function alertName(){
alert(<%= message%>);
} 
</script> 
<script type="text/javascript"> window.onload = alertName; </script>


</body>
</html>