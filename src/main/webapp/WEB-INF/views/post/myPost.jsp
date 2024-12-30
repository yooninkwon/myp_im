<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/static/js/post/myPost.js"></script>
<link rel="stylesheet" href="/static/css/post/myPost.css" />
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
    <!-- 게시글 리스트 테이블 -->
    <div class="post-list">
        <table>
            <thead>
                <tr>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <!-- myPostList가 null이 아닐 경우에만 출력 -->
                <c:forEach var="post" items="${myPostList}">
                    <tr class="clickPostList" data-href="/detatilPost?postNo=${post.post_no}">
                        <td>${post.post_category}</td>
                        <td class="postTitle">${post.post_title}</td>
                        <td class="postNickname">${post.user_nickname}</td>
                        <td><fmt:formatDate value="${post.post_created_at}" pattern="yyyy-MM-dd" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
	
	
	
</body>
</html>