
var contextPath = fn_GetContextRoot();

/**
 * 로그인 
 * URL 호출
 */
function callURL(url) {
	$(location).attr('href', contextPath + url);
}

/**
 * 로그인
 * 컨텍스트패스 설정
 */
function fn_GetContextRoot() {
	var offset=location.href.indexOf(location.host)+location.host.length;
	var UniPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
	return UniPath;
};

/**
 * 로그인 
 * 로그인 페이지 정보 입력 후 로그인 버튼 클릭 시
 */
function loginCheckButtonClickEvent() {

	var id = $('#id').val();
	var password = $('#password').val();

	$.ajax({
		url : contextPath + "/user/login",
		type : "post",
		data : JSON.stringify({
			"id" : id,
			"password" : password
		}),
		contentType: 'application/json',
		error : function() {
			alertify.alert("알림", "로그인 정보가 없습니다.");
		},
		success : function(userMap) {
			alert("로그인 되었습니다.");
			callURL('/');
		}
	});
}