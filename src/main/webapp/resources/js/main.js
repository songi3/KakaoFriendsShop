$(document).ready(function() {
	checkSession();
	/*
	 * setTextAnimation(); setImgSize();
	 */
	setProductList();

	$('.bx-wrapper').bxSlider();

	setIncludeHtml();
});

/*******************************************************************************
 * 함수
 ******************************************************************************/

function setIncludeHtml() {
	/*
	 * $("head").load("/included/included_head.html");
	 * $("#footer").load("/included/included_foot.html");
	 */
}

function topButtonClickEvent(){
	animateMoveDiv('body', 400);
}

//애니메이션 해당 div 이동
function animateMoveDiv(divName, duration) {
	var div = $(divName);
	var divOffsetTop = div.offset().top;
	$('html, body').animate({
		scrollTop : divOffsetTop
	}, duration); // 400
}

// 컨트롤러 호출
function callURL(url) {
	$(location).attr('href', url);
}

/**
 * 로그인 
 * 세션 로그인 정보 확인
 */
function checkSession() {

	$.ajax({

		url : "/sessionLoginInfo",
		type : "post",
		error : function(sessionLoginInfo) {
			setLogin();
		},
		success : function(sessionLoginInfo) {
			if (sessionLoginInfo) { // 로그인 중 
				setLogout();
			}
		}
	});
}

/**
 * 로그인 
 * CSS 설정 
 * 로그인 시 로그아웃버튼, 마이페이지 버튼 보임 로그아웃 시 로그인 버튼 보임
 */
function setLogout() {
	$('.login-btn').addClass("on");
	$('.logout-btn').addClass("on");
	$('.mypage-btn').addClass("on");
}

function setLogin() {
	$('.login-btn').removeClass("on");
	$('.logout-btn').removeClass("on");
	$('.mypage-btn').removeClass("on");
}

/**
 * Comment
 * 홈 화면 로딩 시 게시물 목록 표시
 */
function setProductList() {

	$.ajax({

		url : "/comment",
		type : "get",
		success : function(commentsList) {
			$.each(commentsList, function(key, value) {
				var article = $("<article>", {
					"class" : "item " + value.index + "_item"
			});
				
			article.appendTo($(".items"));
			var articleClassName = "." + value.index + "_item";
			var headerClassName = "." + value.index + "_header";
			var header = $("<header>");
			var href = $(
			"<a>",
			{
				"href" : "#",
				"onclick" : "productDetailEvent(this)",
				"id" : value.index
			});
			
			var imgSrc = "/" + value.thumbnail;
			href.html("<img src=" + imgSrc + " alt=" + value.index + " />" + "<h3>" + value.title + "</h3>");
			href.appendTo(header);

			var h3 = $("<h3>");
			h3.html(value.sub_title);
			h3.appendTo(header);

			header.appendTo($(articleClassName));

			var p = $("<p>", {
				"class" : "item-subtitle"
			});
			p.html(value.title + "<br>"
					+ value.price + "원");
			p.appendTo($(articleClassName));

			var ul = $("<ul>", { "class" : "actions" });
			ul.html("<li><a href='#' class='button' onclick='productDetailEvent(this)' id=" + value.index
							+ ">MORE</a></li>");
			ul.appendTo($(articleClassName));
			})
		}
	});
}

/*******************************************************************************
 * 클릭 이벤트 각종 버튼, 리소스 클릭 시
 ******************************************************************************/

//TOP 버튼
$(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() > 500) {
			$('.topMoveBtn').fadeIn();
		} else {
			$('.topMoveBtn').fadeOut();
		}
	});

	$(".topMoveBtn").click(function() {
		topButtonClickEvent();
	});
	return false;
});


/**
 * 로그인
 * 버튼 클릭
 * 상단 네비 로그인 버튼 클릭 시 login.html 이동
 */
function loginButtonClickEvent() {
	callURL('../../login.html');
}

/**
 * 홈
 * 버튼 클릭
 * 상단 네비 홈 버튼 클릭 시 index.html 이동
 */
