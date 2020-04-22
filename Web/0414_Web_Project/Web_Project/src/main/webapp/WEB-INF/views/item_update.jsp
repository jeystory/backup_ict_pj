<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Event</title>
<!-- <link rel="stylesheet" href="resources/css/sw_form.css"> -->
<link rel="stylesheet" href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	
	function update_item(f) {
			f.action= "update_item.do";
			f.submit();
	}
</script>

<style type="text/css">
/* .container {
	width: 500px;
		margin: 0 auto;
	width: 90%;
	margin: 10;
} */

select {
	width: 90%;
}
</style>
</head>
<body>
	<%@ include file="menu_main.jsp"%>
	<div class="side_menu"><%@ include file="menu_side.jsp"%></div>
	<div class="main_content">
		<form method="post" enctype="multipart/form-data">
			<table>
				<thead></thead>
				<tbody></tbody>
				<input type="hidden" name="idx" value="${ivo.idx}" /></td>
			
				<tr>
					<td>제품분류:</td>
					<td colspan="2"><select id="item_category" name="item_category">
							<option value="1">Snack</option>
							<option value="2">Bread</option>
							<option value="3">Dessert</option>

					</select></td>
				</tr>
				<tr>
					<td>제품이름 :</td>
					<td colspan="2"><input type="text" name="item_name"
						value="${ivo.item_name}" /></td>
				</tr>
				<tr>
					<td>제품소개:</td>
					<td colspan="2"><input type="text" name="item_spec"
						value="${ivo.item_spec}" /></td>
				</tr>
				<tr>
					<td>제품가격:</td>
					<td colspan="2"><input type="number" name="item_price" value="${ivo.item_price }"
						style="width: 300px; height: 30px;" /></td>
				</tr>
				<tr>
					<td>총내용량:</td>
					<td colspan="2"><input type="text" name="item_cal" value="${ivo.item_cal }" /></td>
				</tr>
				<tr>
					<td>구성성분:</td>
					<td colspan="2"><input type="text" name="item_content" value="${ivo.item_content }" /></td>
				</tr>
				<tr>
					<td>알레르기:</td> 
					<td colspan="2"><input type="text" name="item_aller" value="${ivo.item_aller }" /></td>
				</tr>
				<tr>
					<td>이미지 파일 위치:</td>
					<td colspan="2"><input type="file" name="file">${ivo.file_name}</td>
				</tr>


				<tr>
					<td colspan="3" align="center">
						<button type="button" value="입력" onclick="update_item(this.form)">입력</button>
						<button type="reset">취소</button>
					</td>
				</tr>
				<tfoot></tfoot>
			</table>
		</form>

	</div>

	<%@ include file="bottom.jsp"%>
</body>
</html>