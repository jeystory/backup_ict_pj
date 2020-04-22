<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Event</title>
<link rel = "stylesheet" href="resources/css/sw_form.css">
<link rel = "stylesheet" type="text/css" href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script> 

<style type="text/css">
	*{margin: 0 0;}	
</style>

<script type="text/javascript">
function insert_event(f) {
	f.action= "insert_event.do";
	f.submit();
}
</script>
</head>

<body>
	<%@ include file="menu_main.jsp"%>
	<div class="side_menu"><%@ include file="menu_side.jsp"%></div></div>
	<div class = "main_content">
			<form method="post" enctype="multipart/form-data">
					<table>
						<thead></thead>
						<tbody></tbody>
						<tr><th colspan ="3">이벤트 추가</th></tr>
						<tr>
							<td>이벤트 이름 :</td>
							<td colspan="2"><input type="text" name="title"
								style="width: 300px; height: 30px;" /></td>
						</tr>
						<tr>
							<td>이벤트 내용 :</td>
							<td colspan="2"><input type="text" name=" content"
								style="width: 300px; height: 100px;" /></td>
						</tr>
						<tr>
							<td>이벤트 기간:</td>
							<td colspan="2">
								<input type="date" name="s_date"> 
								<input type="date" name="e_date">
							</td>
						</tr>
						
						<tr>
							<td>이미지(main):</td>
							<td colspan = "2"><input type="file" name="sm_file"/></td>
							
						</tr>
						<tr>
							<td>이미지(detail) :</td>
							<td colspan = "2"><input type="file" name="lg_file" /></td>
							
						</tr>
						<tr>
							<td colspan="3" align="center">
								<button type="button" value="저장" onclick="insert_event(this.form)">저장</button>
								<button type="reset" >취소</button></td>
						</tr>
						<tfoot></tfoot>
					</table>
		      	</form>
			
	</div>

	
	<div class="footer"><%@ include file="bottom.jsp"%></div>
</body>
</html></html>