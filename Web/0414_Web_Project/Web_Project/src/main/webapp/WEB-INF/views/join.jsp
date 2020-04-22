<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
/* 	div{text-align: center; margin : 100px auto;}
	table{
		width : 500px;
		margin : 0 auto;
	}
	
	table, th, td{
		border : 5px solid lightgray;
		border-collapse: collapse;
	}
	
	fieldset{width : 300px; margin: 0 auto;} */
	table{
		margin: 10px auto;
		width: 300px;
		border-collapse: collapse;
		font-size: 15pt;
	}
	table, th, td{
		border: 2px solid lightgray;
		text-align: center;
	}
	
</style>

<script type="text/javascript">
//유효성 검사 해야 됨
	function join_ok(f) {
		f.action = "join_ok.do";
		f.submit();
	}
	
	function search_addr(f) {
		f.action = "addr_search.do";
		f.submit();
		
	}
	
	
</script>
</head>
<body>
	 <%@ include file="menu_main.jsp"%>
	<div>
		<form method = "post">
			<fieldset>
				<legend>Join member</legend>
				<table>
					<tbody>
						
						<tr>
							<th>아이디 </th>
							<td colspan = "2"><input type="text", name="id" size=50></td>
						</tr>
						<tr>
							<th>패스워드 </th>
							<td colspan = "2"><input type="password", name="pwd" size=50></td>
						</tr>
						<tr>
							<th>패스워드 확인 </th>
							<td colspan = "2"><input type="password", name="pwd2" size=50></td>
						</tr>
						<tr>
							<th> 이름 </th>
							<td colspan = "2"><input type="text", name="name" size=50></td>
						</tr>
				
						<tr>
							<th> 주소 </th>
							<td><input type="text", name="addr" size=50></td>
							<td><input type= "button" value="검색" onclick="search_addr(this.form)"></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan = "3"><input type="button" value="가입" onclick="join_ok(this.form)"></td>
						</tr>
					</tfoot>
				</table>
			</fieldset>
		</form>
	</div>

</body>
</html>