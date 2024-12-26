$(document).ready(function() {
  $('#loginForm').submit(function(event) {
    let username = $('#username').val();
    let password = $('#password').val();

    if (!username) {
      alert("아이디를 입력해주세요.");
      event.preventDefault(); // 폼 제출 중단
    } else if (!password) {
      alert("비밀번호를 입력해주세요.");
      event.preventDefault(); // 폼 제출 중단
    }
  });
  
  let urlParams = new URLSearchParams(window.location.search);
  if (urlParams.get('error') === 'id') {
      alert("아이디가 존재하지 않습니다.");
	  window.location.href = '/';
  } else if (urlParams.get('error') === 'pw') {
      alert("비밀번호가 틀렸습니다.");
	  window.location.href = '/';
  }
  
  
  
  
  
  
});