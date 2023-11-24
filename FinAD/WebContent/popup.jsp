<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.finad23.DTO.CreatorVolun"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<CreatorVolun> list = (ArrayList<CreatorVolun>) request.getAttribute("list");
	if(list != null) {
		for(CreatorVolun volun : list) {
			%>
			<%= volun.getTitle() %>
			<%
		}
	} else {
		out.println("안됨 ㅋㅋ");
	}
%>
</body>
</html>