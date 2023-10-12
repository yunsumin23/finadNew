<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.finad23.DTO.AdstoreDTO"%>
<%@ page import="com.finad23.DTO.AdstoreReviewDTO" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>sellpage</title>
        <link rel="stylesheet" href="css/sellpage.css" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script src="js/sellpage.js" type="text/javascript"></script>
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
<jsp:useBean id="adstorelist" class="com.finad23.jjj.Adstore" scope="page" />
<jsp:useBean id="adreviewlist" class="com.finad23.jjj.AdstoreReview" scope="page" />
		
	<%
		ArrayList<AdstoreDTO> jjj = adstorelist.getAdstoreList();
	%>
  
        <section class="section">
            <div class="info">
                <div class="nike_slide">
                    <ul>
                        <li><a href=""><img src="img/niket1.png" alt=""></a></li>
                        <li><a href=""><img src="img/niket2.png" alt=""></a></li>
                        <li><a href=""><img src="img/niket3.png" alt=""></a></li>
                    </ul>
                </div>
                <div class="summary">
                    <nav>
                        <h1 class="nikekr"><a href="https://www.nike.com/kr" id="nikr"> 나이키 코리아 </a></h1>
                        <h5 class="rating star4">
                            <a href="#ree">상품평 보기</a>
                        </h5>
                        <h5> 상품번호 : <span>4512154</span>
                        </h5>
                    </nav>
                    <nav>
                        <h3><%
							out.println("<span class='product-name'>" + jjj.get(0).getItemName() + "</span>");
						%></h3>
                        <div class="chs">
                            <div class="yyy">
                                <h4>사이즈</h4>
                                <select class="choose"> 
                                    <option value="x-small">X</option>
                                    <option value="small">S</option>
                                    <option value="medium">M</option>
                                    <option value="large">L</option>
                                    <option value="x-large">XL</option>
                                    <option value="xx-large">2XL</option>
                                    </select>
                            </div>
                            <div class="yyy">
                                <h4>색상</h4>
                                <select class="choose"> 
                                    <option value="black">블랙</option>
                                    <option value="white">화이트</option>
                                    <option value="gray">그레이</option>
                                    <option value="navy">네이비</option>
                                </select>
                            </div>
                        </div>
                      
                    </nav>
                    <nav>
                        <div class="org_price">
                            <del>가격 30,000</del>
                            <span>10%</span>
                        </div>
                     
                    </nav>
                    <nav>
                        <span class="delivery">무료배송</span>
                        <span class="arrival">내일 (토) 9/10 도착 보장</span>
                    </nav>
                    <nav>
                        <span class="origin">원산지-상세설명 참조</span>
                    </nav>
                    <div class="count">
    <button class="decrease">-</button>
    <input type="text" name="num" id="quantity" size="2" maxlength="4" value="1" readonly> <!-- 수정: ID 추가 -->
    <span><i class="fas fa-arrow-alt-circle-up up"></i></span>
    <span><i class="fas fa-arrow-alt-circle-down down"></i></span>
    <button class="increase">+</button>
</div>

<div class="total">
    <span><span id="totalPrice"><%= jjj.get(0).getItemPrice() %>원</span></span> <!-- 수정: ID 추가 -->
    총 상품금액
</div>
<script type="text/javascript">
    $(document).ready(function() {
        // 초기 상품 가격 및 수량 설정
        var itemPrice = <%= jjj.get(0).getItemPrice() %>;
        var quantity = parseInt($("#quantity").val());
        var totalPrice = itemPrice * quantity;
        
        // 총 상품금액을 업데이트하는 함수
        function updateTotalPrice() {
            quantity = parseInt($("#quantity").val());
            totalPrice = itemPrice * quantity;
            $("#totalPrice").text(totalPrice + "원");
        }
        
        // 수량을 증가시키는 이벤트 리스너
        $(".increase").click(function() {
            quantity++;
            $("#quantity").val(quantity);
            updateTotalPrice();
        });
        
        // 수량을 감소시키는 이벤트 리스너
        $(".decrease").click(function() {
            if (quantity > 1) {
                quantity--;
                $("#quantity").val(quantity);
                updateTotalPrice();
            }
        });
        
        // 수량 입력란에 직접 값을 입력할 때
        $("#quantity").change(function() {
            quantity = parseInt($(this).val());
            if (quantity < 1) {
                quantity = 1;
                $("#quantity").val(quantity);
            }
            updateTotalPrice();
        });
        
        // 페이지 로딩 시 초기 총 상품금액 설정
        $("#totalPrice").text(totalPrice + "원");
    });
