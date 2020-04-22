<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 자세히 보기</title>
<script type="text/javascript">
	function review_list_go(f) {
		f.action="review.do";
		f.submit();
	}
	function review_ans_write(f) {
		f.action="review_ans_write.do";
		f.submit();
	}
	function review_update_go(f) {
		f.action="review_update.do";
		f.submit();
	}
	function review_delete_go(f) {
		
		if (confirm("정말 삭제하시겠습니까??") == true){    //확인
			f.action="review_delete.do";
			f.submit();
		}else{   //취소
		    return;
		}		
	}
</script>
</head>
<body>
	<%@ include file="menu_main.jsp"%>
	<c:choose>
		<c:when test= "${login=='ok' }">
		<div class="side_menu"><%@ include file="menu_side.jsp"%></div>
		<div class="main_content">
		</c:when>
	</c:choose>
	
	<h2> review 상세보기 </h2>
	<form method="post">
	<table>
		<tbody>
			<tr>
				<th bgcolor="#B2EBF4">작성자</th>
				<td>${rvo.cust_id} </td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">구매제품</th>
				<td> ${rvo.item_name }</td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">평점</th>
				<!-- 구매평 별표로 표시하기  -->
					<c:choose>
						<c:when test="${rvo.rank==5}">
							<td>★★★★★</td>
						</c:when>
						<c:when test="${rvo.rank==4}">
							<td>★★★★☆</td>
						</c:when>
						<c:when test="${rvo.rank==3}">
							<td>★★★☆☆</td>
						</c:when>
						<c:when test="${rvo.rank==2}">
							<td>★★☆☆☆</td>
						</c:when>
						<c:when test="${rvo.rank==1}">
							<td>★☆☆☆☆</td>
						</c:when>
					</c:choose>

			</tr>
			<tr>
				<th bgcolor="#B2EBF4">작성일</th>
				<td>${rvo.regdate.substring(0,10)} </td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">첨부파일</th>
				<td>
					<c:choose>
						<c:when test="${empty rvo.file_name}">
							<b> 첨부파일 없음 </b>
						</c:when>
						<c:otherwise>
							<img  src="<c:url value='resources/images/reviews/${rvo.file_name}'/>" width="150px"><br>
							<a href="download.do?file_name=${rvo.file_name}"> ${rvo.file_name}</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">내용</th>
				<td style="text-align: left; padding-left:50px;"><pre>${rvo.review}</pre></td>
			</tr>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test= "${login=='ok' }">
							<c:choose>
								<c:when test="${admin=='ok'}">
			       		 			<!-- <input type="button" value="목록" onclick="review_list_go(this.form)" /> -->
			        				<input type="button" value="답글" onclick="review_ans_write(this.form)" />
			        				<input type="button" value="수정" onclick="review_update_go(this.form)" />
			        				<input type="button" value="삭제" onclick="review_delete_go(this.form)" />
			     					<%-- <input type="hidden" value="${cPage}" name="cPage" /> --%>
								</c:when>
								<c:when test="${mvo.id == rvo.cust_id}">
									<input type="button" value="수정" onclick="review_update_go(this.form)" />
			        				<input type="button" value="삭제" onclick="review_delete_go(this.form)" />
								</c:when>
							</c:choose>
						</c:when>
						
						
				
					</c:choose>
				
					<input type="button" value="목록" onclick="review_list_go(this.form)" />
					<input type="hidden" value="${cPage}" name="cPage" />
					<input type="hidden" value="${rvo.idx}" name="idx"/>
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
	<c:choose>
		<c:when test= "${login=='ok' }">
			</div>
		</c:when>
	</c:choose>
</body>
</html>