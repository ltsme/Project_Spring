<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입양완료2</title>
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">
 <link rel="stylesheet" type="text/css" href="resources/css/adopt.css">
 </head>

<body>

	<!-- 중간 내용 시작 -->
<div id="wrapper">


	<div id="container">
   		<br>
   <div class = "center_box">
   <nav> 
    <ul> 
         <th><a href="adoptproceeding" style="color: black">입양 진행</th>&nbsp;&nbsp;&nbsp;
      <th><a href="adopt" style="color: black">입양 가능</a></th> &nbsp;&nbsp;&nbsp;
      <th><a href="adoptcomplete" style="color: black">입양 완료</a></th>&nbsp;&nbsp;&nbsp;
      <th><a href="adopttraining" style="color: black">훈련 중</a></th>&nbsp;&nbsp;&nbsp;    </ul>
   </nav>
   </div>
        <br>
        <br>

      
        <c:forEach items="${adopt}" var="dto">
       <div class ="detail_image"><img width="300" height="200" src="dog/${dto.dogfilepath}"></div> 
     <div class ="detail">
        <li>이름 : ${dto.dogname}</li>
         <li>성별 : ${dto.dogmf} </li>
         <li>나이 : ${dto.dogage} </li>
         <li>종 : ${dto.dogtype} </li>
         <li width="200">코멘트 : ${dto.dogtraincomm} </li>
          
</div>
         </c:forEach>
 
        

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