<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보</title>
<link rel = "stylesheet" href="resources/css/cust_tb.css">
<link rel = "stylesheet" href="resources/css/sw_form.css">
<link rel = "stylesheet" href="resources/css/sw_layout.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script> 
<script type="text/javascript">
	
	function ch_pwd() {
		/*  URL , name, ,*/
		var myWindow = window.open("cust_pwd_change.jsp", "", "width=400,height=300");	
	}
</script> 
<style type="text/css">
	*{margin: 0 0;}	
	legend{
		text-align: center;
		padding : 10px;
	}
	
	fieldset{
		padding : 10px;
	}

	select{ width : 200px;}
</style>
</head>
<body>
	<%@ include file="menu_main.jsp"%>
	<div class="side_menu"><%@ include file="menu_side.jsp"%></div>
	<div class = "main_content">
		<form>
			<fieldset>
				<legend>회원정보 변경</legend>
				<p> 이름 : <input type="text" name="name" placeholder ="사용자이름" disabled> </p>
				<p> 아이디 : <input type="text" name="id"  placeholder ="사용자ID" disabled> </p>
				<p>비밀번호 <button type="button" onclick="ch_pwd()">변경하기</button></p>
				<p>전화번호 : <input type="tel" name = "user_tel"></p>
				<p>
			 		이메일 : 
			 		<input type="text" name="email_id"  placeholder = "email_ID" style ="width: 200px" >@
			 		<input type="text" name="email_com" placeholder = email.com  style ="width: 250px">
			 		<select>
  						<option value="direct">직접입력: </option>
    					<option value="naver">naver.com</option>
    					<option value="gmail">gmail.com </option>
    					<option value="daum">daum.net </option>
  					</select> 
				 </p>
				<p> 주소 <br> 우편번호 <input type="text"  id="inputZip"> 
				<input type="text" name="addr" placeholder="OO시 OO구 OOO동  OOO길 OO번지" ></p>
				<p><button type="button" onclick="">변경</button><button type="button" onclick="">취소</button></p>
			</fieldset>
		</form>
		</div>
	<div class="footer"><%@ include file="bottom.jsp" %></div>	

</body>
</html>