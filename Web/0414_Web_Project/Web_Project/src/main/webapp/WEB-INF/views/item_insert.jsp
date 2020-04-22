<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Event</title>
<link rel="stylesheet" href="resources/css/sw_form.css">
<link rel="stylesheet" href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

	function insert_item(f) {
			f.action= "insert_item.do";
			f.submit();
	}
</script>

<style type="text/css">
.container {
	/* width: 500px;
		margin: 0 auto; */
	width: 90%;
	margin: 10;
}



select {width: 90%;}
</style>
</head>
<body>
	<%@ include file="menu_main.jsp"%>
	<%-- <div class="user_content"><%@ include file="menu_admin.jsp"%></div> --%>
	<div class="side_menu"><%@ include file="menu_side.jsp"%></div>
	<div class = "main_content">
		
				<form method="post" enctype="multipart/form-data">
					<table>
						<thead></thead>
						<tbody></tbody>
					
						<tr>
							<td>제품분류:</td>
							<td colspan="2"><select id="item_category" name = "item_category" >
									<option value="1">Snack</option>
									<option value="2">Bread</option>
									<option value="3">Dessert</option>
								
							</select></td>
						</tr>
						<tr>
							<td>제품이름 :</td>
							<td colspan="2"><input type="text" name="item_name"
								style="width: 300px; height: 30px;" /></td>
						</tr>
						<tr>
							<td>제품소개:</td>
							<td colspan="2"><input type="text" name="item_spec"
								style="width: 300px; height: 30px;" /></td>
						</tr>
						<tr>
							<td>제품가격:</td>
							<td colspan="2"><input type="number" name="item_price"
								style="width: 300px; height: 30px;" /></td>
						</tr>
						<tr>
							<td>총내용량:</td>
							<td colspan="2"><input type="text" name="item_cal"
								style="width: 300px; height: 30px;" /></td>
						</tr>
						<tr>
							<td>구성성분:</td>
							<td colspan="2"><input type="text" name="item_content"
								style="width: 300px; height: 30px;" /></td>
						</tr>
						<tr>
							<td>알레르기:</td>
							<td colspan="2"><input type="text" name="item_aller"
								style="width: 300px; height: 30px;" /></td>
						</tr>
						<tr>
							<td>이미지 파일 위치:</td>
							<td colspan = "2"><input type="file" name="file"></td>
						</tr>
								
						
					<tr>
							<td colspan ="3" align="center">
								<button type="button" value="입력" onclick="insert_item(this.form)">입력</button>
								<button type="reset">취소</button>
							</td>
						</tr>
						<tfoot></tfoot>
					</table>
				</form>
			
			</div>
	<div class="footer"><%@ include file="bottom.jsp"%></div>
</body>
</html>