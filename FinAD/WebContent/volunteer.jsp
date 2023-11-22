<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.CBoardVolunteerDTO" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/company_board_text.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/company_board_vol.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script> -->
<title>volunteer.jsp</title>
</head>
<body>
<%
		String id = (String) session.getAttribute("id");
		String password = (String) session.getAttribute("password");
		String type = (String) session.getAttribute("type");
		
		if (id == null && password == null) {
	%>
	<jsp:include page="header_login.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="header_logout.jsp"></jsp:include>
	<%
		}
	%>
		<h1>이런분들이 지원해 주셨어요</h1>
		<table>
		<tr>
			<th>번호</th>
			<th>지원자</th>
			<th>지원한 게시글</th>
			<th>지원자 평균 시청자</th>
			<th>지원자 구독자수</th>
			<th>시간</th>
		</tr>
		<%
		double count = 0;
		List<CBoardVolunteerDTO> list = (List<CBoardVolunteerDTO>) request.getAttribute("List");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				int volunteerNumber = list.get(i).getVolunteerNumber();
				String volunteer = list.get(i).getVolunteer();
				int companyBoardNumber = list.get(i).getCompanyBoardNumber();
				int volunteerViewer = list.get(i).getVolunteerViewer();
				int volunteerSubscribe = list.get(i).getVolunteerSubscribe();
				String time = list.get(i).getTime();
				count++;
				out.println("<tr>");
				out.println("<td>"+ volunteerNumber +"</td>");
				out.println("<td>"+ volunteer +"</td>");
				out.println("<td>"+ companyBoardNumber +"</td>");
				out.println("<td>"+ volunteerViewer +"</td>");
				out.println("<td>"+ volunteerSubscribe +"</td>");
				out.println("<td>"+ time +"</td>");
				out.println("</tr>");
				}
		} else {
			out.print("데이터가 없습니다.");
		}
		double result = count/7;
		%>
		</table>
		<h3>경쟁률</h3>
		<%out.println( result + " : 1" ); %>
		<canvas class="line_canvas" width="400" height="400"></canvas>
		<canvas class="doughnut_graph" width="400" height="400"></canvas>
	
<%-- 	<jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>