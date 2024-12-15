<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/login/signUp.css" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/static/js/login/signUp.js"></script>


</head>
<body>
    <div class="signUpForm">
        <h2>회원가입</h2>
        <form action="/signUpOk" method="post">
            <!-- 아이디 -->
                <label for="username">아이디</label>
            <div class="input-wrapper">
                <input type="text" id="username" name="username" placeholder="아이디" required pattern="^[a-zA-Z0-9]+$" title="아이디는 영어 대소문자와 숫자만 가능합니다.">
                <button type="button" id="checkUsername">확인</button>
            </div>

            <!-- 비밀번호 -->
            <label for="password">비밀번호</label>
            <div class="input-wrapper">
            <input type="password" id="password" name="password" placeholder="비밀번호" required>
			</div>
			
            <!-- 닉네임 -->
                <label for="nickname">닉네임</label>
            <div class="input-wrapper">
                <input type="text" id="nickname" name="nickname" placeholder="닉네임" required pattern="^[a-zA-Z0-9가-힣]+$" title="닉네임은 한글, 영어 대소문자, 숫자만 가능합니다.">
                <button type="button" id="checkNickname">확인</button>
            </div>

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
            <!-- 제출 버튼 -->
            <button type="submit">회원가입</button>
        </form>
    </div>
</body>
</html>