<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>company_board_write.jsp</title>
<link rel="stylesheet" href="css/company_board_write.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
<script type="text/javascript"
	src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<script type="text/javascript" src="js/company_board_write.js"></script>
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
	<!-- 	기업 회원만 작성 가능 하게 하는 조건문 [테스트를 위해 주석 처리] -->
	<!-- 	기업 회원만 작성 가능 하게 하는 조건문 [테스트를 위해 주석 처리] -->
	<%-- 		<%if(type==null || !type.equals("company")){%> --%>
	<!-- 		<script>alert("권한이 없습니다")</script> -->
	<%-- 		<%return; --%>
	<%-- 	}%> --%>

	<div id="write_container">
		<form action="company_board.jsp?url=CBoardWrited" method="post">
			<table border="1">
				<tr>
					<td class="title">제목</td>
					<td class="content" colspan="3"><input type="text" name="title" id="content_title"></td>
				</tr>
				<tr>
					<td class="title">회사명</td>
					<td class="content" colspan="3">값 불러옴(미구현)</td>
				</tr>
				<tr>
					<td class="title" rowspan="3">마케팅 담당자 정보</td>
					<td class="content" colspan="3">담당자 이름</td>
				</tr>
				<tr>
					<td class="content" colspan="3">담당자 이메일</td>
				</tr>
				<tr>
					<td class="content" colspan="3">담당자 전화번호</td>
				</tr>
				<tr>
					<td class="title">모집 기간</td>
					<td class="content2" colspan="1">
						<input type="date" class="write_date" max="2100-12-31" min="2023-08-23" name="recruitmentDate1" value="2023-08-23"> ~ 
						<input type="date" class="write_date" max="2100-12-31" min="2023-08-23" name="recruitmentDate2" value="2023-08-23">
					</td>
					<td class="title">홍보 기간</td>
					<td class="content2" colspan="1"><input type="date" class="write_date" max="2100-12-31" min="2023-08-23" name="promotionDate1" value="2023-08-23"> ~ 
						<input type="date" class="write_date" max="2100-12-31" min="2023-08-23" name="promotionDate2" value="2023-08-23">
					</td>
				</tr>
				<tr>
					<td class="title">모집 인원</td>
					<td class="content3"><input type="text" name="recruitmentNum"><span> 명</span></td>
					<td class="title">성별</td>
					<td class="content2">
						<div class="write_text">
							<input type="radio" name="sex" value="남자">남성 
							<input type="radio" name="sex" value="여자">여성
						</div>
					</td>
				</tr>
				<tr>
					<td class="title">평균 시청자</td>
					<td class="content3"><input type="text" name="avgViewers"><span> 명</span></td>
					<td class="title">구독자 수</td>
					<td class="content3"><input type="text" name="subscribers"><span> 만명</span></td>
				</tr>
				<tr>
					<td class="title">미달자 지원</td>
					<td class="content2">
						<input type="radio" name="underachiever" value="yes">O 
						<input type="radio" name="underachiever" value="no">X
					</td>
					<td class="title">총 광고진행비</td>
					<td class="content3"><input type="text" name="promotionMoney"><span> 만원</span></td>
				</tr>
				<tr>
					<td class="title">광고 유형</td>
					<td class="content2" colspan="3">
						<input type="checkbox" name="promotionType" value="생방송"> 생방송 
						<input type="checkbox" name="promotionType" value="유튜브 리뷰 "> 유튜브 리뷰 
						<input type="checkbox" name="promotionType" value="유튜브 콘텐츠 "> 유튜브 콘텐츠 
						<input type="checkbox" name="promotionType" value="홍보모델 "> 홍보모델 
						<input type="checkbox" name="promotionType" value="홍보배너 "> 홍보배너 
						<input type="checkbox" name="promotionType" value="CF"> CF 
						<input type="checkbox" name="promotionType" value="기타"> 기타
					</td>
				</tr>
				<tr>
					<td class="title" rowspan="3">이전 광고 사례</td>
					<td class="content" colspan="3">값 불러옴(미구현)</td>
				</tr>
				<tr>
					<td class="content" colspan="3">값 불러옴(미구현)</td>
				</tr>
				<tr>
					<td class="content" colspan="3">값 불러옴(미구현)</td>
				</tr>
				<tr>
					<td colspan="6"><textarea name="input_text" name="text" id="editor"></textarea></td>
				</tr>

			</table>
			<input type="submit" id="submit_btn" value="완료">
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>