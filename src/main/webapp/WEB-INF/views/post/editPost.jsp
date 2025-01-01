<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/static/ckeditor/ckeditor.js"></script>
<script src="/static/js/post/editPost.js"></script>
<link rel="stylesheet" href="/static/css/post/editPost.css" />
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="editPostBody">
		<input type="hidden" id="postNo" value="${postNo}" />
		<div class="form-group">
			<label for="category">카테고리</label>
			<input type="text" id="postCategory" value="${postCategory }" disabled/>
			
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" id="postTitle" value="${postTitle}" maxlength="100"/>
		</div>
	    <div class="form-group">
			<label for="content">내용</label>
			<textarea id="editor" rows="10" cols="80">${postContent}</textarea>
	    </div>
	    <button type="button" id="editPostBtn">수정하기</button>
	</div>

</body>
</html>