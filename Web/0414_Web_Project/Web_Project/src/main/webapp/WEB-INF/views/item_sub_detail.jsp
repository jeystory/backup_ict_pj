<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴</title>
<link rel="stylesheet" href="resources/css/cust_tb.css">
<link rel="stylesheet" href="resources/css/sw_form.css">
<link rel="stylesheet" href="resources/css/sw_layout.css">

<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function add_cart() {
	if(${login=='ok'}){
		location.href="add_cart.do?cust_id=${mvo.id}&idx=${ivo.idx}";
		
	}else{
		alert("로그인하세요");
		location.href="login.do";
	}
}

function update_item() {
	location.href="update_item.do?idx=${ivo.idx}"
}

</script>
<style type="text/css">
* {
	line-height: 1.6;
	margin: 0;
	padding: 0;
}


/*the container must be positioned relative:*/
.custom-select {
	position: relative;
	width: 200px;
}
</style>


</head>
<body>

	<%@ include file="menu_main.jsp"%>

	<hr>

	<table>
		<tr>
			<th colspan="3">${ivo.item_name }</th>
		<tr>
		<tr>
			<td rowspan="3">
				
				<img src="<c:url value='/resources/images/items/${ivo.file_name}'/>"
				width="200px">
			</td>
			<td colspan="2">${ivo.item_spec}</td>
		</tr>

		<tr>
			<td colspan=2>${ivo.item_price}</td>
		</tr>
		<tr>
			<td>
				<div class="custom-select" style="">
					구매 개수 : <select>
						<option value="1">1개</option>
						<option value="2">2개</option>
						<option value="3">3개</option>
						<option value="4">4개</option>
						<option value="5">5개</option>
						<option value="6">6개</option>
					</select>
				</div>
			</td>
			<td>
			<input type = "hidden" name = "idx" value="${ivo.idx}">
			<c:choose>		
			<c:when test="${admin=='ok'}">
			 	<p><button onclick = "update_item()"> 제품 수정</button></p>
			</c:when>
			<c:otherwise><button onclick="add_cart()">구매하기</button></c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>

	<hr>

	<table>

		<tr>
			<td>총열량</td>
			<td>${ivo.item_cal}</td>
		</tr>
		<tr>
			<td>구성요소</td>
			<td>${ivo.item_content}</td>
		</tr>
		<tr>

			<td>알레르기 유발요인</td>
			<td>${ivo.item_aller}</td>
		</tr>
	</table>



	<div class="footer"><%@ include file="bottom.jsp"%></div>
</body>
</html>
</html>