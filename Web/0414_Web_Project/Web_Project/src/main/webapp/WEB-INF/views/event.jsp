<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event</title>
<link rel="stylesheet" href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<style type="text/css">
.event_title {
	width: 100%;
	margin: 10px 0 3px 0;
	text-align: center;
	font-size: 14px;
	color: black;
}

.event_date {
	width: 100%;
	margin: 0 0 10px 0;
	text-align: center;
	font-size: 12px;
	color: black;
}

ul {
	list-style-type: none;
	background-color: white;
	float: auto;
}

li {
	display: inline-block;
}
</style>
</head>
<body>

	<%@ include file="menu_main.jsp"%>
	<hr>

	<div align="center">
		<ul>
			<c:forEach var="k" items="${evlist}" varStatus="vs">
				
				<li><a href="event_sub.do?idx=${k.idx}"> <img
					src="resources/images/events/${k.sm_img}">
					<div class="event_title">${k.title}</div>
					<div class="event_date">${k.s_date.substring(0,10)} ~${k.e_date.substring(0,10)} </div>
				</a></li>
				
				<c:if test="${vs.count %3== 0 }">	
					<hr> 
					
				</c:if>
				
			</c:forEach>
		</ul>

	
	<%@ include file="bottom.jsp"%>
	
</body>
</html>