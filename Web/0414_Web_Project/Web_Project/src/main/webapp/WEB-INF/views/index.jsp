<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/rolling.css">

<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/js/rolling.js"></script>
<style type="text/css">

 ul li {
	list-style: none;
	float: left;
} 



h2 {text-align: center;}

</style>

</head>
<body>
  <div class="main_menu"><%@ include file="menu_main.jsp" %></div>
<br>
	<br>

 <h2>Sweet Forest 베스트</h2>
	<div class="rolling_wrap">
		<a href="" class="content"><img src="resources/images/items/snack01.jpg"></a>
			<a href="" class="content"><img src="resources/images/items/bread01.jpg"></a>
			<a href="" class="content"><img src="resources/images/items/dessert01.jpg"></a>
			<a href="" class="content"><img src="resources/images/items/snack01.jpg"></a>
			<a href="" class="content"><img src="resources/images/items/bread01.jpg"></a>
			<a href="" class="content"><img src="resources/images/items/dessert01.jpg"></a>
			<a href="" class="content"><img src="resources/images/items/snack01.jpg"></a>
	</div>
	
	<br>
	<hr>
	<br>
	
	
	<table style="text-align: center; margin: 0 auto;">
		<thead><h2>Sweet Forest 이벤트</h2></thead>
		<tbody>
			<tr>
				<td><a href="#"><img src="resources/images/events/event_01.jpg"></a><td>
				<td><a href="#"><img src="resources/images/events/event_02.jpg"></a></td>
				<td><a href="#"><img src="resources/images/events/event_03.jpg"></a></td>
				<td><a href="#"><img src="resources/images/events/event_04.jpg"></a></td>
			<tr>
		</tbody>
	</table>
	
	
	<br>
	<div class="footer"><%@ include file="bottom.jsp" %></div>
</body>
</html>