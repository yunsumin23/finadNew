<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.AdstoreDTO"%>
<%@ page import="com.finad23.jjj.*"%>

<!DOCTYPE html>
<html lang="ko">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ADstore</title>
<link rel="stylesheet" href="css/adstore.css" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/adstore.js" type="text/javascript"></script>

</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String password = (String) session.getAttribute("password");
		String type = (String) session.getAttribute("type");
		if (id == null && password == null) {
	%>
	<jsp:include page="adheader_login.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="adheader_logout.jsp"></jsp:include>
	<%
		}
	%>
	<%
		AdstoreDTO aa = new AdstoreDTO();
		Adstore adstorelist = new Adstore();
		ArrayList<AdstoreDTO> jjj = adstorelist.getAdstoreList();
	%>
	<div id="contain">
		<span class="slideshow-container">
			<div id="hhh">
				<div class="Slidesbackground">
					<div class="mySlides fade">
						<a href="sellpage.jsp"><img src="img/fashionban.jpg" class="slideshow-image"></a>
					</div>
					<div class="mySlides fade">
						<a href="sellpage.jsp"><img src="img/campban.jpg" class="slideshow-image"></a>
					</div>
					<div class="mySlides fade">
						<a href="sellpage.jsp"><img src="img/electroban.jpg" class="slideshow-image"></a>
					</div>
					<div class="mySlides fade">
						<a href="sellpage.jsp"><img src="img/beautyban.jpg" class="slideshow-image"></a>
					</div>
					<div class="mySlides fade">
						<a href="sellpage.jsp"><img src="img/foodban.jpg" class="slideshow-image"></a>
					</div>
					<div class="mySlides fade">
						<a href="sellpage.jsp"><img src="img/petban.jpg" class="slideshow-image"></a>
					</div>
					<div class="mySlides fade">
						<a href="sellpage.jsp"><img src="img/kidban.jpg" class="slideshow-image"></a>
					</div>
					<div class="mySlides fade">
						<a href="sellpage.jsp"><img src="img/healthban.jpg" class="slideshow-image"></a>
					</div>
				</div>
			</div>
		</span>

<div class="advertising_type">
		<p class="advertising_type_p"></p>
		<ul class="advertising_ul">
			<li onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)"><a
				href=""><img
					src="img/beautyicon.png" alt="뷰티">
					<p class="lil_p">뷰티</p> </a></li>
			<li onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)"><a
				href="#" target="_blank"><img src="img/campicon.png"
					alt="여행">
					<p class="lil_p">여행</p> </a></li>
			<li onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)">
			<a href="#ele">
			<img src="img/electroicon.png" alt="가전">
					<p class="lil_p">가전</p> </a></li>
			<li onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)"><a
				href="#fash"><img src="img/fashionicon.png"
					alt="패션">
					<p class="lil_p">패션</p> </a></li>
			<li onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)"><a
				href="#" target="_blank"><img src="img/foodicon.png"
					alt="식품">
					<p class="lil_p">식품</p> </a></li>
			<li onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)"><a
				href="#" target="_blank"><img src="img/healthicon.png" alt="건강">
					<p class="lil_p">건강</p> </a></li>
					<li onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)"><a
				href="#" target="_blank"><img src="img/kidicon.png" alt="키즈">
					<p class="lil_p">키즈</p> </a></li>
					<li onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)"><a
				href="#" target="_blank"><img src="img/peticon.png" alt="애견">
					<p class="lil_p">애견</p> </a></li>
		</ul>
	</div>


		<h1 class="h1">오늘의 쇼핑 제안</h1>
		<div id="product-list">
			<a href="sellpage.jsp" target="_blank">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(0).getItemImage() + "' + alt=''>");
						%>
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(0).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(0).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/nike.png" />
								<%
									out.println("<span>" + jjj.get(0).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="sellpage.jsp">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(1).getItemImage() + "' + alt=''>");
						%>
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(1).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(1).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/oking.png" />
								<%
									out.println("<span>" + jjj.get(1).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(2).getItemImage() + "' + alt=''>");
						%>
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(2).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(2).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/boy.png" />
								<%
									out.println("<span>" + jjj.get(2).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(3).getItemImage() + "' + alt=''>");
						%>
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(3).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(3).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/samsung.png" />
								<%
									out.println("<span>" + jjj.get(3).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(4).getItemImage() + "' + alt=''>");
						%>
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(4).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(4).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/girl.png" />
								<%
									out.println("<span>" + jjj.get(4).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="">
				
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/oking.png" />
								<%
									out.println("<span>" + jjj.get(5).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(6).getItemImage() + "' + alt=''>");
						%> 
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(6).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(5).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/boy.png" />
								<%
									out.println("<span>" + jjj.get(6).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(7).getItemImage() + "' + alt=''>");
						%>
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(7).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(7).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/gongdae.png" />
								<%
									out.println("<span>" + jjj.get(7).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(8).getItemImage() + "' + alt=''>");
						%>
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(8).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(8).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/nike.png" />
								<%
									out.println("<span>" + jjj.get(8).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a> <a href="">
				<div class="product-card">
					<div>
						<%
							out.println("<img class='product-img' src='img/" + jjj.get(9).getItemImage() + "' + alt=''>");
						%>
					</div>
					<div class="product-contents">
						<%
							out.println("<span class='product-name'>" + jjj.get(9).getItemName() + "</span><span class='product-price'>"
									+ jjj.get(9).getItemPrice() + "원</span>");
						%>
						<div>
							<div class="product-seller">
								<img class="product-avatar" src="img/oking.png" />
								<%
									out.println("<span>" + jjj.get(9).getItemSeller() + "</span>");
								%>
							</div>
						</div>
					</div>
				</div>
			</a>
			</section>
			<div class="mm">
				<div class="right_div">
					<h1 id="ele">ADStore 가전관</h1>
					<div class="right_div_div">
						<ul>
							<li><a href=""><img src="img/zflip.png" alt=""></a></li>
							<li><a href=""><img src="img/lg_go.png" alt=""></a></li>
							<li><a href=""><img src="img/macbook.png" alt=""></a></li>
						</ul>
					</div>
				</div>
				
				
				<div class="left_div">
					<h1 id="fash"> ADStore 패션관</h1>
					<div class="m_div">
						<div class="left_div_div01">
							<a href=""><img src="img/coat.png" alt="옷"
								onmouseenter="zoomIn(event)" onmouseleave="zoomOut(event)">
							</a>
						</div>
						<div class="left_div_div02">
							<ul>
							<li><a href="sellpage.jsp">
									<div id="product-bt">
										<div class="product-cardbt">
										<div>
						<%
							out.println("<img id='product-img' src='img/" + jjj.get(9).getItemImage() + "' + alt='' + onmouseenter='zoomIn(event)' onmouseleave='zoomOut(event)' >");
						%>
					</div>
					</div>
				</div>
					<li><a href="sellpage.jsp">
									<div id="product-bt">
										<div class="product-cardbt">
										<div>
						<%
							out.println("<img id='product-img' src='img/" + jjj.get(0).getItemImage() + "' + alt='' + onmouseenter='zoomIn(event)' onmouseleave='zoomOut(event)' >");
						%>
					</div>
					</div>
				</div>
				</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="cart_div">
				<a href="cart.jsp"><img src="img/cart.png" alt=""></a>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
