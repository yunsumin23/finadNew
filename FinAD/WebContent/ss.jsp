<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.finad23.DTO.CategoryFilterDTO"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/categori.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/categori01.js"></script>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String password = (String) session.getAttribute("password");
		String type = (String) session.getAttribute("type");
		String category = request.getParameter("url");
		List<CategoryFilterDTO> list = (List<CategoryFilterDTO>) request.getAttribute("List");
		int creatorNum = list.size();
		out.println(creatorNum);

		if (list != null) {
			for (CategoryFilterDTO cate : list) {
				DecimalFormat df = new DecimalFormat("#,###");
				String Subscribers = df.format(cate.getSubscribers());
				String AvgViewers = df.format(cate.getAvgviewers());
				String nickname = cate.getNickname();
	%>
		<div class="rank_div">
		<ul class="rank_ul">
			<li class="rank_li01">크리에이터 랭킹</li>
			<%
				out.println("<li class='rank_li02'>총 " + creatorNum + "명의 크리에이터 검색</li>");
				/* out.println(category); */
			%>

		</ul>
	</div>
	
	<div id="list_01_wrapper">
		<div class="list_01 asdf">
			<div class="list_01_div01">
				<input type="checkbox" name="list_name01" class="list_check" width="20px">
				<p></p>
				<p class="star">
					<img src="img/star02.png" alt="" id="star01" onclick="img_change(this)">
				</p>
			</div>
			<div class="list_01_div02">
				<a href="creator.finad23?nickname=<%=nickname%>" target="_blank" class="list_01_img"><img src="img/<%=cate.getImage()%>" alt="" id="img_data">
					<div>
						<span class="div_img"> <%=nickname%>
						</span>
					</div> </a>
			</div>
			<div class="list_01_div03">
				<ul>
					<li><p id="sub_data"><%=Subscribers%></li>
					<li><p id="viwe_data"><%=AvgViewers%></li>
					<li><p id="cpv_data"><%=cate.getAvgviewers() * 0.01%></li>
					<li>광고 영상 호감도</li>
					<li><p id="price_data"><%=(int) ((cate.getAvgviewers() * 0.001) * 30)%>만원</li>
				</ul>
			</div>
		</div>
	</div>
	<%
		}
		}
	%>


</body>
</html>