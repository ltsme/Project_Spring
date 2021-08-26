<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %>

<!DOCTYPE html>
<%

    int pageNum;     // 현재 클릭한 페이지 
    int pageCount ; // 총 페이지 수
    int startPage ;    // 시작페이지
    int endPage ;     //끝페이지
     // 게시물 총 갯수가 동일할 때를 위함 
    int count = (int)session.getAttribute("count");
    
     startPage = (int)session.getAttribute("startPage");
     pageCount = (int)session.getAttribute("pageCount");
     endPage = (int)session.getAttribute("endPage");
  
%>
<html>
<head>
<meta charset="UTF-8">
<title>입양 카테고리</title>
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">
 <link href="category.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" type="text/css" href="resources/css/adopt.css">
  <style type="text/css"> a { text-decoration:none } 
</style> 
</head>

<body>
	<!-- 중간 내용 시작 -->
<div id="wrapper">


	<div id="container">
   		<br>
   		 <div class = "center_box">
 <h1>입양 진행중 카테고리</h1>
         <br>
  <nav> 
    <ul> 
    <th><a href="adoptproceeding" style="color: black">입양 진행</th>&nbsp;&nbsp;&nbsp;
      <th><a href="adopt" style="color: black">입양 가능</a></th> &nbsp;&nbsp;&nbsp;
      <th><a href="adoptcomplete" style="color: black">입양 완료</a></th>&nbsp;&nbsp;&nbsp;
      <th><a href="adopttraining" style="color: black">훈련 중</a></th>&nbsp;&nbsp;&nbsp;
    </ul>
  </nav>
  </div>
  
     <form action="adoptproceedingSearch">
    <br>
    <br>
         <center><select name = "searchtype">
            <option value = "dogmf">성별</option>
            <option value = "dogtype" selected = "dogtype">견종</option>
         </select>  
         
         <input type="search" name = "search">
         <input type="submit" value = "검색"></center>
         
         
          <input type = "hidden" name = "dogadoptst" value="입양진행중">
         
         
    <br>
    <br>
    </form>
   <div class ="list-box-1 con">
        <c:forEach items="${adopt}" var="dto">
        <ul class = "row">
        <li class = "cell">
        <div class = "img-box">
        <a href="adoptproceeding_02?dogid=${dto.dogid}"><img width="200" height="200" src="dog/${dto.dogfilepath}"></a></div>
        <div class = "proud-name">이름 : ${dto.dogname}</div>
        <div class = "proud-age">나이 : ${dto.dogage}살</div>
        <div class = "proud-type">종 : ${dto.dogtype}</div>
          
          </li>
          </ul>


         </c:forEach>

      
    </div>
      <br>
     

   

</div>
    <!-- 중간 내용 끝 -->


    <div class = "center_box"><%for(int i = startPage; i<=endPage; i++){ %>
         <a href="adoptproceeding?pageNum=<%=i%>">[<%=i%>]</a>&nbsp;&nbsp;&nbsp; 
           <% } %></div> 
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