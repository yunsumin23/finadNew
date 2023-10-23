<%@page import="java.util.ArrayList"%>
<%@page import="com.finad23.VO.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.BoardDTO"%>
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
<%
ArrayList<BoardDTO> articleList=(ArrayList<BoardDTO>)request.getAttribute("articleList");
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
%>
<% if (pageInfo != null) { 
int listCount = pageInfo.getListCount();
int nowPage = pageInfo.getPage();
int maxPage = pageInfo.getMaxPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();
 } %>

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
	<jsp:useBean id="boardList" class="com.finad23.jjj.FreeBoard" scope="page" />

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
					int view = boardDTO.get(i).getView();
					int like = boardDTO.get(i).getLike();
					out.println("<tr>");
					out.println("<td>" + number + "</td>");
					out.println("<td><a href='free_board_text.jsp?number=" + number + "' onclick='views(" + number + ")'>" + name + "</td>"); // 클릭 이벤트 추가
					out.println("<td>" + writer + "</td>");
					out.println("<td>" + date + "</td>");
					out.println("<td>" + view + "</td>");
					out.println("<td>" + like + "</td>");
					out.println("</tr>");
				}
			%>
		</table>
		<div id="free_board_write_btn">
			<form action = "free_board_write.jsp" onsubmit="return check_login();">
				<input type="submit" value="글쓰기">
			</form>
		</div>
		<section id="pageList">
		<%if(nowPage<=1){ %>
		[이전]&nbsp;
		<%}else{ %>
		<a href="boardList.bo?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>

		<%for(int a=startPage;a<=endPage;a++){
				if(a==nowPage){%>
		[<%=a %>]
		<%}else{ %>
		<a href="boardList.bo?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
		<%} %>
		<%} %>

		<%if(nowPage>=maxPage){ %>
		[다음]
		<%}else{ %>
		<a href="boardList.bo?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
	</section>
	
		<div id="free_board_search">
			<form action="free_board.jsp">
				<select>
					<option>제목</option>
					<option>내용</option>
					<option>제목+내용</option>
				</select>
				<input type="search">
				<input type="submit" value="검색">
			</form>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

