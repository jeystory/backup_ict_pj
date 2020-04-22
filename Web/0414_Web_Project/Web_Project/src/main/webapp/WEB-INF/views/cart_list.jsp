<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카트 보기</title>
<link rel = "stylesheet" href="resources/css/cust_tb.css">
<link rel = "stylesheet" href="resources/css/sw_form.css">
<link rel = "stylesheet"  href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script> 
</head>
<body>
	<%@ include file="menu_main.jsp"%>
	<div class="side_menu"><%@ include file="menu_side.jsp"%></div>
	<div class = "main_content">
	<hr>
	<h2>장바구니 목록</h2>
	<hr>
	
	<c:choose>
			  	<c:when test="${login=='ok'}">
			  	  	${mvo.id}님의 장바구니
			  	</c:when>
			  	<c:otherwise>
			  		  <a href="login.do">로그인</a>
			  	</c:otherwise>
		  	  </c:choose>
	<hr>
	
	
	<table id = "cart_item">
		<thead>
			<tr><th>상품이름</th><th>상품수량</th><th>제품가격</th><th>금액</th><th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				
			<c:when test = "${empty cart_list}">
					<tr><h3> 장바구니가 비어있습니다.</h3></tr>
				</c:when>
				<c:otherwise> 
					<c:forEach var="k" items="${cart_list}">
						<tr align="center">
							<td>${k.item_name}</td>
							<td>${k.item_price}</td>
							<td>
								<form action="edit_cart_quantity.do" method = "post">
									<input type="number" name= "item_amount" value = "${k.item_amount}" size = "1"/>
									<input type = "hidden" name= "item_id" value="${k.item_id}"/>
									<input type = "hidden" name = "cust_id" value="${k.cust_id}"/>
									<input type="submit" value="수정" />
								</form>
								
							</td>
							<td>
								<c:set var="total" value="${k.item_price * k.item_amount}" />
								${total}
							</td>
							<td>
								<button onclick="location.href ='delete_cart.do?cust_id=${k.cust_id}&item_id=${k.item_id}'">삭제</button>
							</td>
						</tr>
						<c:set var="cartTotal" value="${cartTotal = cartTotal+total}" />
					</c:forEach>
			</c:otherwise>	
			</c:choose>
		</tbody>
		<tfoot>
			<c:if test="${! empty cart_list}">
				<tr  >
					<td colspan="4" align="right">
						<h2> 총결재액 : 
							<fmt:formatNumber value="${cartTotal}" pattern="#,##0" />원  &nbsp;  &nbsp;</h2>
					</td>
					<td align="center">
						<button  onclick="location.href='cust_order.do?cust_id=${mvo.id}&total_price=${cartTotal}'">주문하기</button>
					</td> 
				</tr>
			</c:if>
		</tfoot>
		</table>
		
		</div>
		
	<div class="footer"><%@ include file="bottom.jsp" %></div>
	
	
</body>
</html>