<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel = "stylesheet" href="resources/css/sw_form.css">
</head>
<body>
	<!-- windows 화면 사이즈 조정 . 폼도 사이즈 조정 -->
	<form>
		<fieldset>
			<legend>비밀번호 변경</legend>
			<p>현재 비밀번호 :  <input type="password" name="pwd_old" placeholder="현재 비밀번호" ></p>
			<p>새로운 비밀번호 : <input type="password" name="pwd_new1" placeholder="새로운 비밀번호"></p>
			<p>새로운 비밀번호 : <input type="password" name="pwd_new2" placeholder="새로운 비밀번호 다시 입력"></p>
			<p><button type="button" onclick="">변경</button>&nbsp;&nbsp;&nbsp;<button type="button" onclick="">취소</button></p>
		</fieldset>
	</form>
	
</body>
</html>