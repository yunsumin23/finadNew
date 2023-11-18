<%@page import="com.finad23.jjj.Influ_info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/compare.css">
<script type="text/javascript" src="js/compare.js"></script>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String password = (String) session.getAttribute("password");
		String type = (String) session.getAttribute("type");
		Influ_info info = (Influ_info) request.getAttribute("info");
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
	<div class="contents">
		<section>
			<h1>인플루언서 비교하기</h1>
		</section>

		<div class="container">
			<section id="fir_sec">
				1
				<div>
					<img alt="" src="img/<%= info.getImage()%>">
				</div>
				<div>닉네임</div>
			</section>
			<section id="sec_sec">
				2
			</section>

		</div>
	</div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>