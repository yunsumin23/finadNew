<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/company_board.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/company_board.js"></script>
<title>company_write.jsp</title>
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
	<div id="company_board_container">
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
                        <input type="checkbox" value=""><span>생방송</span><br>
                        <input type="checkbox" value=""><span>유튜브 리뷰</span><br>
                        <input type="checkbox" value=""><span>유튜브 컨텐츠</span><br>
                        <input type="checkbox" value=""><span>홍보모델</span><br>
                        <input type="checkbox" value=""><span>홍보베너</span><br>
                        <input type="checkbox" value=""><span>CF</span><br>
                        <input type="checkbox" value=""><span>기타</span>
                    </td>
                    <td rowspan="7">
                        <input type="checkbox" value=""><span>1회성 컨텐츠</span><br>
                        <input type="checkbox" value=""><span>1 ~ 7일</span><br>
                        <input type="checkbox" value=""><span>7 ~ 14일</span><br>
                        <input type="checkbox" value=""><span>14 ~ 30일</span>/<br>
                        <input type="checkbox" value=""><span>30 ~ 60일</span><br>
                        <input type="checkbox" value=""><span>60 ~ 90일</span><br>
                        <input type="checkbox" value=""><span>90일 이상</span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" value=""><span>뷰티 * 패션</span><br><br>
                        <input type="checkbox" value=""><span>먹방</span><br><br>
                        <input type="checkbox" value=""><span>BJ * 엔터테이너</span><br><br>
                        <input type="checkbox" value=""><span>vLog * 일상</span>
                    </td>
                    <td>
                        <input type="checkbox" value=""><span>게임</span><br><br>
                        <input type="checkbox" value=""><span>IT * 전자기기</span><br><br>
                        <input type="checkbox" value=""><span>음악 * 춤</span><br><br>
                        <input type="checkbox" value=""><span>요리 * 베이킹</span>
                    </td>
                    <td>
                        <input type="checkbox" value=""><span>여행 * 아웃도어</span><br><br>
                        <input type="checkbox" value=""><span>동물 * 펫</span><br><br>
                        <input type="checkbox" value=""><span>스포츠 * 건강</span><br><br>
                        <input type="checkbox" value=""><span>영화 * 애니</span>
                    </td>
                    <td>
                        <input type="checkbox" value=""><span>자동차</span><br><br>
                        <input type="checkbox" value=""><span>키즈 * 플레이</span><br><br>
                        <input type="checkbox" value=""><span>교육</span><br><br>
                        <input type="checkbox" value=""><span>부동산 * 투자</span><br>
                    </td>
                    <td>
                        <input type="checkbox" value=""><span>정치 * 시사</span><br><br>
                        <input type="checkbox" value=""><span>그림 * 만들기</span><br><br>
                        <input type="checkbox" value=""><span>운세 * 타로</span><br><br>
                        <input type="checkbox" value=""><span>기타</span>
                    </td>
                </tr>
            </table>
        </div>
        <div class="written_search">
            <form action="/search" method="get">
                <input type="text" name="query" id="search_input" placeholder="검색어를 입력하세요...">
                <button type="submit" class="search_button">검색</button>
                <button type="button" class="search_button" onclick="resetSearch()">초기화</button>
            </form>
        </div>
	</div>
	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>