function homeButtonClickEvent() {
	callURL('/');
}

/**
 * 마이페이지
 * 버튼 클릭
 * 상단 네비 마이페이지 버튼 클릭 시 mypage.html 이동
 */
function mypageButtonClickEvent() {
	callURL('../../mypage.html');
}

/**
 * 회원가입
 * 버튼 클릭
 * 상단 네비 회원가입 버튼 클릭 시 signup.html 이동
 */
function signupButtonClickEvent() {
	callURL('../../signup.html');
}

/**
 * 로그인
 * 버튼 클릭
 * 상단 네비 로그아웃 버튼 클릭 시
 */
function logoutButtonClickEvent() {

	$.ajax({
		url : "/user/logout",
		type : "delete",
		success : function() {
			alert("로그아웃 되었습니다.");
			callURL('/');
		}
	});
}

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
		url : "/user",
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

/**
 * 로그인 
 * 로그인 페이지 정보 입력 후 로그인 버튼 클릭 시
 */
function loginCheckButtonClickEvent() {

	var id = $('#id').val();
	var password = $('#password').val();

	$.ajax({
		url : "/user/login",
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



// 프로젝트, 커멘트 디테일 페이지 이동
function productDetailEvent(e){
	var commentIndex = e.id;
	callURL('/commentDetail.html?commentIndex=' + commentIndex);
}
	
function orderhistoryListClickEvent() {

	var pListOrderhistory = $('.list-orderhistory');
	var table = $(".list-orderhistory-table");
	
	var headerDetail = $(".header-detail");
	headerDetail.addClass("on");
	
	//초기화
	table.empty();
	
	var tr = $("<tr>");
	var th = $("<th>");
	th.text("아이디");
	th.appendTo(tr);
	
	var th = $("<th>");
	th.text("구매 품명");
	th.appendTo(tr);
	
	var th = $("<th>");
	th.text("구매 시간");
	th.appendTo(tr);
		
	var th = $("<th>");
	th.text("구매 방법");
	th.appendTo(tr);
	
	var th = $("<th>");
	th.text("가격");
	th.appendTo(tr);
	
	var th = $("<th>");
	th.text("수량");
	th.appendTo(tr);
	
	var th = $("<th>");
	th.text("총 구매 가격");
	th.appendTo(tr);
	
	tr.appendTo(table);

	$.ajax({

		url : "/sessionLoginInfo",
		type : "post",
		error : function(sessionLoginInfo) {	
			// 로그아웃 중
			alertify.confirm("알림", "로그인이 필요합니다. 로그인창으로 이동하시겠습니까?",
				function() {
					loginButtonClickEvent();
				}, function() {
					alertify.error('취소되었습니다.');
			});
		},
		success : function(sessionLoginInfo) {
			if (sessionLoginInfo) { // 로그인 중 
				
				$.ajax({

					url : "/orderHistory/" + sessionLoginInfo.id + "?id=" + sessionLoginInfo.id,
					type : "get",
					error : function(sessionLoginInfo) {
						
					},
					success : function(orderHistoriesList) {
						if (orderHistoriesList) { // 로그인 중 
							
							
							var pListOrderhistory = $('.list-orderhistory');
				
							$.each(orderHistoriesList, function(key, value) {
								
								var tr = $("<tr>");
								
								var td = $("<td>");
								td.text(value.id);
								td.appendTo(tr);
								
								var td = $("<td>");
								td.text(value.product_code);
								td.appendTo(tr);
								
								var td = $("<td>");
								td.text(value.reg_date);
								td.appendTo(tr);
								
								var td = $("<td>");
								td.text(value.settlement_method);
								td.appendTo(tr);
								
								var td = $("<td>");
								td.text(value.price);
								td.appendTo(tr);
								
								var td = $("<td>");
								td.text(value.count);
								td.appendTo(tr);
								
								var td = $("<td>");
								td.text(value.price * value.count);
								td.appendTo(tr);
						
								tr.appendTo(table);
								
							});		
						}
					}
				});
			}
		}
	});
}

