$(document).ready(function(){
	
	let eMail = '';
	
	$('#sendEmailVerification').click(function(){
		let userEmail = $('#email').val();
		
		if(userEmail === ''){
			alert("이메일을 입력하세요.");
	        return;
		}
		let validPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
		if(!validPattern.test(userEmail)){
			alert("입력된 이메일을 확인해주세요.");
			return;
		}
		
		$.ajax({
			url : '/findId/checkEmail',
			method : 'POST',
			data : {
				userEmail
			},
			success : function(data){
				if(data===true){
					alert("인증번호가 발송되었습니다.");
					eMail=userEmail;
				}else{
					alert("등록되지 않은 이메일입니다.");
					eMail='';
				}				
			},error: function(xhr, status, error){
				console.error('에러 발생:', error); // 에러 처리
			}
		})
	});

	$('#checkEmailVerification').click(function(){
		if(eMail!==''){
		let userNumber = $('#emailVerification').val();
		
		if(userNumber === ''){
			alert("인증번호를 입력하세요.");
	        return;
		}
		
		$.ajax({
			url : '/findId/checkNumber',
			method : 'POST',
			data : {
				eMail,userNumber
			},
			success : function(data){
				if(data === 'no'){
					alert("인증번호 입력 시간이 지났습니다. 다시 인증번호를 받아주세요.");
				}else if(data === 'ng'){
					alert("인증번호를 확인 후 다시 입력해주세요.");
				}else {
					$('#overlay').addClass('show');
					$('#userId').val(data);
				}
					
				
			},error: function(xhr, status, error){
				console.error('에러 발생:', error); // 에러 처리
			}
		})
		}else if(eMail===''){
			alert("먼저 이메일을 입력 후 인증번호를 받아주세요.")
		}
	});	
	$('#changePassword').click(function(){
		let id = $('#userId').val();
		let newPassword = $('#newPassword').val();
		
		if(newPassword === ''){
			alert('새 비밀번호를 입력해주세요');
			return;
		}
		
		$.ajax({
			url : '/findId/changePassword',
			method : 'POST',
			data : {id, newPassword},
			success : function(data){
				window.location.href = data;		
			},error: function(xhr, status, error){
				console.error('에러 발생:', error); // 에러 처리
			}
		});
		
		
	});
	
	
	
});