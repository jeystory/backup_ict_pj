<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	
	<%@ include file="menu_main.jsp" %>
	<br>
	
	<h3>공지사항 게시판</h3>
	<hr>
	<table id = "board_notice">
		<thead>
			<tr>
				<th>번호</th>
				<th>공지사항 제목</th>
				<th>작성시간</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td  class = "txtNo">1</td>
				<td> 공지사항 제목 1</td>
				<td>2020.01.20</td>
			</tr>
			<tr>
				<td  class = "txtNo">2</td>
				<td>공지사항제목2</td>
				<td>2020.01.01</td>
			</tr>
			<tr>
				<td class = "txtNo">3</td>
				<td>공지사항제목3</td>
				<td>2020.01.01</td>
			</tr>
		</tbody>
		<tfoot>
    		<tr ><td  colspan = "3">[1][2][3]</td></tr>
  		</tfoot>
	</table>
	<div class="footer"><%@ include file="bottom.jsp"%></div>
</body>
</html>