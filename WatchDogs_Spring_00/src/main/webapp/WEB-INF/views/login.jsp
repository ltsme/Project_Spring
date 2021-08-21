<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    
<!DOCTYPE html>
<html>
    <head>
    	<link rel="stylesheet" href="resources/css/style.css">
        <title>로그인</title>
    </head>
    
    <body>
        <div class="wrap">
            <div class="form-wrap">

                <div class="icon">
                   <a href="home"><img src="resources/img/logo.png" width="150px" height="100px" alt="WatchDogs"></a>
                </div>
                
                <form id="left" action="logincheck" class="input-group2" method="post">
                    <input type="text" name="userid" class="input-field" placeholder="아이디" autocomplete="off" required>
                    <input type="password" name="userpw" class="input-field" placeholder="비밀번호" autocomplete="off" required>
                    <button class="submit" type="submit">로그인</button>
                    <a href="lookupidpw" target="_blank">아이디 / 비밀번호 찾기</a>
                </form>
                
                
            </div> <!-- form-wrap -->  
            
			<div class="Foot">
				<hr class="hide">
				WatchDogs Corp. </hr>
				|
				<a href="help"
					data-tiara-action-name="고객센터">고객센터</a>
			</div> <!-- foot -->
			
        </div> <!-- wrap -->       
    </body>
</html> 

