<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.CompanyBoardDTO" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/company_board.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/company_board.js"></script>
<title>company_board.jsp</title>
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
	<div id="company_board_category_container">
		<h1>광고게시판</h1>
		<div id="written_table">
            <table border="1">
                <tr>
                    <th class="written_head">홍보 종류</th>
                    <th class="written_head">홍보 기간</th>
                    <th class="written_head2" colspan="5">카테고리</th>
                </tr>
                <tr>
                    <td rowspan="7">
                        <input type="checkbox" name="type" value="live"><span>생방송</span><br>
                        <input type="checkbox" name="type" value="ureview"><span>유튜브 리뷰</span><br>
                        <input type="checkbox" name="type" value="ucontent"><span>유튜브 컨텐츠</span><br>
                        <input type="checkbox" name="type" value="model"><span>홍보모델</span><br>
                        <input type="checkbox" name="type" value="banner"><span>홍보베너</span><br>
                        <input type="checkbox" name="type" value="cf"><span>CF</span><br>
                        <input type="checkbox" name="type" value="others"><span>기타</span>
                    </td>
                    <td rowspan="7">
                        <input type="checkbox" name="duration" value="1"><span>1회성 컨텐츠</span><br>
                        <input type="checkbox" name="duration" value="7"><span>1 ~ 7일</span><br>
                        <input type="checkbox" name="duration" value="14"><span>7 ~ 14일</span><br>
                        <input type="checkbox" name="duration" value="30"><span>14 ~ 30일</span><br>
                        <input type="checkbox" name="duration" value="60"><span>30 ~ 60일</span><br>
                        <input type="checkbox" name="duration" value="90"><span>60 ~ 90일</span><br>
                        <input type="checkbox" name="duration" value="91"><span>90일 이상</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" name="category" value="뷰티 * 패션"><span>뷰티 * 패션</span><br><br>
                        <input type="checkbox" name="category" value="먹방"><span>먹방</span><br><br>
                        <input type="checkbox" name="category" value="BJ * 엔터테이너"><span>BJ * 엔터테이너</span><br><br>
                        <input type="checkbox" name="category" value="vLog * 일상"><span>vLog * 일상</span>
                    </td>
                    <td>
                        <input type="checkbox" name="category" value="게임"><span>게임</span><br><br>
                        <input type="checkbox" name="category" value="it"><span>IT * 전자기기</span><br><br>
                        <input type="checkbox" name="category" value="music"><span>음악 * 춤</span><br><br>
                        <input type="checkbox" name="category" value=""><span>요리 * 베이킹</span>
                    </td>
                    <td>
                        <input type="checkbox" name="category" value=""><span>여행 * 아웃도어</span><br><br>
                        <input type="checkbox" name="category" value=""><span>동물 * 펫</span><br><br>
                        <input type="checkbox" name="category" value=""><span>스포츠 * 건강</span><br><br>
                        <input type="checkbox" name="category" value=""><span>영화 * 애니</span>
                    </td>
                    <td>
                        <input type="checkbox" name="category" value=""><span>자동차</span><br><br>
                        <input type="checkbox" name="category" value=""><span>키즈 * 플레이</span><br><br>
                        <input type="checkbox" name="category" value=""><span>교육</span><br><br>
                        <input type="checkbox" name="category" value=""><span>부동산 * 투자</span><br>
                    </td>
                    <td>
                        <input type="checkbox" name="category" value=""><span>정치 * 시사</span><br><br>
                        <input type="checkbox" name="category" value=""><span>그림 * 만들기</span><br><br>
                        <input type="checkbox" name="category" value=""><span>운세 * 타로</span><br><br>
                        <input type="checkbox" name="category" value=""><span>기타</span>
                    </td>
                </tr>
            </table>
        </div>
        <div class="written_search">
  		  <form action="company_board.jsp" method="get">
       		 <input type="search" name="company_board_search" id="search_input" placeholder="검색어를 입력하세요...">
        	 <button type="button" class="search_button" onclick="search()">검색</button>
       		 <button type="button" class="search_button" onclick="resetSearch()">초기화</button>
   		  </form>
 		</div>
	</div>
	
	<div id="company_board_container">
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>회사명</th>
			<th>모집 시작</th>
			<th>모집 종료</th>
			<th>광고 시작</th>
			<th>광고 종료</th>
			<th>광고 유형</th>
			<th>작성일</th>
		</tr>
	
	<%	
		List<CompanyBoardDTO> list = (List<CompanyBoardDTO>) request.getAttribute("List");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				int number = list.get(i).getCompanyBoardNum();
				String title = list.get(i).getTitle();
				String companyName = list.get(i).getCompanyName();
				String recruitmentDate1 =list.get(i).getRecruitmentDate1();
				String recruitmentDate2 = list.get(i).getRecruitmentDate2();
				String promotionDate1 = list.get(i).getPromotionDate1();
				String promotionDate2 = list.get(i).getPromotionDate2();
				String promotionType = list.get(i).getPromotionType();
				String companyWriteDate = list.get(i).getCompanyWriteDate();
				
				out.println("<tr>");
				out.println("<td>"+ number +"</td>");
				out.println("<td id='title'><a href='company_board_text.finad?url=CBoardText&number="+ number+"'>"+ title +"</a></td>");
				out.println("<td>"+ companyName +"</td>");
				out.println("<td>"+ recruitmentDate1 +"</td>");
				out.println("<td>"+ recruitmentDate2 +"</td>");
				out.println("<td>"+ promotionDate1 +"</td>");
				out.println("<td>"+ promotionDate2 +"</td>");
				out.println("<td>"+ promotionType +"</td>");
				out.println("<td>"+ companyWriteDate +"</td>");
				out.println("</tr>");
				}
		} else {
			out.print("데이터가 없습니다.");
		}
	%>
	</table>
	<div id="company_board_write_btn">
			<form action = "company_board.finad?url=CBoardWrite" onsubmit="return check_login();" method="post">
				<input type="submit" value="글쓰기">
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
		
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>