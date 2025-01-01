<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I'm</title>
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
		<a href="/post?category=who">누구야</a>
		<a href="/post?category=life">이렇게 살아왔어</a>
		<a href="/post?category=worry">고민이 있어</a>
		<a href="/post?category=secret">숨겨둔 비밀</a>
		<a href="/post?category=free">자유게시판</a>
	</div>
	<!-- 세션에 유저코드가 없으면 로그인 폼 -->
	<c:if test="${empty sessionScope.userCode }">
	    <div class="loginBox">
	        <form action="/login" method="post" id="loginForm">
	            <input type="text" name="username" id="username" placeholder="아이디">
	            <input type="password" name="password" id="password" placeholder="비밀번호">
	            <button type="submit">로그인</button>
	            <div class="signUpBox">
	            	<a class="signUp" href="/login/signUp">회원가입</a>
	            	<span class="divider">|</span>
	            	<a class="signUp" href="/login/findId">아이디/비밀번호 찾기</a>
	            </div>
	        </form>
		</div>
	</c:if>
	<!-- 세션에 유저코드가 있으면 유저정보 및 기능 -->
    <c:if test="${not empty sessionScope.userCode}"> <!-- 세션에 userCode가 있으면 사용자 메뉴 출력 -->
        <div class="userBox">
            <p>${sessionScope.userNickname}</p>
            <ul>
                <li><a href="/writePost">글 쓰러가기</a></li>
                <li><a href="/myPost">내가 쓴 글 보기</a></li>
            	<li><a class="logOut" href="/logout">로그아웃</a></li>
            </ul>
        </div>
    </c:if>
</body>
</html>