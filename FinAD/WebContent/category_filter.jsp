<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String shorts = request.getParameter("shorts");
		String sub = request.getParameter("sub");
		String price = request.getParameter("price");
		String avg = request.getParameter("avg");
		String offer = request.getParameter("offer");
		String price_name = request.getParameter("price_name");
		
		if(shorts.equalsIgnoreCase("true")) {
			shorts = "true";
		} else if(shorts.equalsIgnoreCase("false")){
			shorts = "false";
		}
		
		if(sub.equalsIgnoreCase("under10")) {
			sub = "under10";
		} else if(sub.equalsIgnoreCase("over10")) {
			sub = "over10";
		} else if(sub.equalsIgnoreCase("over20")) {
			sub = "over20";
		} else if(sub.equalsIgnoreCase("over50")) {
			sub = "over50";
		} else if(sub.equalsIgnoreCase("over100")) {
			sub = "over100";
		}
		
		if(price.equalsIgnoreCase("min_price")) {
			price = "min_price";
		} else if(price.equalsIgnoreCase("max_price")) {
			price = "max_price";
		}
		
		if(avg.equalsIgnoreCase("min_avg")) {
			avg = "min_avg";
		} else if(avg.equalsIgnoreCase("max_avg")) {
			avg = "max_avg";
		}
		
		if(offer.equalsIgnoreCase("over1")) {
			offer = "over1";
		} else if(offer.equalsIgnoreCase("over10")) {
			offer = "over10";
		} else if(offer.equalsIgnoreCase("over50")) {
			offer = "over50";
		} else if(offer.equalsIgnoreCase("over99")) {
			offer="over99";
		}
	%>

</body>
</html>