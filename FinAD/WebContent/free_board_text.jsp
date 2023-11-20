<%@page import="com.finad23.DTO.FreeboardCommentDTO"%>
<%@page import="com.finad23.jjj.FreeBoardComment"%>
<%@page import="com.finad23.jjj.FreeBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.BoardDTO"%>
<%@ page import="com.finad23.DTO.FreeboardLikeDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>free_board_text.jsp</title>
<link rel="stylesheet" href="css/free_board_text.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/free_board_text.js"></script>
<jsp:useBean id="boardList" class="com.finad23.jjj.FreeBoard"
	scope="page" />
<jsp:useBean id="boardLike" class="com.finad23.jjj.FreeBoardLike"
	scope="page" />
<jsp:useBean id="boardComment" class="com.finad23.jjj.FreeBoardComment"
	scope="page" />
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String password = (String) session.getAttribute("password");
		String type = (String) session.getAttribute("type");
		String clickText = request.getParameter("number"); //클릭한 글의 글번호 값을 받아서 저장

		ArrayList<BoardDTO> arr = boardList.getBoardList();

		BoardDTO boardDTO = null;
		for (BoardDTO selected : arr) {
			if (selected.getNumber() == Integer.parseInt(clickText)) {
				boardDTO = selected;
				break;
			}
		}

		ArrayList<FreeboardLikeDTO> arre = boardLike.getBoardList(id, clickText);

		FreeboardLikeDTO freeboardLikeDTO = null;

		for (FreeboardLikeDTO selected : arre) {
			if (selected.getPostID() == Integer.parseInt(clickText)) {
				freeboardLikeDTO = selected;
				break;
			}
		}

		ArrayList<FreeboardCommentDTO> arr3 = boardComment.getBoardList(clickText);

		FreeboardCommentDTO freeboardCommentDTO = null;
		for (FreeboardCommentDTO selected : arr3) {
			if (selected.getPostID() == Integer.parseInt(clickText)) {
				freeboardCommentDTO = selected;
				break;
			}
		}
	%>
	<%
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
		<h1>자유게시판</h1>
		<table>
			<tr>
				<%
					out.println("<td colspan='6'>" + boardDTO.getName() + "</td>");
				%>
			</tr>
			<tr id="text_info">
				<%
					out.println("<td>" + boardDTO.getWriter() + "</td>");
					out.println("<td>" + boardDTO.getDate() + "</td>");
				%>
				<td></td>
				<td>조회수</td>
				<td>추천수</td>
				<td>댓글수</td>
			</tr>
			<tr>
				<%
					out.println("<td colspan='6' id='text'>" + boardDTO.getText() + "</td>");
				%>
			</tr>
			<tr>
				<td colspan='6'>
					<%
						if (id != null) {
							if (freeboardLikeDTO != null) {
					%>
					<div class="voting-buttons">
						<button class="vote-button" id="upvote-button"
							onclick="relikeButton(<%=clickText%>)">

							<img src="img/d_clicked.png" width="50px" height="50px"
								id="like_img" alt="추천">
						</button>
					</div> <%
 	} else {
 %>


					<div class="voting-buttons">
						<button class="vote-button" id="upvote-button"
							onclick="likeButton(<%=clickText%>)">

							<img src="img/d.png" width="50px" height="50px" id="like_img"
								alt="추천">
						</button>
					</div> <%
 	}
 	}
 %> <%
 	
 %>
				</td>
			</tr>
		</table>
	</div>


	<table id="free_board_comment_list" >
		<%
			// 댓글의 수만큼 반복하여 출력
			if (arr3 != null) {
				for (int i = 0; i < arr3.size(); i++) {
					FreeboardCommentDTO comment = arr3.get(i);
					out.println("<tr>");
					out.println("<td>" + (i + 1) + "</td>"); // 일반적으로 댓글 번호는 1부터 시작합니다.
					out.println("<td>" + comment.getUserID() + "</td>");
					out.println("<td>" + comment.getText() + "</td>");
					out.println("<td>" + comment.getCreatedAt() + "</td>");
					out.println("</tr>");
				}
			}
			
		%>

	</table>



	<div id="free_board_comment">
		<form action="free_board_comment_sql.jsp">
			<table>
				<tr>
					<td><textarea name="input_comment"></textarea> <input
						type="hidden" name="input_number" value="<%=clickText%>">
					</td>

					<td><input type="submit" value="등록"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="free_board_btn">
		<table>
			<tr>
				<%
					if (id != null && id.equals(boardDTO.getWriter())) {
				%>
				<td>
					<form action="free_board_update.jsp?number=<%=clickText%>"
						method="post">
						<input type="submit" value="수정">
					</form>
				</td>

				<td>
					<form action="free_board_delete.jsp?number=<%=clickText%>"
						method="post">
						<input type="submit" value="삭제">
					</form>
				</td>
				<%
					} else {
				%><style>
#free_board_btn {
	margin-top: 10px;
	margin-left: 1515px;
}
</style>
				<%
					}
				%>
				<td>
					<form action="free_board.jsp">
						<input type="submit" value="목록">
					</form>
				</td>
			</tr>
		</table>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>