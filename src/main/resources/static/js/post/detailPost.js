$(document).ready(function() {
    // 삭제 버튼 클릭 시 확인 메시지 표시
    $('.deleteBtn').click(function() {
        let confirmed = confirm("정말 삭제하시겠습니까?");  // confirm을 사용해야 합니다.
        
        // 사용자가 확인을 클릭시 ajax 전달
        if (confirmed) {
            
			let postNo = $('#postNo').val();
			
			$.ajax({
				url : '/deletePost',
				method : 'DELETE',
				data : {postNo : postNo},
				success: function(response) {
					if(response === 'good'){
					    // 삭제 성공 시 처리할 코드
					    alert('게시글이 삭제되었습니다.');
					    window.location.href = "/myPost";
					}else {
						alert('다시 시도해주세요.');
					}
				},
				error: function(xhr, status, error) {
				    // 삭제 실패 시 처리할 코드
				    alert('삭제에 실패했습니다. 다시 시도해 주세요.');
				}				
				
			});
			
			
			
        }
    });
});