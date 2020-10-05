<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.js"></script>
</head>
<body>
	<%--scriptlet: java code 삽입 --%>
	<%
	    String root = request.getContextPath();
	%>
	<h1>로그인 해주세요</h1>
	<form method="post" action="<%=root%>/login2" id="loginForm">
		<input type="text" id="id" name="id">
		<br>
		<input type="password" id="pass" name="pass">
		<br>
		<input type="submit">
	</form>
</body>
<script>
	$("#loginForm").validate({
		rules : {
			// id, pass 이런 녀석들은 id 값이 아닌 name 값
			id : {
				required : true,
				minlength : 4
			},
			pass : {
				required : true
			}
		},
		messages : {
			id : {
				required : "아이디는 필수 입력",
				minlength : "길이는 최소 4글자 이상"
			},
			pass : {
				required : "비번은 필수 입력"
			}
		}
	});
	/* $("#loginForm").on("submit", function(e){
		if(!validation()){
			e.preventDefault();
		}
	})
	
	function validation(){
		return $("#id").val() && $("#pass").val();
	} */
</script>
</html>