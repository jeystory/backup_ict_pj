<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Event</title>
<link rel = "stylesheet" href="resources/css/sw_form.css">
<link rel = "stylesheet"  href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script> 
<script type="text/javascript">
	function go_back_event() {
		location.href  = "event.do"
	}
	
	function update_event() {
		location.href="update_event.do?idx=${evo.idx}"
	}
</script>

<style type="text/css">
	button, img{
		align : "center";
	}
	#event_img_detail{
		margin : 20px;
		padding : 20px;
		width : 800px;
		border : 2px solid lightcoral;
	}
	
	
</style>
</head>
<body>
 	 	
 	<div class="main_menu"><%@ include file="menu_main.jsp"%></div>	
 	
	
		
 	<div id = "event_img_detail">
 			<c:choose>		
			<c:when test="${admin=='ok'}">
			 	<p><button onclick = "update_event()">이벤트 수정</button></p>
			</c:when>
			</c:choose>
			<h3>${evo.title}</h3>
			<h3>${evo.content}</h3>
			<p><img src= "<c:url value='/resources/images/events/${evo.lg_img}'/>" ></p>
			<p><button onclick = "go_back_event()">목록</button></p>
			
		
	</div>
	<!-- <form>
		<fieldset>
			<legend>이벤트 목록</legend>
				<p><a href="event_Sub01.html"> 다음글 > 화이트데이 이벤트</a>  </p>
				<p><a href="event_Sub01.html"> 이전글 > 슈퍼히어로 이벤트</a> </p>
		</fieldset>		
	</form> -->
        		
	<%@ include file="bottom.jsp"%>
	
</body>
</html>