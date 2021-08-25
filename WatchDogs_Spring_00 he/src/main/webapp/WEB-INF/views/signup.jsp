<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    
    %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resources/css/style.css">
        <title>회원가입 화면</title>
    </head>
    
    <body>
        <div class="wrap">
            <div class="form-wrap">

                <div class="icon">
                    <a href="home"><img src="resources/img/logo.png" width="150px" height="100px" alt="WatchDogs"></a>
                </div>

                <form id="left" action="signupfunction" class="input-group" method="post">
                    <input type="text" name="userid" class="input-field" placeholder="아이디" autocomplete="off" required>
                    <input type="password" name="userpw" class="input-field" placeholder="비밀번호" autocomplete="off" required>
                     <font size="2px"> 비밀번호 힌트 : </font>
	                	<select name="language"  >
						    <option value="none" selected>===== 질문을 선택해 주세요 =====</option>
						    <option value="quiz_shcool" >태어난 초등학교는?</option>
						    <option value="quiz_singer">가장 좋아하는 가수는?</option>
						    <option value="quiz_father">아버지의 이름은?</option>
						</select>  
					<input type="text" name="userpwquiz" class="input-field" placeholder="비밀번호 힌트" autocomplete="off" required>	
                    <input type="text" name="usertel" class="input-field" placeholder="전화번호 (-없이 입력)" autocomplete="off" required>
                    <input type="email" name="useremail" class="input-field" placeholder="이메일" autocomplete="off" required>
                    <input type="text" name="username" class="input-field" placeholder="이름" autocomplete="off" required>
                    <button type="submit" class="submit" >등록하기</button>   
                    
                     
                    <div class="lookup">   
                    	<a href="lookupidpw">아이디 / 비밀번호 찾기</a>          
                	</div>  
                </form>
                                                
            </div>
            
            
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

