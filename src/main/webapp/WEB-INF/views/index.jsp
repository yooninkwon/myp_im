<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/static/css/index.css" />
</head>
<body>
	<jsp:include page="main/header.jsp"/>
    <div class="main-container">
        <div class="main-message">
            <h1>지금 <span>당신의 이야기</span>를 기다리는 사람들이 있습니다.</h1>
            <p>말하지 못한 이야기도 괜찮아요. 여기에 남기고, 함께 나눠요.</p>
        </div>

        <div class="categories">
            <div class="category-box">
                <h2>누구야</h2>
                <p>여기에서 당신을 소개해주세요. 이름이나 간단한 한 줄 소개만으로도 좋아요!</p>
            </div>
            <div class="category-box">
                <h2>이렇게 살아왔어</h2>
                <p>지금까지 걸어온 당신의 발자취를 나눠주세요. 삶의 여정은 특별하니까요.</p>
            </div>
            <div class="category-box">
                <h2>고민이 있어</h2>
                <p>누구에게도 말하지 못한 고민, 이곳에서 털어놓고 함께 고민해봐요.</p>
            </div>
            <div class="category-box">
                <h2>숨겨둔 비밀</h2>
                <p>말하지 못한 마음속 비밀, 익명으로라도 가볍게 털어놔 보세요.</p>
            </div>
            <div class="category-box">
                <h2>자유게시판</h2>
                <p>자유롭게 이야기하고 싶은 모든 것을 나눠보세요. 주제는 자유!</p>
            </div>
        </div>
    </div>

</body>
</html>