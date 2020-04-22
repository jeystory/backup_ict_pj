<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글</title>
</style>
<script type="text/javascript">
	function sendData(f) {
		/* for (var i = 0; i < f.elements.length; i++) {
			if ( f.elements[i].value == "") {
				if (i == 3)
					continue;
				alert(f.elements[i].name + "를 입력하세요");
				f.elements[i].focus();
				return;//수행 중단
			}
		} */
		f.action ="review_ans_write_ok.do";
		f.submit();
	}
	function view_go(f) {
		f.action ="review.do?idx=${rvo.idx}";
		f.submit();
	}
</script>
</head>
<body>
	<%@ include file="menu_main.jsp"%>

	<h2> 리뷰 댓글쓰기 </h2>	
	<form  method="post" enctype="multipart/form-data">
		<table width="700">
		<tbody>
			<tr>
				<th>리뷰쓰기</th>
				<td align="left"><input type="text" name="review"></td>
			</tr>
			<tr>
				<th>평점</th>
				<td align="left"> <input type="text" name="rank"></td>
			</tr>
			<tr>
				<th>고객</th>
				<td align="left"><input type="text" name="cust_id"></td>
			</tr>
			<tr>
				<th>제품</th>
				<td align="left"> <input type="text" name="item_id"></td>
			</tr>
				<th>첨부파일</th>
				<td align="left"><input type="file" name="file"></td>
			</tr>
			
			<tr>
				<td colspan="2">
				<input type="button" value="댓글입력" onclick="sendData(this.form)" />
				<input type="button" value="되돌아가기" onclick="view_go(this.form)" />
				<input type="reset" value="취소" />
				<%-- 댓글 처리를 위해서 groups, step, lev를 가지고 가야 한다. --%>
				<input type="hidden" name="groups" value="${rvo.groups }">
				<input type="hidden" name="step" value="${rvo.step }"> 
				<input type="hidden" name="lev"  value="${rvo.lev }"> 
				<input type="hidden" name="cPage" value="${cPage}">  
				</td>
			</tr>
            </tbody>
		</table>
	</form>
</body>
</html>