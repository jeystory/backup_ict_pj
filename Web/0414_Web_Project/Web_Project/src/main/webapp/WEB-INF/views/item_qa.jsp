<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu_main.jsp" %>
	<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>Q/A 제목</th>
			<th>작성자</th>
			<th>작성날짜</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td  class = "txtNo">1</td>
			<td> Q/A 제목 1</td>
			<td> 작성자 1</td>
			<td>2020.01.20</td>
		</tr>
		<tr>
			<td  class = "txtNo">2</td>
			<td> Q/A 제목2</td>
			<td> 작성자 2</td>
			<td>2020.01.01</td>
		</tr>
		<tr>
			<td class = "txtNo"> 1 </td>
			<td> -> RE : Q/A 제목 3</td>
			<td> 작성자 3</td>
			<td>2020.01.01</td>
		</tr>
	</tbody>
	<tfoot>
    	<tr ><td  colspan = "4">[1][2][3]</td></tr>
  	</tfoot>	
</table>
	<div class="footer"><%@ include file="bottom.jsp"%></div>
</body>
</html>