<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %> 

<!doctype html>

<html lang="ko">

	<head>
		<meta charset="UTF-8">
		
		<title>WatchDogs</title>
		<link rel="stylesheet" href="resources/css/style.css">
		<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
		<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">
	</head>
	
<body>

<!-- 	내용 시작  -->
		<div class="wrapper">
	
		<div class="container">
	   		
	   		<div class="banner">
	   			<img src="resources/img/banner.png" width="100%" height="400px" alt="banner" align="middle">
	   		</div>
			
			<div class="contents">
				"개는 자기 자신보다 당신을 더 사랑하는<p>
				이 세상의 유일한 생명체이다."
			</div>	
			
			<div class="contents2">
				- Josh Billings
			</div>	
			
			<div class="blank"></div>
			
			<div class="contents3">
				혹시, <br><br>
				길가의 강아지<br><br>
				그냥 지나친 적 없으신가요?
			</div>
			
			<div class="contents4">
	   			<img src="resources/img/newsis.jpg" width="250px" height="400px" alt="유기동물 현황_1" >
	    		<img src="resources/img/DailyVET.png" width="600px" height="400px" alt="유기동물 현황_2">
	   		</div>
	   		
	   		<div class="contents3">
	   			반려동물을 소유물이라고 생각하고 버리거나 학대하는 일이<br><br>
	   			끊임 없이 벌어지고 있습니다. 
	   		</div>
			
			<div class="blank"></div>
			
			<div class="contents3">
	   			<img src="resources/img/dogicon.png" width="50px" height="50px" alt="dog_icon" ><br>
	   			모두의 <b>관심</b>이 필요합니다.<br><br>
	   			
	   			반려견들이 더이상 상처를 받지 않고<br>
	   			<font color="#ffad06">새롭게 시작할 수 있도록</font> <br><br>
	   			
	   			<b>저희 <font color="#ffad06">Watch Dogs</font>가 함께 합니다.</b>
	   		</div>
			
			<div class="contents5">
				<img src="resources/img/curved_arrow.png" width="30px" height="30px" alt="dog_icon" > &nbsp; 찾아 오시는 길 <br>
			</div>	
			
			<div class="contents5">
				<div id="map" style="width:90%;height:350px;"></div>
			</div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9fc6bb27417d985e141201e29ea4be94&libraries=services"></script>
			<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = { 
			        center: new kakao.maps.LatLng(37.50216, 127.02529), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };
			
				var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			
				// 마커가 표시될 위치입니다 
				var markerPosition  = new kakao.maps.LatLng(37.50216, 127.02529); 
			
				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
				    position: markerPosition
				});
			
				// 마커가 지도 위에 표시되도록 설정합니다
				marker.setMap(map);
			
				// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
				// marker.setMap(null);
			</script>
			
			<div class="contents5">
				<img src="resources/img/phone.png" width="30px" height="30px" alt="dog_icon" > &nbsp; 연락처. &nbsp;&nbsp; 010-1234-5678
				<br><br>
				<img src="resources/img/email.png" width="30px" height="30px" alt="dog_icon" > &nbsp; 이메일. &nbsp;&nbsp; WatchDogs@gmail.com
			</div>
			
			<div class="contents4">
				<img src="resources/img/logo.png" width="300px" height="200px" alt="dog_icon" >
			</div>
			
			<div class="contents5">
					| 강남 본사 위치 : 서울특별시 서초구 서초4동 강남대로 441 <br><br>
					| 대표 : 홍길동 (사업자 등록번호 : 111-22-33333)<br><br>
					| 동물판매 등록번호 : 1111111-222-3333-44444
			</div>
		
		</div>
	
	</div>
	    <!-- 중간 내용 끝 -->
	    
	<script type="text/javascript">
		window.open(alert('가입 되었습니다. ^_^ 로그인 해 주세요.');
	</script>  
	    
<!-- 하단 부분 (Header) --> 	    
	<%@include file ="Footer.jsp" %>     
	
	   
	</body>
</html>
