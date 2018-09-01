
var contextPath = "/KakaoFriendsShop";


var contextPath = fn_GetContextRoot();

/**
 * 마이페이지
 * 컨텍스트패스 설정
 */
function fn_GetContextRoot() {
	var offset=location.href.indexOf(location.host)+location.host.length;
	var UniPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
	return UniPath;
};

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