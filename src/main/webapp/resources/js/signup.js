
var contextPath = "/KakaoFriendsShop";

/**
 * 회원가입 
 * 회원가입 페이지 정보 입력 후 SIGN UP 버튼 클릭 시
 */
function signupCommitButtonClickEvent() {
	
	var id = $('#id').val();
	var password = $('#password').val();
	var name = $('#name').val();
	var email = $('#email').val();
	var phone_number = $('#phone_number').val();
	var address = $('#address').val();

	$.ajax({
		url : contextPath + "/user",
		type : "post",
		data : JSON.stringify({
			"id" : id,
			"password" : password,
			"name" : name,
			"email" : email,
			"phone_number" : phone_number,
			"address" : address
		}),
		contentType: 'application/json',
		error : function(errorMsgs) {
			if (errorMsgs != null && errorMsgs != "") {
				var message = "";
				$.each(errorMsgs, function(key, value) {
					message = message + value + "<br>";
				});

				alertify.alert("경고", message);
			}
		},
		success : function(errorMsgs) {
			alert("회원가입 되었습니다.");
			callURL('/');
			
		}
	});
}