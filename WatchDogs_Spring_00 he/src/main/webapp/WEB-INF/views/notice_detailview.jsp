<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %> 
  
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>공지 상세 페이지</title>
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">

<style type="text/css">
th, td{
	text-align: center;
	padding:5px;
}
table{
	margin:0 auto;
	text-align: center;
	border-collapse: collapse;
}	
a { 
text-decoration:none 
} 

textbox{
	text-align: left;
}
#button{
 	margin:auto;
 	width: 100px;
	background-color: #f5af46;
	line-height:36px;
 	height: 36px;
 	text-align:center;
 	font-size:15px;
	border-radius: 50px !important;
}
</style>

</head>

<body>	<!-- 중간 내용 시작 -->
<div id="wrapper">


	<div id="container">
   		<br>

	<!-- 테이블 시작 ---------------------------------------->
	 <table border="1" width="700" >
			<thead>
				<tr>
					<th colspan="4" style="background-color: #f5af46;  text-align: center; font-size:18px;">공지 상세 페이지</th>
				</tr>
			</thead>
			
			<tr>
				<td>No.</td>
				<td>${noticedetail.noid}</td>
				<td>조회수</td>
				<td>${noticedetail.nohit}</td>
			</tr> 
			
 			<tr>
				<td>관리자</td>
				<td>${noticedetail.adid}</td>
				<td>날짜</td>
				<td>${noticedetail.nodate}</td>
			</tr>  
			
			<tr>
				<td>제목</td>
				<td colspan="3">${noticedetail.notitle}</td>
			</tr>
		
			<tr>
				<td>내용</td>
				<td colspan="3" height="150"  id="textbox">${noticedetail.nocontent}</td>
			</tr>
			
			<!-- 입력이 안됐을때 첫 화면으로 돌아가게 하기 위해서 하이퍼 링크 달아주기 -->	
			
			
	</table> <br>
	<div id="button" onClick="location.href='noticelist.wd'" style="cursor: pointer"><b>목록으로</b></div>


	</div>

</div>
    <!-- 중간 내용 끝 -->



<!-- 하단 시작 { -->



<style>
	#bottom_copy{background-color:#3d3e3e; width:100%; margin-top:100px;}
	#bottom_copy .w1200{width: 1200px; margin:0 auto; color:#EDEDED; padding: 10px 42px; box-sizing: border-box; font-size: 0.8em; background-color:#3d3e3e;}
</style>


<section id="bottom_copy">
	<div class="w1200">
	    <p>Copyright © WatchDogs. All Rights Reserved.</p>
	    010-1234-5678
	    서울특별시 서초구 서초동 1305 서산빌딩 더조은 6조
	</div>
</section>
	
    <script>
    $(function() {
        $("#top_btn").on("click", function() {
            $("html, body").animate({scrollTop:0}, '500');
            return false;
        });
    });
    </script>


<script src="http://dmshop.kr/js/sns.js"></script>
<!— } 하단 끝 —>

</body>
</html>