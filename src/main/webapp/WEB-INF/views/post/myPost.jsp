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
    	<c:choose>
	        <c:when test="${not empty myPostList }">
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
			</c:when>
			<c:otherwise>
				<div class="no-posts">
					<span>게시글이 없습니다. 새로운 글을 작성해보세요!</span>
				</div>
			</c:otherwise>
    	</c:choose>
    </div>
	
    <!-- 페이지 번호 -->
    <c:choose>
        <c:when test="${not empty myPostList}">
            <div class="pagination">
                <c:if test="${pagination.currentPage > 1}">
                    <a href="?page=${pagination.currentPage - 1}">이전</a>
                </c:if>

                <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="pageNum">
                    <c:choose>
                        <c:when test="${pageNum == pagination.currentPage}">
                            <span class="current">${pageNum}</span>
                        </c:when>
                        <c:otherwise>
                            <a href="?page=${pageNum}">${pageNum}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${pagination.currentPage < pagination.totalPages}">
                    <a href="?page=${pagination.currentPage + 1}">다음</a>
                </c:if>
            </div>
        </c:when>
    </c:choose>
	
	
</body>
</html>