<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %>  
  
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>후기 수정 페이지</title>
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">
<style type="text/css">
th, td{
	text-align: center;
	padding:5px;
}

table{
	backgound-color:#eeeeee;
	margin:0 auto;
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
<body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="http://dmshop.kr/js/bootstrap.js"></script>
<script src="http://dmshop.kr/js/jquery.shop.menu.js?ver=1631"></script>
<script src="http://dmshop.kr/js/common.js?ver=1631"></script>
<script src="http://dmshop.kr/js/icecream.js?ver=1631"></script>
<script src="http://dmshop.kr/js/wrest.js?ver=1631"></script>
<script src="http://dmshop.kr/theme/moon/js/jquery.flexslider-min.js"></script>
<link href="http://dmshop.kr/theme/moon/js/flexslider.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
</head>

<body>
	<!-- 중간 내용 시작 -->
<div id="wrapper">


	<div id="container">
   		<br>
	
<!-- 테이블 시작 ---------------------------------------->
	 <table border="1" width="600" >
		 <form action="reviewmodify" method="post" enctype="multipart/form-data">
		 	<input type="hidden" name="reid" value="${reviewdetail.reid}">
				<thead>
					<tr>
						<th colspan="4" style="background-color:  #f5af46; text-align: center; font-size:18px;">후기 수정 페이지</th>
					</tr>
				</thead>
				<tbody>
				
					<tr>
						<td>No.</td>
						<td>${reviewdetail.reid}</td>
						<td>조회수</td>
						<td>${reviewdetail.rehit}</td>
					</tr> 
	
					<tr>
						<td>작성자</td>
						<td>${reviewdetail.userid}</td>
						<td>날짜</td>
						<td>${reviewdetail.redate}</td>
					</tr> 
						
					<tr>
						<td>제목</td>
						<td colspan="3" ><input type="text"  name="retitle" size="80"  value="${reviewdetail.retitle}"></td>
					</tr>
					
					<tr>
						<td>사진</td>
						<td colspan="3"><img class="imgClass" width="350" src="${pageContext.request.contextPath }/resources/review/${reviewdetail.refilepath}"></td>
					</tr> 
					
					<tr>
					<td>이미지 수정</td>
						<input type="hidden" name="oldFilePath" value="${reviewdetail.refilepath }">
						<td colspan="3">	<input class="file" type="file" name="uploadFile"> </td>		
					</tr>	
					
					<tr>
						<td>내용</td>
						<td colspan="3" ><textarea rows="10" cols="70" name="recontent">${reviewdetail.recontent}</textarea></td>
					</tr>
					
						
					<!-- 입력이 안됐을때 첫 화면으로 돌아가게 하기 위해서 하이퍼 링크 달아주기 -->
				</tbody>
					<tr>
						<td colspan="4"><input type="submit" style=" background: #f5af46; font-size:15px; " value="수정">
							<input type="button" class="button" style=" background: #f5af46; font-size:15px; "  onclick="location.href='reviewdelete?reid=${reviewdetail.reid}'"  value="삭제">
						</td>
					</tr>
			</form>
	</table> <br>
	<div id="button" onClick="location.href='reviewlist.wd'" style="cursor: pointer"><b>목록으로</b></div>
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
