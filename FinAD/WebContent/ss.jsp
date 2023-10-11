<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.CategoryFilterDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.finad23.jjj.Influ_info" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<CategoryFilterDTO> list = (List<CategoryFilterDTO>) request.getAttribute("List");
	List<Influ_info> list1 = (List<Influ_info>) request.getAttribute("List");

	out.println(list1.get(0).getId());
	
	
	
	
	out.println(list.get(0).getAvg());
	out.println(list.get(0).getOffer());
	out.println(list.get(0).getPrice());
	out.println(list.get(0).getShorts());
	out.println(list.get(0).getSub());
%>
안녕하십니까
</body>
</html>