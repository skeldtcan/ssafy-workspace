<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>REST테스트</title> 
  <style type="text/css">
     td,th{padding: 5px}
     .skyblue{background-color: skyblue;
              width: 80px;
              text-align: left}
  </style>
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script>
  /*
  $.ajax({
   type:'POST',
   url:url,
   data:data,   -- json도 사용가능  
   success:success,
   dataType:datatype
});

※ 자주사용하는 속성
url:문자열 - 요청url 설정 ,데이터를 보내고자하는 주소   ex)  <form action="">
type:문자열 - GET/POST설정
data:객체,문자열 - 요청 매개변수 설정   ex) <input type="text"  name="irum">
dataType : 서버에서 내려온 data형식    ex) default : xml, json, script, text, html
success:함수 - 성공시 호출할 함수 설정
async:불리언 - 동기/비동기 설정
error:함수 - 실패시 호출할 함수 설정
  */
  

  
	  function showUpForm(no){
			$('#form').hide();
			$('#upform').show(500);
			$.ajax({
				type:'GET',
				url:'/person/'+no,
				dataType:'json',
				success:function(data){
					$('#upform input[name=name]').val(data.name);
					$('#upform input[name=age]').val(data.age);
					$('#upform input[name=job]').val(data.job);
					$('#upform input[name=no]').val(data.no);
				}
	        });
	  }//수정폼 보이기
	
  
      function listPrint(){
	     $.ajax({
				type:'GET',
				url:'/person/all',
				dataType:'json',
				success:function(data){
					var htmlTxt='<ul>';
					$.each(data,function(index,value){
						 htmlTxt += '<li><a href="javascript:showUpForm('+value.no+')">'+value.name+'</li>';    					 
					});
					htmlTxt+='</ul>'
					$('#list').html(htmlTxt);
				}
	     });
      }//목록보기
      
     $(document).ready(function(){
    	$('#showList').click(function(){
    		listPrint();
    	});//목록보기
    	
        $('#showForm').click(function(){
    		$('#upform').hide();
    		$('#form').show(500);
    	});//입력폼보기
    	
    	
        $('#bt_insert').click(function(){        	
	    	$.ajax({
				type:'POST',
				url:'/person/form',
				data: { //JSON.stringify({
					  name: $("#form input[name=name]").val(),
					  age: $("#form input[name=age]").val(),
					  job: $("#form input[name=job]").val()				  
				     },
				//);
				success:function(data){    				
					$('#form').hide();
					listPrint();
				}
			});
        });//입력요청
        

        $('#bt_update').click(function(){   
        	
        	$.ajax({
    			type:'PUT',
    			url:'/person/',
    			headers:{"Content-Type":"application/json"},
    			data:  JSON.stringify(
    				 {
    				  name: $("#upform input[name=name]").val(),
    				  age: $("#upform input[name=age]").val(),
    				  job: $("#upform input[name=job]").val(),
    				  no: $("#upform input[name=no]").val()
    			     })
    			     ,
    			success:function(data){    	
    				$('#upform').hide();
    				listPrint();
    			}
    		  });
        });//수정요청
        

    	
        $('#bt_del').click(function(){  
        	$.ajax({
    			type:'DELETE',
    			url:'/person/'+$("#upform input[name=no]").val(),    			
    			success:function(data){
    				$('#upform').hide();
    				listPrint();
    			}
    		  });	
        });//삭제요청
        
        /*
          <RESTful방식>ㅣ
                                                         HTTP요청방식
                                                      ($.ajax()의 type속성을 통해)
                                                         
                입력요청 :   http://localhost:8080/person/form  +  POST
                조회요청 :   http://localhost:8080/person/all   +  GET
                조회요청 :   http://localhost:8080/person/13    +  GET
                삭제요청 :   http://localhost:8080/person/13    +  DELETE
                수정요청 :   http://localhost:8080/person       +  PUT
        
                
           참고) 
           JSON.stringify( 객체 );     JSON.stringify( { key1:value, key2:value } ); ==>  "{ key1:value, key2:value }"
           JSON.parse( 문자열  );      JSON.parse( "{ key1:value, key2:value }");  ==>  { key1:value, key2:value }
        */
        
    	
     });//ready
  </script>
</head>
 
<body>
  <h1>
	Hello world!  
  </h1>
  <P>  The time on the server is ${serverTime}. </P>
  
  <h3>REST테스트</h3>
  <button id="showList">사람목록보기</button> 
  <button id="showForm">사람입력</button>
  
  <hr>
  <div id="list"></div>  
  <div id="form" style="display: none">
  <h3>입력폼</h3>
  <hr>    
    <table border="1">
      <tr>
         <td class="skyblue">이름</td>
         <td><input type="text" name="name"></td>
      </tr>
      <tr>
         <td class="skyblue">나이</td>
         <td><input type="text" name="age"></td>
      </tr>
      <tr>
         <td class="skyblue">직업</td>
         <td><input type="text" name="job"></td>
      </tr>
      <tr>
         <td colspan="2">
           <input type="submit" value="입력" id="bt_insert">
           <input type="reset" value="취소">
         </td>
      </tr>
    </table> 
  </div>
  <div id="upform" style="display:none">
     <input type="hidden" name="no">
  <h3>수정폼</h3>
  <hr>
    <table border="1">
      <tr>
         <td class="skyblue">이름</td>
         <td><input type="text" name="name" ></td>
      </tr>
      <tr>
         <td class="skyblue">나이</td>
         <td><input type="text" name="age" ></td>
      </tr>
      <tr>
         <td class="skyblue">직업</td>
         <td><input type="text" name="job" ></td>
      </tr>
      <tr>
         <td colspan="2">
           <input type="button" value="수정" id="bt_update">
           <input type="reset" value="취소" >
           <input type="button" value="삭제" id="bt_del">
         </td>
      </tr>
    </table>
  </div>
  <div id="result"></div>
</body>
</html>
