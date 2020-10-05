<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.required {
	color: orange;
}

.title {
	display: inline-block;
	width: 100px;
	margin: 5px 0px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.js"></script>
</head>
<body>
	<h1>도서 등록 화면</h1>
	<form method="post" action="<%=request.getContextPath()%>/regist" id="myform">
		<ul>
			<li>
				<label class="required title">도서번호: </label>
				<input type="text" id="isbn1" name="isbn1">
				-
				<input type="text" id="isbn2" name="isbn2">
				-
				<input type="text" id="isbn3" name="isbn3">
			<li>
				<label class="required title">도서제목: </label>
				<input type="text" id="title" name="title" />
			<li>
				<label class="required title">도서 종류: </label>
				<select id="catalogue" name="catalogue">
					<option value="programming">프로그래밍
					<option value="novel">소설
					<option value="comic">만화
				</select>
			<li>
				<label class="title">출판국가: </label>
				<input type="radio" value="in" name="nation" id="in">
				<label for="in">국내도서</label>
				<input type="radio" value="out" name="nation" id="out">
				<label for="out">외국도서</label>
			<li>
				<label class="title">출판일: </label>
				<input type="date" name="pubdate" id="pubdate">
			<li>
				<label class="title">출판사: </label>
				<select id="publisher" name="publisher">
					<option value="ssafy">싸피 사무국
					<option value="hanbit">한빛미디어
					<option value="cyber">사이버출판사
				</select>
			<li>
				<label class="required title">저자: </label>
				<input type="text" name="author" id="author">
			<li>
				<label class="title">도서가격:</label>
				<input type="number" id="price" name="price">
				<select id="unit" name="currency">
					<option value="￦">원
					<option value="$">달러
					<option value="¥">위안
				</select>
			<li>
				<label class="title">요약내용: </label>
				<textarea rows="3" cols="100" id="description" name="description"></textarea>
		</ul>
		<input type="submit" value="도서등록">
		<input type="reset" value="취소">
	</form>
</body>
<script>
	$("#myform").validate({
		rules : {
			isbn1 : {
				required : true,
				regex : "^[0-9]{4}$"
			},
			isbn2 : {
				required : true,
				regex : "^[0-9]{3}$"
			},
			isbn3 : {
				required : true,
				regex : "^[0-9]{3}$"
			},
			title : {
				required : true,
				maxlength : 100
			},
			catalogue : {
				required : true,
			},
			pubdate : {
				dateISO : true
			},
			title : {
				required : true,
				maxlength : 100
			},
			price : {
				min : 0,
				number : true
			},
			description : {
				maxlength : 4000
			},
		},
		messages : {
			isbn1 : {
				required : "필수",
				regex : "숫자로 4글자"
			},
			isbn2 : {
				required : "필수",
				regex : "숫자로 3글자"
			},
			isbn3 : {
				required : "필수",
				regex : "숫자로 3글자"
			},
			title : {
				required : "필수",
				maxlength : 100
			},
			catalogue : {
				required : "필수",
			},
			pubdate : {
				dateISO : "날짜 형식"
			},
			title : {
				required : "필수",
				maxlength : "최대 100자"
			},
			price : {
				min : "0 보다는 커야해",
				number : "숫자만 가능해"
			},
			description : {
				maxlength : "최대 4000자"
			},
		}
	});

	// 결국은 대부분 정규 표현식으로 처리
	$.validator.addMethod("regex", function(value, element, regexp) {
		let re = new RegExp(regexp);
		let res = re.test(value);
		return res;
	});
	
	
	
</script>
</html>