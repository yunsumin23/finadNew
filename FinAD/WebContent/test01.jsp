<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.finad23.jjj.Influ_info" %>
<%
	Influ_info article = (Influ_info)request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(article != null) {
		out.println(article.getNickname());
	} else {
		out.println("안된다 이녀석아");
	}
%>
</body>
</html>