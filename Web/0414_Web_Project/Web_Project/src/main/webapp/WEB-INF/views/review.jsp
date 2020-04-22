<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function review_write_move() {
		location.href="review_write.do";
	}
</script>
</head>
<body>
	<%@ include file="menu_main.jsp"%>
	<c:choose>
		<c:when test="${login=='ok'}">
			<div class = "side_menu"><%@ include file="menu_side.jsp" %></div>
			<div class = "main_content">
		</c:when>
		<c:otherwise>
			<c:choose>
			<c:when test="${admin=='ok'}">
				<div class = "side_menu"><%@ include file="menu_side.jsp" %></div>
				<div class = "main_content">
			</c:when>			
		</c:choose>
			
		</c:otherwise>
	</c:choose>
	<h2>구매 리뷰 보기</h2>
	<table style = "text-align:center">
		<thead>
			<tr>
				<th>번호</th>
				<th>구매자</th>
				<th>평가</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty review_list}">
				<tr>
					<td colspan="5"><h3> 자료가 존재하지 않습니다.</h3> </td>
				</tr>
				</c:when>
				<c:otherwise>
				<c:forEach var="k" items="${review_list}" varStatus="vs">
					<tr>
						<td >${paging.totalRecord-((paging.nowPage-1)*paging.numPerPage+vs.index)}</td>
						<td >
							<c:forEach begin="1" end="${k.step}">
							     &nbsp;&nbsp;[RE]
							</c:forEach>
						<a href="review_detail.do?idx=${k.idx}&cPage=${paging.nowPage}">${k.cust_id}</a>
						
						</td>
						
						<!-- 구매평 별표로 표시하기  -->
						<c:choose>
							<c:when test= "${k.rank==5}">
								<td >★★★★★</td>
							</c:when>
							<c:when test= "${k.rank==4}">
								<td>★★★★☆</td>
							</c:when>
							<c:when test= "${k.rank==3}">
								<td >★★★☆☆</td>
							</c:when>
							<c:when test= "${k.rank==2}">
								<td >★★☆☆☆</td>
							</c:when>
							<c:when test= "${k.rank==1}">
								<td >★☆☆☆☆</td>
							</c:when>
						</c:choose>
						
						<td >${k.regdate.substring(0,10)}</td>
						<td>${k.hit}</td>
					</tr>
				</c:forEach>	
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<!-- 이전 -->
					<c:choose>
						<c:when test="${paging.beginBlock > paging.pagePerBlock }">
							<a href="review.do?cPage=${paging.beginBlock-paging.pagePerBlock}"> 
								<span style="background:#B2CCFF "><font size="4" >이전으로</font></span>&nbsp;&nbsp;&nbsp;&nbsp;	 
							</a>
						</c:when>
						<c:otherwise>
							<font size="4" style="color: gray;"><b>이전으로</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:otherwise>
					</c:choose>
					<!-- 페이지번호 -->
					<c:forEach begin="${paging.beginBlock}" end="${paging.endBlock}" step="1" var="k">
						<c:choose>
							<c:when test="${k==paging.nowPage }">
								<font size="4">${k}</font>&nbsp;&nbsp;
							</c:when>
							<c:otherwise>
								<span style="background:#B2CCFF "><a href="review.do?cPage=${k}"><font size="4">${k}</a></font></span>&nbsp;&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- 다음 -->
					<c:choose>
						<c:when test="${paging.endBlock < paging.totalPage }">
							<a href="review.do?cPage=${paging.beginBlock+paging.pagePerBlock}">
								<span style="background:#B2CCFF ">
									<font size="4" >다음으로</font>
								</span>&nbsp;&nbsp;&nbsp;&nbsp;
							</a>
						</c:when>
						<c:otherwise>
							<font size="4" style="color: gray;"><b>다음으로</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:otherwise>
					</c:choose>
				</td>
				<!-- <td><button onclick="review_write_move()"> 글쓰기</button></td> -->
			</tr>
		</tfoot>
	</table>
	<c:choose>
		<c:when test="${login=='ok'}">
			</div>
		</c:when>
		
	</c:choose>
</body>
</html>