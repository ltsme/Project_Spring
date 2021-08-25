<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 작성</title>
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">
<script type="text/javascript">
	function check(){
		var form = document.writeForm
		if(form.retitle.value == ""){
			alert("제목을 입력하세요");
			form.retitle.focus();
			return false;
		}
	
		if(form.recontent.value == ""){
			alert("내용을 입력하세요");
			form.recontent.focus();
			return false;
		}
		form.submit();
	}
</script>

<style>
	table{
		backgound-color:#eeeeee;
		text-align: center;
		margin:0 auto;
		border-collapse: collapse;
	}
	 th, td {
		text-align: center;
		padding:5px;
	}
	a { 
		text-decoration:none
	 } 
	input:focus{
		background-color: #f5af46;
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

<!-- 상단 시작 { -->

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

<!-- 테이블시작 ----------------------------------------> 
	 <table border="1" width="600">
		<form name="writeForm"  action="review_write" method="post" enctype="multipart/form-data">
			<thead>
				<tr>
					<th colspan="4" style="background-color: #f5af46; text-align: center; font-size:18px;">후기글 작성</th>
				</tr>
			</thead>		
			<tbody>
					<input type="text"  name="userid" size="20" value="<%=userid%>" hidden="true">
					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text"  name="retitle" size="80" placeholder="제목을 입력해주세요" ></td>
					</tr>
		
					<tr> 
						<td>내용</td>
						<td colspan="3"><textarea rows="10" cols="80" name="recontent" placeholder="내용을 입력해주세요"></textarea></td>
					</tr>
					
					<tr>
						<td>파일 첨부</td>
						<td colspan="3"><input type="file" name="uploadFile"> 
		 			</tr>
		
					<tr>
						<td colspan="4"><input type="button" style="background: #f5af46; font-size:15px;"  
								value="입력" onclick="check()">
								<input type="reset"  value="다시입력">
					</tr>

					
					<!-- 입력이 안됐을때 첫 화면으로 돌아가게 하기 위해서 하이퍼 링크 달아주기 -->
				</tbody>
		</form>
	</table><br>
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