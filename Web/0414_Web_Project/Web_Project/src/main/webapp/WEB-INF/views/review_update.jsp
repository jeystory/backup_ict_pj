<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매후기 수정</title>
<script type="text/javascript">
	function sendData(f) {
		f.action ="review_update_ok.do";
		f.submit();
	}
	
	function list_go(f) {
		f.action="review.do";
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
						<c:choose>
							<c:when test ="${rvo.rank == '1'}">
								<option value="1" selected>★☆☆☆☆</option>
								<option value="2">★★☆☆☆</option>
								<option value="3">★★★☆☆</option>
								<option value="4">★★★★☆</option>
								<option value="5">★★★★★</option>	
							</c:when>
						
							<c:when test ="${rvo.rank == '2'}">
								<option value="1" >★☆☆☆☆</option>
								<option value="2" selected>★★☆☆☆</option>
								<option value="3">★★★☆☆</option>
								<option value="4">★★★★☆</option>
								<option value="5">★★★★★</option>	
							</c:when>
							
							<c:when test ="${rvo.rank == '3'}">
								<option value="1" >★☆☆☆☆</option>
								<option value="2">★★☆☆☆</option>
								<option value="3" selected>★★★☆☆</option>
								<option value="4">★★★★☆</option>
								<option value="5">★★★★★</option>	
							</c:when>
							
							<c:when test ="${rvo.rank == '4'}">
								<option value="1" >★☆☆☆☆</option>
								<option value="2">★★☆☆☆</option>
								<option value="3">★★★☆☆</option>
								<option value="4" selected>★★★★☆</option>
								<option value="5">★★★★★</option>	
							</c:when>
							
							<c:when test ="${rvo.rank == '5'}">
								<option value="1" >★☆☆☆☆</option>
								<option value="2">★★☆☆☆</option>
								<option value="3">★★★☆☆</option>
								<option value="4">★★★★☆</option>
								<option value="5" selected>★★★★★</option>	
							</c:when>
						</c:choose>
						
					</select>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<c:choose>
					<c:when test="${empty rvo.file_name}">
						<td> 
							<h3> 첨부파일없음</h3>
							<input type="file" name="file" />
						</td>
					</c:when>
					<c:otherwise>
						<td>
							<input type="file" name="file" /> ${rvo.file_name}
						</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th>리뷰쓰기</th>
				<td align="left"><textarea rows="10" cols="60" name="review">${rvo.review}</textarea>
			</tr>
			
			<tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="idx" value="${rvo.idx}" />
				<input type="hidden" name="cPage" value="${cPage}" />
				
				<input type="button" value="수정" onclick="sendData(this.form)" /> 
				<input type="button" value="목록" onclick="list_go(this.form)" />
				<input type="reset" value="취소" />
				</td>
			</tr>
            </tbody>
		</table>
	</form>
</div>
</body>
</html>