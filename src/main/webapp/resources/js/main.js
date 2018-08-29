
$(document).ready(function() {
		/* checkSession();
		 setTextAnimation();
		 setImgSize();*/
	
	 	$('.bx-wrapper').bxSlider();
	 	
	 	
});

/***************************************************************************
 * 함수
 **************************************************************************/

//컨트롤러 호출
function callController(url) {
	$(location).attr('href', url);
}


/***************************************************************************
 * 클릭 이벤트 각종 버튼, 리소스 클릭 시 
 **************************************************************************/

function loginButtonClickEvent(){
	callController('/login');
}

//로그인 버튼 클릭
function loginCheckButtonClickEvent(){
	
	var id = $('#id').val();
	var password = $('#password').val();
	
	// 로그인 버튼 클릭시	
	$.ajax({
		url : "/loginCheck",
		type : "post",
		data : {
					"id" : id,
					"password" : password
				},
		success : 
			function(userMap) {
				if (!userMap) {
					alertify.alert("알림", "로그인 정보가 없습니다.");
				}
				
				else {
					var user = userMap.user;	
					callController('/songihome/?id=' + user.id +"&password=" + user.password);
				}
		}
	});
}