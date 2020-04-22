<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매자 리뷰 쓰기</title>
<script type="text/javascript">
	function sendData(f) {
		f.action ="review_write_ok.do";
		f.submit();
	}
</script>
</head>
<body>
	<%@ include file="menu_main.jsp"%>
	<div class="side_menu"><%@ include file="menu_side.jsp"%></div>
	<hr>
	
	<div class="main_content">
		<h2>구매자 리뷰 쓰기 </h2>	
	<form  method="post" enctype="multipart/form-data">
		<table width="700">
		<tbody>
			<tr>
				<th>평점</th>
				<td align="left"> 
					<select id="rank" name = "rank" >
						<option value="1">★☆☆☆☆</option>
						<option value="2">★★☆☆☆</option>
						<option value="3">★★★☆☆</option>
						<option value="4">★★★★☆</option>
						<option value="5">★★★★★</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td align="left"><input type="file" name="file"></td>
			</tr>
			<tr>
				<th>리뷰쓰기</th>
				<td align="left"><input type="text" name="review"></td>
			</tr>
			
			<tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="cust_id" value=${cust_id}>
				<input type="hidden" name="item_id" value=${item_id}>
				<input type="hidden" name="item_name" value=${item_name}>
				<input type="hidden" name="order_detail_id" value=${order_detail_id}>
				<input type="button" value="입력" onclick="sendData(this.form)" /> 
				<input type="reset" value="취소" />
				</td>
			</tr>
            </tbody>
		</table>
	</form>
</div>
</body>
</html>