<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/sw_layout.css">

</head>
<body>
	<c:choose>
			<c:when test="${admin=='ok'}">
				<!-- <a href="admin_order.do" >주문배송처리</a> -->
				 <a href="order_list.do?cust_id=${mvo.id}" >주문배송처리</a>
  				<a href="review.do">구매후기</a>
  				<!-- <a href="item_qa.do">Q/A</a> -->
  				<a href="insert_item.do">메뉴 추가</a>
  				<a href="insert_event.do">이벤트 추가</a>
			</c:when>
			<c:otherwise>	 <!-- 관리자가 아닌 일반 사용자인 경우  -->
			<%-- 	<a href="cust_order_list.do?cust_id=${mvo.id}" >주문 배송 조회</a>	 --%>
				<a href="order_list.do?cust_id=${mvo.id}" >주문 배송 조회</a>
  				<a href="review.do">구매후기</a>
  				<!-- <a href="*.do">Q/A</a> -->
  				<a href="cust_info.do">회원정보수정</a>
			</c:otherwise> 
		</c:choose>	
</body>
</html>