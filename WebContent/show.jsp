<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3">
<title>Insert title here</title>
</head>
<body>
 <% List<String> info = (List)request.getSession().getAttribute("s"); %>
 <% for(String ss:info) { 
 	out.write(ss);
 %>
 	
 	<br>
	 
	 <% 
 }
 %>
</body>
</html>