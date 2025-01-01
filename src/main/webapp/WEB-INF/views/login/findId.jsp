<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/static/css/login/findId.css" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/static/js/login/findId.js"></script>
</head>
<body>
   <div class="findIdForm">
       <h2>아이디/비밀번호 찾기<br />
       		<span>회원정보에 등록한 이메일로 인증</span>
       </h2>
       <!-- 이메일 -->
       <label for="email">이메일</label>
       <div class="input-wrapper">
           <input type="email" id="email" name="email" placeholder="이메일" required>
           <button type="button" id="sendEmailVerification">인증</button>
       </div>

       <!-- 이메일 인증번호 -->
        <label for="emailVerification">인증번호</label>
        <div class="input-wrapper">
	        <input type="text" id="emailVerification" name="emailVerification" placeholder="인증번호를 입력하세요" required>
	        <button type="button" id="checkEmailVerification">확인</button>
		</div>
    </div>
    
    
    <!-- 이메일 인증시 아이디 / 비밀번호 재설정 오버레이창 -->
    <div class="overlay" id="overlay">
    <div class="overlay-content">
        <h2>비밀번호 재설정</h2>
        <div class="overlay-info">
            <label for="userId">아이디</label>
            <input type="text" id="userId" value="" readonly>
        </div>
        <div class="overlay-info">
            <label for="newPassword">새 비밀번호</label>
            <input type="password" id="newPassword" placeholder="새 비밀번호를 입력하세요" required>
        </div>
        <button type="button" id="changePassword">비밀번호 변경하기</button>
    </div>
</div>
    
    
</body>
</html>