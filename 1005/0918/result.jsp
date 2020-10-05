<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 되었습니다.</h1>
	<%-- 누구님으로 로그인 되었습니다. --%>
	<%=session.getAttribute("loginId") %> 로 로그인 되었습니다.
	<br>
	최근 등록한 상품
	<%request.setCharacterEncoding("utf-8");%>
	<br>
	<%=session.getAttribute("book") %>
	<br>
	<a href = "<%=request.getContextPath()%>/0918/book.jsp">도서등록</a>
</body>
</html>