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
  
	$('#editPostBtn').click(function(){
		
		let postNo = $('#postNo').val();
		let postTitle = $('#postTitle').val();
		let postContent = CKEDITOR.instances.editor.getData();
		
		//게시글 수정
		$.ajax({
			url : '/editPostWrite',
			method : 'PATCH',
			data : {
				postNo : postNo,
				postTitle : postTitle,
				postContent : postContent
			},
			success: function(response) {
				if(response === 'good'){
				    // 삭제 성공 시 처리할 코드
				    alert('게시글이 수정되었습니다.');
				    window.location.href = "/detailPost?postNo="+postNo;
				}else {
					alert('다시 시도해주세요.');
				}
			},
			error: function(xhr, status, error) {
			    // 삭제 실패 시 처리할 코드
			    alert('삭제에 실패했습니다. 다시 시도해 주세요.');
			}		
		});
	})
  
  
  
  
});