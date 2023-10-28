<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.CompanyBoardDTO" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/company_board_text.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/company_board.js"></script>
<title>company_board_text.jsp</title>
</head>
<body>
<%
	String id = (String) session.getAttribute("id");
	String password = (String) session.getAttribute("password");
	String type = (String) session.getAttribute("type");
	String clickText = request.getParameter("number"); //클릭한 글의 글번호 값을 받아서 저장
	
	List<CompanyBoardDTO> list = (List<CompanyBoardDTO>) request.getAttribute("List");
	CompanyBoardDTO CBoardDTO = null;
	for (CompanyBoardDTO selected : list) {
		if (selected.getCompanyBoardNum() == Integer.parseInt(clickText)) {
			CBoardDTO = selected;
			break;
		}
	}
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
	<div id="text_header">
		<h1>광고게시판</h1>
		<p><%out.println(CBoardDTO.getCompanyWriteDate());%></p>
	</div>
	
	<div id="text_container">
		<table id="info_box">
			<tr>
				<td class="title" colspan="3"><%out.println(CBoardDTO.getTitle()); %></td> 
				<td class="content2"><%out.println(CBoardDTO.getCompanyName()); %></td>
			</tr>
			<tr>
				<td class="info_title">총 광고 비용</td>
				<td class="info_title">모집 기간</td>
				<td class="info_title">홍보 기간</td>
				<td class="info_title">광고 유형</td>
			</tr>
			<tr>
				<td class="content2"><%out.println(CBoardDTO.getPromotionMoney()); %><span>만원</span></td>
				<td class="content2"><%out.println(CBoardDTO.getRecruitmentDate1()); %> ~ <%out.println(CBoardDTO.getRecruitmentDate2()); %></td>
				<td class="content2"><%out.println(CBoardDTO.getPromotionDate1()); %> ~ <%out.println(CBoardDTO.getPromotionDate2()); %></td>
				<td class="content2"><%out.println(CBoardDTO.getPromotionType()); %></td>
			</tr>
		</table>
		
		<h1>모집 조건</h1>
		<table id="info_box">
			<tr>
				<td class="info_title">모집 인원</td>
				<td class="info_title">평균 시청자</td>
				<td class="info_title">구독자 수</td>
				<td class="info_title">조건 미달자 지원 가능 여부</td>
			</tr>
			<tr>
				<td class="content2"><%out.println(CBoardDTO.getRecruitmentNum()); %><span>명</span></td>
				<td class="content2"><%out.println(CBoardDTO.getAvgViewers()); %><span>명</span></td>
				<td class="content2"><%out.println(CBoardDTO.getSubscribers());%><span>만명</span></td>
				<td class="content2"><%out.println(CBoardDTO.getUnderachiever()); %></td>
			</tr>
			<tr>
				<td><br></td>
			<tr>
			<tr>
				<td class="info_title">성별</td>
				<td class="info_title"></td>
				<td class="info_title"></td>
				<td class="info_title"></td>
			</tr>
			<tr>
				<td class="content2"><%out.println(CBoardDTO.getSex());%></td>
				<td class="content2"><%%></td>
				<td class="content2"><%%></td>
				<td class="content2"><%%></td>
			</tr>
		</table>
		
		<h1>광고 내용</h1>
		<table id="info_box">
			<tr>
				<td class="info_title">총 광고 비용</td>
				<td class="info_title">홍보 기간</td>
				<td class="info_title">광고 유형</td>
				<td class="info_title"></td>
			</tr>
			<tr>
				<td class="content2"><%out.println(CBoardDTO.getPromotionMoney()); %><span>만원</span></td>
				<td class="content2"><%out.println(CBoardDTO.getPromotionDate1()); %> ~ <%out.println(CBoardDTO.getPromotionDate2()); %></td>
				<td class="content2"><%out.println(CBoardDTO.getPromotionType()); %></td>
				<td class="content2"></td>
			</tr>
		</table>
		
		<h1>상세 요강</h1>
		<table id="info_box">
			<tr>
				<td colspan="4" id="c_text"><%out.println(CBoardDTO.getText()); %></td>
			</tr>
		</table>

		<h1>이전 광고 사례</h1>
		<table id="info_box">
			<tr>
				<td class="content2" colspan="4"><a href='<%= CBoardDTO.getPreviousPromotion1() %>'><%= CBoardDTO.getPreviousPromotion1() %></a></td>
			</tr>
			<tr>
				<td class="content2" colspan="4"><a href='<%= CBoardDTO.getPreviousPromotion2() %>'><%= CBoardDTO.getPreviousPromotion2() %></a></td>
			</tr>
			<tr>
				<td class="content2" colspan="4"><a href='<%= CBoardDTO.getPreviousPromotion3() %>'><%= CBoardDTO.getPreviousPromotion3() %></a></td>
			</tr>	
		</table>		
		<h1>마케팅 담당자 정보</h1>
		<table id="info_box">
			<tr>
				<td class="info_title">이름</td>
				<td class="info_title">이메일</td>
				<td class="info_title">전화번호</td>
			</tr>
			<tr>
				<td class="content2"><%out.println(CBoardDTO.getCompanyInfo1());%></td>
				<td class="content2"><%out.println(CBoardDTO.getCompanyInfo2());%></td>
				<td class="content2"><%out.println(CBoardDTO.getCompanyInfo3());%></td>
			</tr>
		</table>
		<form action="" id="submit_btn1" method="post">
			<input type="submit" value="지원하기">
		</form>		
		<form action="company_board.finad?url=CBoard" id="submit_btn2" method="post">
			<input type="submit" value="목록">
		</form>
	</div>
	
<!-- 	기업 회원만 버튼 보이게 하는 조건문 [테스트를 위해 주석 처리] -->
<!-- 	기업 회원만 버튼 보이게 하는 조건문 [테스트를 위해 주석 처리] -->
<%-- 	<%if(type!=null && type.equals("company")){%> --%>
<!-- 		<div id="company_board_write_btn"> -->
<!-- 			<form action = "company_board_write.jsp" onsubmit="return check_login();"> -->
<!-- 				<input type="submit" value="글쓰기"> -->
<!-- 			</form> -->
<!-- 		</div> -->
<%-- 	<%}%> --%>
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>