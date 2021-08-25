<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %>   
  
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>후기 상세 페이지</title>
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">
<link rel="stylesheet" type="text/css" href="resources/css/board.css">

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

<body>

<div id="hello_wrap">
	
	
<script type="text/javascript" src="/js/jquery.touchSlider.js"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function() {
	$("#mb_slide").touchSlider({
		view : 1,
		autoplay : {
			enable : true,
			pauseHover : true,
			interval : 8000,
		},
		btn_prev : $("#mb_slide").next().find(".btn_prev"),
		btn_next : $("#mb_slide").next().find(".btn_next"),
	});
});
//]]>
</script>

    <script>
    $(window).scroll(function(){
      var sticky = $('.nav'),
          scroll = $(window).scrollTop();

      if (scroll >= 200) sticky.addClass('fixed');
      else sticky.removeClass('fixed');
    });

    $(function (){
        var $category = $("#category");

        $("#menu_open").on("click", function() {
            $category.css("display","block");
        });

        $("#category .close_btn").on("click", function(){
            $category.css("display","none");
        });
    });
    </script>
</div>


	<!-- 중간 내용 시작 -->
<div id="wrapper">


	<div id="container">
   		<br>

	
<!-- 테이블 시작---------------------------------------->
	 <table border="1"  width="60%" >
	 	<input type="hidden" name="reid" value="${reviewdetail.reid}">
			<thead>
				<tr>
					<th colspan="4" style="background-color: #f5af46; text-align: center; font-size:18px;">후기 상세 페이지</th>
				</tr>
			</thead>
			<tbody>
			
			<tr>
				<td style="background-color:#eeeeee; text-align: center;">No.</td>
				<td>${reviewdetail.reid}</td>
				<td style="background-color:#eeeeee; text-align: center;">조회수</td>
				<td>${reviewdetail.rehit}</td>
			</tr> 
			
			<tr>
				<td style="background-color:#eeeeee; text-align: center;">작성자</td>
				<td>${reviewdetail.userid}</td>
				<td style="background-color:#eeeeee; text-align: center;">날짜</td>
				<td>${reviewdetail.redate}</td>
			</tr> 
				
			<tr>
				<td style="background-color:#eeeeee; text-align: center;">제목</td>
				<td colspan="3">${reviewdetail.retitle}</td>
			</tr>
			
			<tr>
				<td style="background-color:#eeeeee; text-align: center;">사진</td>
				<td colspan="3"><img width="400" src="${pageContext.request.contextPath }/resources/review/${reviewdetail.refilepath}"></td>
			</tr> 

			<tr>
				<td style="background-color:#eeeeee; text-align: center;"> 내용</td>
				<td colspan="3" height="150"  id="textbox">${reviewdetail.recontent}</td>
			</tr>
			<!-- 입력이 안됐을때 첫 화면으로 돌아가게 하기 위해서 하이퍼 링크 달아주기 -->

			<tr>				
				<c:if test="${reviewdetail.userid eq userid}">
					<td colspan="4" style="text-align: center;">
	 	 				<input type="button" id="modify_delete" onclick="location.href='review_mdview?reid=${reviewdetail.reid}';" value="수정/삭제">
 				</c:if>
	
					</td>
				
			</tr>	
			
			<!-- 아이디 값에 따라 버튼 보이게 안보이게 설정하기------------->
	
				
			</tbody>
	</table> <br>
 						<div id="button" onClick="location.href='reviewlist'" style="cursor: pointer"><b>목록으로</b></div>

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