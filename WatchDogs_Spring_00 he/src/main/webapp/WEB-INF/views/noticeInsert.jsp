<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 상단 부분 (Header) -->    
<%@include file ="Header.jsp" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 등록</title>

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
	<h3>공지 등록</h3>
	<form action="noticeInsert.wd" method="post">
			제목<input type="text" name="noTitle" size="20"><br>
			내용<textarea rows="5" cols="30" name="noContent"></textarea><br>
			관리자아이디<input type="text" name="adminID" size="50" value="admin3" readonly="readonly"><br>
			<input type="submit" value="확인">&nbsp;&nbsp;&nbsp;<a href="adminpage.wd">돌아가기</a>
	</form>
	
</body>
</html>