<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="/static/ckeditor/ckeditor.js"></script>
<script src="/static/js/post/writePost.js"></script>
<link rel="stylesheet" href="/static/css/post/writePost.css" />
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="writePostBody">
		<form action="/writePost/save" method="post">
			<div class="form-group">
				<label for="category">카테고리</label>
				<select name="category" id="category">
					<option value="누구야">누구야</option>
					<option value="이렇게 살아왔어">이렇게 살아왔어</option>
					<option value="고민이 있어">고민이 있어</option>
					<option value="숨겨둔 비밀">숨겨둔 비밀</option>
					<option value="자유게시판">자유게시판</option>
				</select>
			</div>
			<div class="form-group">
				<label for="title">제목</label>
				<input type="text" id="title" name="title" placeholder="제목을 입력하세요" maxlength="100"/>
			</div>
		    <div class="form-group">
				<label for="content">내용</label>
				<textarea name="content" id="editor" rows="10" cols="80"></textarea>
		    </div>
		    <button type="submit" id="submitPostBtn">Save</button>
		</form>
	</div>

</body>
</html>