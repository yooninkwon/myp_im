<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/static/js/post/detailPost.js"></script>
<link rel="stylesheet" href="/static/css/post/detailPost.css" />
</head>
<body>
    <jsp:include page="../main/header.jsp" />
    <div id="detailPostBody">
        <div class="post-title">${detailPost.post_title}</div>
        <div class="post-meta">
            <span class="meta-category">${detailPost.post_category}</span>
            <fmt:formatDate value="${detailPost.post_created_at}" pattern="yyyy-MM-dd HH:mm" />
            <span class="meta-author">${detailPost.user_nickname}</span>
        </div>
        <div class="post-content">
            ${detailPost.post_content}
        </div>

        <!-- 수정 및 삭제 버튼을 조건에 맞게 표시 -->
        <c:if test="${detailPost.user_nickname == sessionScope.userNickname}">
            <div class="post-actions">
                <!-- 수정 버튼 - form을 사용하여 submit -->
                <form action="/editPost" method="post">
                    <input type="hidden" name="postNo" value="${detailPost.post_no}" />
                    <input type="hidden" name="postCategory" value="${detailPost.post_category}" />
                    <input type="hidden" name="postTitle" value="${detailPost.post_title}" />
                    <input type="hidden" name="postContent" value="${detailPost.post_content}" />
                    <button class="editBtn" type="submit">수정</button>
                </form>

                <!-- 삭제 버튼 - ajax이용 -->
				<input type="hidden" id="postNo" value="${detailPost.post_no}" />
				<button class="deleteBtn" type="button">삭제</button>
            </div>
        </c:if>
    </div>
</body>
</html>