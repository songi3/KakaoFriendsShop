
$(document).ready(function() {
		checkSession();
	/* 
		 setTextAnimation();
		 setImgSize();*/
		setProductList();
		
	 	$('.bx-wrapper').bxSlider();
	 	
	 	
});

/***************************************************************************
 * 함수
 **************************************************************************/

//컨트롤러 호출
function callController(url) {
	$(location).attr('href', url);
}

function checkSession() {
	$.ajax({

		url : "/sessionCheck",
		type : "get",
		success : function(sessionCheck) {
			if (!sessionCheck) { // 로그아웃 중
				setLogin();

			} else { // 로그인 중
				setLogout();
			}
		}
	});
}

function setLogout() {
	$('.login-btn').addClass("on");
	$('.logout-btn').addClass("on");
}

function setLogin(){
	$('.login-btn').removeClass("on");
	$('.logout-btn').removeClass("on");
}

function setProductList(){
	
	$.ajax({

		url : "/setCommentList",
		type : "get",
		success : function(productList) {
			$.each(productList, function(key, value){
				var article = $("<article>", {"class" : "item " + value.index + "_item"});
				article.appendTo($(".items"));
				
				var articleClassName = "." + value.index + "_item";
				var headerClassName = "." + value.index + "_header";
				
				var header = $("<header>");
				
				var href = $("<a>", {"href" : "#", "onclick" : "productDetailEvent(this)", "id" : value.index});
				var imgSrc = "/" + value.thumbnail;
				href.html("<img src=" + imgSrc + " alt=" + value.index + " />" + "<h3>" + value.title + "</h3>");	
				href.appendTo(header);
				
				var h3 = $("<h3>");
				h3.html(value.sub_title);
				h3.appendTo(header);
				
				header.appendTo($(articleClassName));
				
				var p = $("<p>" , {"class" : "item-subtitle"});
				p.html(value.title + "<br>" + value.price + "원");
				p.appendTo($(articleClassName));
				
				var ul = $("<ul>" , {"class" : "actions"});
				ul.html("<li><a href='#' class='button' onclick='commentDetailEvent(this)' id=" + value.index + ">More</a></li>");
				ul.appendTo($(articleClassName));
			
			})

		}
	});
}

/***************************************************************************
 * 클릭 이벤트 각종 버튼, 리소스 클릭 시 
 **************************************************************************/

function loginButtonClickEvent(){
	callController('/login');
}

function homeButtonClickEvent(){
	callController('/');
}

function signupButtonClickEvent(){
	callController('/signup');
}

function signupCommitButtonClickEvent(){
	var id = $('#id').val();
	var password = $('#password').val();
	var name = $('#name').val();
	var email = $('#email').val();
	var phone = $('#phone').val();
	var address = $('#address').val();

	// 회원가입 버튼 클릭시	
	$.ajax({
		url : "/signupCommit",
		type : "post",
		data : {
					"id" : id,
					"password" : password,
					"name" : name,
					"email" : email,
					"phone" : phone,
					"address" : address
				},
		success : 
			function() {
			callController('/');
		}
	});
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
					callController('/');
				}
		}
	});
}

//로그아웃 버튼 클릭
function logoutButtonClickEvent(){
	callController('/logout');
}