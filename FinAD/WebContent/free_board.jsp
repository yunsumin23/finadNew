<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.BoardDTO"%>
<!-- 1 - 글제목, 글내용 입력안했을때 alert -->
<!-- 2 - 글 작성일에는 작성 시간이 작성일 다음날부터는 작성일이 표기되게 -->
<!-- 7 - 글쓴이, 글쓴날, 조회수, 추천수, 댓글수, 밑줄 한줄로 만들기 -->
<!-- 8 - 조회수, 추천수, 댓글수 구현 -->
<!-- 10 - 글 목록에서 15,30,50개 단위로 보기랑 다음페이지 가는 버튼 만들기  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>free_board.jsp</title>
<link rel="stylesheet" href="css/free_board.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/free_board.js"></script>
<script>
var id = '<%= session.getAttribute("id") %>';
var password = '<%= session.getAttribute("password") %>';

function check_login() {
    if (id=='null' || password=='null') {
        alert("로그인 후 이용하실 수 있습니다.");
        return false;
    }
    return true;
}
</script>

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
	<jsp:useBean id="boardList" class="com.finad23.jjj.FreeBoard"
		scope="page" />

	<div id="table_header">
		<h1>자유게시판</h1>
		<table>
			<tr id="sss">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>추천</th>
			</tr>
			<%
				ArrayList<BoardDTO> boardDTO = boardList.getBoardList();
				for (int i = 0; i < boardDTO.size(); i++) {
					int number = boardDTO.get(i).getNumber();
					String writer = boardDTO.get(i).getWriter();
					String name = boardDTO.get(i).getName();
					String date = boardDTO.get(i).getDate();
					out.println("<tr>");
					out.println("<td>" + number + "</td>");
					out.println("<td><a href='free_board_text.jsp?number=" + number + "'>" + name + "</td>");
					out.println("<td>" + writer + "</td>");
					out.println("<td>" + date + "</td>");
					out.println("<td>" + "조회수"+ "</td>");
					out.println("<td>" + "추천수" + "</td>");
					out.println("</tr>");
				}
			%>
		</table>
		<div id="free_board_write_btn">
			<form action = "free_board_write.jsp" onsubmit="return check_login();">
				<input type="submit" value="글쓰기">
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

