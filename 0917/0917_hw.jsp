<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>상품을 등록 해 주세요.</h1>
	<form method="post" action="/backend/info" id="productForm">
		상품명 : <input type="text" id="name" name="name"><br>
		상품 가격 : <input type="text" id="price" name="price"><br>
		상품 설명 : <input type="text" id="info" name="info"><br>
		<input type="submit">
		<input type="reset">
	</form>
</body>
</html>