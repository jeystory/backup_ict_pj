<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매자 주문 정보</title>

</head>
<body>

	<c:choose>
		<c:when test="${login=='ok'}">
		</c:when>
		<c:otherwise>
			<a href="login.do">로그인</a>
		</c:otherwise>
	</c:choose>
	<hr>

	<table id="order_list">
		<thead>
			<tr>
				<th>구매번호</th>
				<th>주문일</th>
				<th>총구매액</th>
				<th>진행상태</th>

			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty order_list}">
					<tr>
						<h3>구매 목록이 없습니다.</h3>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="k" items="${order_list}">
						<tr align="center">
							<td><a
								href="order_detail.do?cust_id=${k.cust_id}&order_id=${k.order_id}">${k.order_id}</a></td>
							<td>${k.order_date.substring(0,10)}</td>	<!-- 구매날짜 -->
							<td>${k.total_price}</td> <!-- 총구매액 -->
							<td>
								<c:choose>
									<c:when test="${k.order_status=='1'}">결제완료</c:when>
									<c:when test="${k.order_status=='2'}">상품준비중</c:when>
									<c:when test="${k.order_status=='3'}">배송중</c:when>
									<c:when test="${k.order_status=='4'}">배송완료</c:when>
									<c:when test="${k.order_status=='5'}">구매완료</c:when>	
									<c:otherwise>반품</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>


		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">[1]</td>
			</tr>
		</tfoot>

	</table>

</body>
</html>