</script>
                    <div class="button">
                        <input type="button" class="cart" value="장바구니" onclick="location.href='cart.jsp'">
                        <input type="button" class="order" value="바로결제" onclick="location.href='pay.html'">
                    </div>
                </div>
            </div>
            <article class="detail">
                
                <div>
                <img class="nike_2" src="img/nike2.png" alt="상세페이지1">
                <img class="nike_3" src="img/nike3.png" alt="상세페이지2">
                <img class="nike_4" src="img/nike4.png" alt="상세페이지3">
                <!-- <img class="nike_4" src="img/nike4.jpg" alt="상세페이지3">   -->
            </div>
            </article>
            <article class="notice">
                <p class="notice_last"> 소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고 동법 제 18조 제1항 에 따라
                    청약철회한 물품을 판매자에게 반환하였음에도 불구 하고 결제 대금의 환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조 제2항 및 동법
                    시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여 산정한 지연이자(“지연배상금”)를 신청할 수 있습니다. 아울러, 교환∙반품∙보증 및 결제대금의
                    환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다. </p>
            </article>
            <%
		ArrayList<AdstoreReviewDTO> kkk = adreviewlist.getAdreviewList();
			%>
            <article class="review">
                <nav>
                    <h1 class="re_re" id="ree">상품평</h1>
                </nav>
                <ul>
                    <li class="re_per">
                     
                            <h5 class="ratingstar4">
                            <%
							out.println("<span class='product-name'>" + jjj.get(0).getItemName() + "</span>");
						%>
                            </h5>
                            <span class="re_id">
                            <%
									out.println("<span>" + kkk.get(0).getItemBuyer() + "</span>");
								%>
							2023-09-01</span>
                        </div>
                        <h3>가볍고 시원하고</h3>
                        <p class="re_text">
                            <%
									out.println("<span>" + kkk.get(0).getItemReviewText() + "</span>");
								%> </p>
                    </li>
                    <li class="re_per">
                        <div>
                            <h5 class="ratingstar4"> <%
							out.println("<span class='product-name'>" + jjj.get(0).getItemName() + "</span>");
						%></h5>
                            <span class="re_id"> <%
									out.println("<span>" + kkk.get(1).getItemBuyer() + "</span>");
								%> 2023-09-01</span>
                        </div>
                        <h3>나름 괜찮음...</h3>
                        <p class="re_text"> <%
									out.println("<span>" + kkk.get(1).getItemReviewText() + "</span>");
								%></p>
                    </li>
                    <li class="re_per">
                        <div>
                            <h5 class="ratingstar4"><%
							out.println("<span class='product-name'>" + jjj.get(0).getItemName() + "</span>");
						%></h5>
                            <span class="re_id"><%
									out.println("<span>" + kkk.get(2).getItemBuyer() + "</span>");
								%> 2023-09-01</span>
                        </div>
                        <h3>나이키 왜이래</h3>
                        <p class="re_text"><%
									out.println("<span>" + kkk.get(2).getItemReviewText() + "</span>");
								%> </p>
                    </li>
                    <li class="re_per">
                        <div>
                            <h5 class="ratingstar4"><%
							out.println("<span class='product-name'>" + jjj.get(0).getItemName() + "</span>");
						%></h5>
                            <span class="re_id"><%
									out.println("<span>" + kkk.get(3).getItemBuyer() + "</span>");
								%> 2023-08-30</span>
                        </div>
                        <h3>사이즈 참고하세요.</h3>
                        <p class="re_text"> <%
									out.println("<span>" + kkk.get(3).getItemReviewText() + "</span>");
								%> </p>
                    </li>
                    <li class="re_per">
                        <div>
                            <h5 class="ratingstar4"><%
							out.println("<span class='product-name'>" + jjj.get(0).getItemName() + "</span>");
						%></h5>
                            <span class="re_id"><%
									out.println("<span>" + kkk.get(4).getItemBuyer() + "</span>");
								%> 2023-08-30</span>
                        </div>
                        <h3>정사이즈로...</h3>
                        <p class="re_text"><%
									out.println("<span>" + kkk.get(4).getItemReviewText() + "</span>");
								%> </p>
                    </li>
                </ul>
            </article>
                <div class="paging">
                    <span class="prev">
                        <a href="#"> 이전</a>
                    </span>
                    <span class="num">
                        <a href="#" class="on">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <a href="#">5</a>
                        <a href="#">6</a>
                        <a href="#">7</a>
                    </span>
                    <span class="next">
                        <a href="#">다음 ></a>
                    </span>
                </div>
        <div class="cart_div">
            <a href="cart.html"><img src="img/cart.png" alt=""></a>
        </div>
</section>
     <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>