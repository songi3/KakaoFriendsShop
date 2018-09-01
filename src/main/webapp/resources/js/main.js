
var contextPath = fn_GetContextRoot();

$(document).ready(function() {
	checkSession();
	setProductList();
	setTextAnimation();
	$('.bx-wrapper').bxSlider();
});

/**
 * 메인
 * Top 버튼 표시
 */
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


/*******************************************************************************
 * 함수
 ******************************************************************************/

/**
 * 메인 
 * TOP 버튼 클릭 이벤트
 */
function topButtonClickEvent(){
	animateMoveDiv('body', 400);
}

/**
 * 메인 
 * 윈도우 TOP 이동 애니메이션
 */
function animateMoveDiv(divName, duration) {
	var div = $(divName);
	var divOffsetTop = div.offset().top;
	$('html, body').animate({
		scrollTop : divOffsetTop
	}, duration); // 400
}

/**
 * 메인 
 * URL 호출
 */
function callURL(url) {
	$(location).attr('href', contextPath + url);
}

/**
 * 메인
 * 세션 로그인 정보 확인
 */
function checkSession() {

	$.ajax({

		url : contextPath + "/sessionLoginInfo",
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
 * 메인
 * 로그인, 로그아웃 시 상단 네비 메뉴 CSS 설정
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
 * 메인
 * 컨텍스트패스 설정
 */
function fn_GetContextRoot() {
	var offset=location.href.indexOf(location.host)+location.host.length;
	var UniPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
	return UniPath;
};

/**
 * 메인
 * 홈 화면 로딩 시 게시물 목록 표시
 */
function setProductList() {
	
	$.ajax({

		url : contextPath + "/comment",
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
			
			var imgSrc = value.thumbnail;
			href.html("<img src=" + imgSrc + " alt=" + value.index + " />" + "<h3>" + value.title + "</h3>");
			href.appendTo(header);

			var h3 = $("<h3>");
			h3.html(value.title);
			h3.appendTo(header);

			header.appendTo($(articleClassName));

			var p = $("<p>", {
				"class" : "item-subtitle"
			});
			p.html(value.sub_title + "<br>"
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

/**
 * 메인
 * 버튼 클릭
 * 상단 네비 로그인 버튼 클릭 시 login.html 이동
 */
function loginButtonClickEvent() {
	callURL('/login.html');
}

/**
 * 메인
 * 버튼 클릭
 * 상단 네비 홈 버튼 클릭 시 index.html 이동
 */
function homeButtonClickEvent() {
	callURL('');
}

/**
 * 메인
 * 버튼 클릭
 * 상단 네비 마이페이지 버튼 클릭 시 mypage.html 이동
 */
function mypageButtonClickEvent() {
	callURL('/mypage.html');
}

/**
 * 메인
 * 버튼 클릭
 * 상단 네비 회원가입 버튼 클릭 시 signup.html 이동
 */
function signupButtonClickEvent() {
	callURL('/signup.html');
}

/**
 * 메인
 * 버튼 클릭
 * 상단 네비 로그아웃 버튼 클릭 시
 */
function logoutButtonClickEvent() {

	$.ajax({
		url : contextPath + "/user/logout",
		type : "delete",
		success : function() {
			alert("로그아웃 되었습니다.");
			callURL('/');
		}
	});
}

/**
 * 메인
 * 버튼 클릭
 * 프로젝트 / More 버튼 클릭 시
 */
function productDetailEvent(e){
	var commentIndex = e.id;
	callURL('/commentDetail.html?commentIndex=' + commentIndex);
}
	

/***************************************************************************
 * 애니메이션
 **************************************************************************/

function bounceAnimation(item){
	$(item).jAnimate('bounce');
}

function fadeInUpAnimation(item){
	$(item).jAnimate('fadeInUp');
}

function pulseAnimation(item){
	$(item).jAnimate('pulse');
}

function setTextAnimation(){

	$("#header h1").mouseenter(function(){
		pulseAnimation("#header h1");
	  });
}
