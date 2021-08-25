<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>공지 목록</title>
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/css/default_shop.css?ver=12928">
<link rel="stylesheet" href="http://dmshop.kr/theme/moon/skin/shop/basic/style.css?ver=12928">
<link rel="stylesheet" href="css/bootstrap.css">
<style>

table{
	border-collapse: collapse;
}

th, td {
	  text-align: center;
	  padding: 10px;	
}

.line{
border-bottom:1px solid #eeeeee;
}

a { text-decoration:none } 

a:hover{
	color:orange;
}
#searchWord:focus{
		background-color:#eeeeee;
	}
</style>

</head>

<body>

	<!-- 중간 내용 시작 -->
<div id="wrapper">


	<div id="container">
   		<br>

   		<!-- 공지게시판 시작 ---------------------------------------->

		<!-- 검색창 ---------------------------------------->
	<div class="row" style="clear:right;width:500px; float: right;">
		<div class="col-lg-12">
			<form id="searchForm" action="noticelistquery" method="post">
				<select name="searchCategory">
					<!-- <option value="all">전체</option> -->
					<option value="notitle">제목</option>
					<option value="nocontent">내용</option>
				</select>
				<input type="text" id="searchWord" name="searchWord" value="" placeholder="검색어를 입력해주세요"/>
				<input type="submit" value="검색">
			</form>
		</div>
	</div>
	<!-- 검색창 -->
	<br><br><br>	
	
	<!-- table list  -->
	<div class="container">
			<div class = "row">
				<table width="100%" class = "table table-hover" style="text-align:center; border:1px solid #dddddd;">
					<colgroup>
				    	<col width="5%"/>
				    	<col width="10%"/>
				    	<col width="25%"/>
				    	<col width="30%"/>
				    	<col width="20%"/>
				    	<col width="10%"/>
				    </colgroup>
				    
		<thead class="thead-light">
			<tr>
				<th scope="col" style = "background-color:#eeeeee; text-align:center;">No.</th>
				<th scope="col" style = "background-color:#eeeeee; text-align:center;">관리자</th>
				<th scope="col" style = "background-color:#eeeeee; text-align:center;">제목</th>
				<th scope="col" style = "background-color:#eeeeee; text-align:center;">내용</th>
				<th scope="col" style = "background-color:#eeeeee; text-align:center;">날짜</th>
				<th scope="col" style = "background-color:#eeeeee; text-align:center;">조회수</th>
			</tr>
		</thead>
		<tbody>
<!-- 리스트 값 넣기 ---------------------------------------->
			<c:forEach items = "${noticelist }" var="noticeDto" >
			<c:if test="${empty noticeDto.nodeldate}">
				<tr class="line">
					<td style="cursor: not-allowed">${noticeDto.noid}</td>
					<td style="cursor: not-allowed">${noticeDto.adid}</td>
					<td ><a href="noticedetail?noid=${noticeDto.noid}" >${noticeDto.notitle}</a></td>
					<td ><a href="noticedetail?noid=${noticeDto.noid}" >${noticeDto.nocontent}</a></td>
					<td style="cursor: not-allowed">${noticeDto.nodate}</td>
					<td style="cursor: not-allowed">${noticeDto.nohit}</td>
				</tr>
		    </c:if>
			</c:forEach>
		

		<!-- 2021.05.19 페이징 구현 -->
			<tr>
				<td colspan="6" align="center">
					<!-- 페이징 부분 -->
					<c:forEach items="${pageList }" var="page">
						<a href="noticelist?page=${page }">${page}</a>
					</c:forEach>
				</td>
	   		</tr>
		</tbody>			
	</table>
	
		</div>
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