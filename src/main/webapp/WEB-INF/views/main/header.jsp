<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/static/js/header/header.js"></script>
<link rel="stylesheet" href="/static/css/header/header.css" />


</head>
<body>
	<!-- 헤더 메인로고 부분 -->
	<div class="headerMain">
		<a href="/"><img src="/static/img/header/im.png" alt="로고" ></a>
	</div>
	<div class="headerMenu">
		<a href="/who">누구야</a>
		<a href="/life">이렇게 살아왔어</a>
		<a href="/worry">고민이 있어</a>
		<a href="/secret">말 못할 비밀</a>
		<a href="/free">왁자지껄</a>
	</div>
    <div class="loginBox">
        <form action="/login" method="post">
            <input type="text" name="username" placeholder="아이디">
            <input type="password" name="password" placeholder="비밀번호">
            <button type="submit">로그인</button>
            <div class="signUpBox">
            	<a class="signUp" href="/login/signUp">회원가입</a>
            	<span class="divider">|</span>
            	<a class="signUp" href="/login/findId">아이디/비밀번호 찾기</a>
            </div>
        </form>
	</div>
</body>
</html>