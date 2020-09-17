<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>제품의 정보</h1>
	제품명: <%=session.getAttribute("name") %><br>
	가격: <%=session.getAttribute("price") %><br>
	정보: <%=session.getAttribute("info") %>
</body>
</html>