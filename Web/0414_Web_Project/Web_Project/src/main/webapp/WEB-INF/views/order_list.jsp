<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 주문 배송 정보 보기</title>
<link rel = "stylesheet" href="resources/css/cust_tb.css">
<link rel = "stylesheet" href="resources/css/sw_form.css">
<link rel = "stylesheet"  href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script> 
</head>
<body>
	<%@ include file="menu_main.jsp"%>
	<div class="side_menu"><%@ include file="menu_side.jsp"%></div>
	<hr>
	
	<div class="main_content">
		<h2>${mvo.id} 주문 배송 조회</h2>
	
		<c:choose>
			<c:when test="${admin=='ok'}">
				<%@ include file="order_admin.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="order_cust.jsp"%>	
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="footer"><%@ include file="bottom.jsp" %></div>
</body>
</html>