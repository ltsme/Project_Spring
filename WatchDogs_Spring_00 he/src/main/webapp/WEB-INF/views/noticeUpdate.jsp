<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 정보</title>
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">

</head>

<body>

<div id="hello_wrap">

<!-- 상단 시작 { -->
	
        
	
	<style>
		#must_read{background-color: #fc6; border-color: #ebccd1; text-align: center }
		#must_read h3{color: #a94442; font-weight: 400; padding: 20px 0; }
		
		.top_banner{width:1050px; margin:0 auto; margin-top:50px}
		.top_banner td{}
	</style>
	
	<section id="must_read">
	    <h3> </h3>
	</section>
	
	
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
	<h3>공지 정보</h3>
		<form action="noticeUpdate.wd" method="post">
			번호<input type="text" name="noId" readonly="readonly" value="${detail.noId }"><br>
			제목<input type="text" name="noTitle" size="20" value="${detail.noTitle}"><br>
			내용<br>
			<textarea rows="5" cols="30" name="noContent">${detail.noContent}</textarea><br>
			작성날짜<input type="text" name="noDate" size="50" readonly="readonly" value="${detail.noDate}"><br>
			삭제날짜<input type="text" name="noDelDate" size="50" readonly="readonly" value="${detail.noDelDate}"><br>
			조회수<input type="text" name="noHit" readonly="readonly" value="${detail.noHit }"><br>
			관리자아이디<input type="text" name="adminID" size="50" readonly="readonly" value="${detail.adminID}"><br>
			<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="adminpage.wd">돌아가기</a>
			&nbsp;&nbsp;&nbsp;<a href="noticeDelete.wd?noId=${detail.noId }">삭제</a>
			&nbsp;&nbsp;&nbsp;<a href="noticeDeleteCancel.wd?noId=${detail.noId }">삭제취소</a>
		</form>

	</div>

</div>
    <!-- 중간 내용 끝 -->



<!-- 하단 시작 { -->
</div>


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