$(document).ready(function(){
	
	let id = '';
	let passWord = '';
	let nickName = '';
	let eMail = '';
	let number = '';
	
	
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
		
		// 아이디 길이 제한 (5자 이상 15자 이하)
		if(userId.length < 5 || userId.length > 50) {
		    alert("아이디는 5자 이상 50자 이하로 입력해야 합니다.");
		    return;
		}
		
		$.ajax({
			url : '/signUp/checkId',
			method : 'GET',
			data : {
				userId
				},
			success : function(data){
				if(data===false){
					alert("사용 가능한 아이디입니다.");
					id=userId;
				}else{
					alert("중복된 아이디입니다.");
					id='';
				}
			},
			error: function(xhr, status, error) {
				console.error('에러 발생:', error); // 에러 처리
			}
		});
		
	});
	/*닉네임 중복체크*/
	$('#checkNickname').click(function(){
		let userNickName = $('#nickname').val();
		
		if(userNickName === ''){
			alert("닉네임을 입력하세요.");
	        return;
		}
		let validPattern = /^[a-zA-Z0-9가-힣]+$/;
		if(!validPattern.test(userNickName)) {
			alert("닉네임은 한글, 영어 대소문자, 숫자만 가능합니다.");
			return;
		}
		
		if(userNickName.length > 20) {
		    alert("닉네임은 20자 이하로 입력해야 합니다.");
		    return;
		}
		
		$.ajax({
			url : '/signUp/checkNickName',
			method : 'GET',
			data : {
				userNickName
			},
			success : function(data){
				if(data===false){
					alert("사용 가능한 닉네임입니다.");
					nickName=userNickName;
				}else{
					alert("중복된 닉네임입니다.");
					nickName='';
				}
			},error: function(xhr, status, error){
				console.error('에러 발생:', error); // 에러 처리
			}
		})
	});
	
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
			url : '/signUp/checkEmail',
			method : 'POST',
			data : {
				userEmail
			},
			success : function(data){
				if(data===false){
					alert("인증번호가 발송되었습니다.");
					eMail=userEmail;
				}else{
					alert("중복된 이메일입니다.");
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
			url : '/signUp/checkNumber',
			method : 'POST',
			data : {
				eMail,userNumber
			},
			success : function(data){
				if(data === 'no'){
					alert("인증번호 입력 시간이 지났습니다. 다시 인증번호를 받아주세요.");
					number = 'ng';
				}else if(data === 'good'){
					alert("인증이 완료되었습니다.");
					number = 'good';
				}else {
					alert("인증번호를 확인 후 다시 입력해주세요.");
					number = 'ng';
				}
					
				
			},error: function(xhr, status, error){
				console.error('에러 발생:', error); // 에러 처리
			}
		})
		}else if(eMail===''){
			alert("먼저 이메일을 입력 후 인증번호를 받아주세요.");
		}
	});	
	
	/*회원가입 확인 버튼*/
	$('#signUp').click(function(){
		passWord = $('#password').val();
		console.log(id, passWord, nickName , eMail , number);
		
		if(id==='' || passWord==='' || nickName==='' || eMail==='' || (number === 'ng' || number === '')){
			alert('중복확인 및 인증번호를 확인해주세요.');
			return;
		}
			
		$.ajax({
			url : '/signUp/form',
			method : 'POST',
			data : {
				id,passWord,nickName,eMail
			},success : function(data){
				if(data==='/login/signUp'){
					alert('회원가입을 다시 시도해주세요.');
					window.location.href = data;
				}else{
				alert('회원가입 완료!')
				window.location.href = data;
				}
				
			},error: function(xhr, status, error){
				console.error('에러 발생:', error); // 에러 처리
			}
		});
			
	
	});
	
});