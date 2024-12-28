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
  
  
  
  
  
  
});