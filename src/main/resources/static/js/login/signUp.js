$(document).ready(function(){
	
	/*아이디 중복체크 확인*/
	$('#checkUsername').click(function(){
		let userId = $('#username').val();
		
		if(userId === ''){
			alert("아이디를 입력하세요.");
	        return;
		}
		// 아이디에 영어 대소문자와 숫자만 허용, 그 외는 거부
		let validPattern = /^[a-zA-Z0-9]+$/; // 영문 대소문자와 숫자만 허용
		if(!validPattern.test(userId)) {
		    alert("아이디에는 영어 대소문자와 숫자만 사용할 수 있습니다.");
		    return;
		}
		
		$.ajax({
			url : '/signUp/checkId',
			method : 'GET',
			data : {
				userId
				},
			success : function(data){
				
			},
			error: function(xhr, status, error) {
				console.error('에러 발생:', error); // 에러 처리
			}
		});
		
		
	});
	
	
	
	
	
	
});