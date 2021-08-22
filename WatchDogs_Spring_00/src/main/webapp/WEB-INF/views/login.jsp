<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 	ID, 유저 타입을 웹 내에서 계속 돌려 줌 -->  
    
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
                
                </form>
            </div>         
            
            <br><br>

			<div class="Foot">
				<hr class="hide">
				WatchDogs Corp.
				|
				<a href="help" class="link_custom" target="_blank"
					data-tiara-action-name="고객센터">고객센터</a>
			</div>
        </div>
       
    </body>
</html> 

