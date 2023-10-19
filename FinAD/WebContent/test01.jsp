<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.finad23.DTO.CateSearchDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<CateSearchDTO> list = (List<CateSearchDTO>) request.getAttribute("List");
if (list != null && !list.isEmpty()) {
	out.println(list.get(0).getNickname());
} else {
    out.println("없다 다시 돌아가라");
}
%>
</body>
</html>