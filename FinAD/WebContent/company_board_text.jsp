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
        <!-- <div class="written_search">
            <form action="company_board.jsp" method="get">
                <input type="search" name="query" id="search_input" placeholder="검색어를 입력하세요...">
                <button type="submit" class="search_button">검색</button>
                <button type="button" class="search_button" onclick="resetSearch()">초기화</button>
            </form>
        </div> -->
        <div class="written_search">
  		  <form action="company_board.jsp" method="get">
       		 <input type="search" name="query" id="search_input" placeholder="검색어를 입력하세요...">
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
				out.println("<tr>");
				out.println("<td>"+list.get(i).getCompanyBoardNum()+"</td>");
				out.println("<td>"+list.get(i).getTitle()+"</td>");
				out.println("<td>"+list.get(i).getCompanyName()+"</td>");
				out.println("<td>"+list.get(i).getRecruitmentDate1()+"</td>");
				out.println("<td>"+list.get(i).getRecruitmentDate2()+"</td>");
				out.println("<td>"+list.get(i).getPromotionDate1()+"</td>");
				out.println("<td>"+list.get(i).getPromotionDate2()+"</td>");
				out.println("<td>"+list.get(i).getPromotionType()+"</td>");
				out.println("<td>"+list.get(i).getCompanyWriteDate()+"</td>");
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