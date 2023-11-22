<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.CBoardVolunteerDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/volunteer.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/volunteer.js"></script>
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
		String clickText = request.getParameter("number");

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
	
	
	<div id="volunteer_container">
		<h1>이런분들이 지원해 주셨어요</h1>
		<table id = "volunteer_list" border="1">
			<tr>
				<th>/</th>
				<th>지원한 게시글</th>
				<th>지원자</th>
				<th>평균 시청자</th>
				<th>구독자수</th>
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
						int volunteerSex = list.get(i).getVolunteerSex();
						String time = list.get(i).getTime();
						out.println("<tr>");
						out.println("<td><input type='checkbox' value=''></td>");
						out.println("<td>" + companyBoardNumber + "</td>");
						out.println("<td>" + volunteer + "</td>");
						out.println("<td>" + volunteerViewer + "</td>");
						out.println("<td>" + volunteerSubscribe + "</td>");
						out.println("<td>" + time + "</td>");
						out.println("</tr>");
						count++;
			%>
			<input type="hidden" id="viewer<%=i%>" value="<%=volunteerViewer%>">
			<input type="hidden" id="subscribe<%=i%>" value="<%=volunteerSubscribe%>">
			<input type="hidden" id="sex<%=i%>" value="<%=volunteerSex%>">
			<%
				}
				} else {
					out.print("데이터가 부족합니다.");
				}
			%><input type="hidden" id="count" value="<%=count%>">
			<%
				double result = count / 7;
				double roundedNumber = Math.round(result * 100) / 100.0; //소수점 2번째까지만 표기
			%>
		</table>
		<table id="info_box">
			<tr>
				<td class="info_title">경쟁률</td>
				<td class="info_title">성비</td>
				<td class="info_title">평균 시청자</td>
				<td class="info_title">평균 구독자</td>
			</tr>
			<tr>
				<td class="content4">
					<%
						out.println(roundedNumber + " : 1");
					%>
				</td>
				<td class="content2"><canvas class="doughnut_graph" width="300" height="300"></canvas></td>
				<td class="content2"><canvas class="bar_graph" width="325" height="325"></canvas></td>
				<td class="content2"><canvas class="bar_graph2" width="325" height="325"></canvas></td>
			</tr>
		</table>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>