$(document).ready(function() {
	
	// CKEditor를 텍스트 영역에 적용
	CKEDITOR.replace('editor', {
		width: 700,
		height: 600,  // 높이 설정 추가
	    toolbar: [
	        { name: 'basicstyles', items: ['Bold', 'Italic', 'Underline'] },
	        { name: 'paragraph', items: ['NumberedList', 'BulletedList'] },
	        { name: 'links', items: ['Link', 'Unlink'] },
	        { name: 'tools', items: ['Maximize'] }
	    ]
	});
	
	// ckeditor가 다 로드되고 나서 실행	
	CKEDITOR.instances.editor.on('instanceReady', function() {
		// 폼 제출 전에 제목과 내용이 비어있는지 확인
		$('#postForm').submit(function (event) {
		    let title = $('#title').val().trim();  // 제목 값 가져오기
		    let content = CKEDITOR.instances.editor.getData().trim();   // 내용 값 가져오기
	
		    // 제목이나 내용이 비어 있으면 에러 메시지 출력
		    if (title.length === 0) {
		        alert("제목을 입력해주세요.");
		        event.preventDefault();  // 폼 제출 막기
				return false;
		    }
	
		    if (content.length === 0) {
		        alert("내용을 입력해주세요.");
		        event.preventDefault();  // 폼 제출 막기
				return false;
		    }
			
			return true;
	
		    
		});
  	});	
  
  
  
});