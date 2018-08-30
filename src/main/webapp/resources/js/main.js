
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

//홈 화면 상품 리스트 출력 
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
				ul.html("<li><a href='#' class='button' onclick='purchaseProductEvent(this)' id=" + value.index + ">Purchase</a></li>");
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

// 회원가입 버튼 클릭시	
function signupCommitButtonClickEvent(){
	var id = $('#id').val();
	var password = $('#password').val();
	var name = $('#name').val();
	var email = $('#email').val();
	var phone = $('#phone').val();
	var address = $('#address').val();

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
		dataType:"JSON",
		success : 
			function(errorMsgs) {
			
			if(errorMsgs != null){
				var message = "";
				$.each(errorMsgs, function(key, value){
					message = message + value + "<br>";	
				});
				
				alertify.alert("경고", message);
			}
			else {
				callController('/');
			}
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
					callController('/');
				}
		}
	});
}

//상품 구매 창
function purchaseProductEvent(e){

	var commentIndex = e.id;
	var user;
	var product;
	
	//로그인 체크
	$.ajax({

		url : "/sessionCheck",
		type : "get",
		success : function(sessionLoginInfo) {
			
			user = sessionLoginInfo;
			
			if (!sessionLoginInfo) { // 로그아웃 중
				alertify.confirm("알림", "로그인이 필요합니다. 로그인창으로 이동하시겠습니까?",
				function(){
					loginButtonClickEvent();
				},
				function(){
				    
				});
			}
			
			else { //로그인 중
				
				$.ajax({

					url : "/purchaseProduct",
					type : "get",
					data : {
						"commentIndex" : commentIndex
					},
					success : function(productMap) {
						
						product = productMap.product;
						
						alertify.confirm("구매", product.product_name + "(가격 " + product.price + ")를 구매하시겠습니까?",
						  function(){
							
							var id = user.id;
							var corp_num = product.corp_num;			
							var product_code = product.product_code;
							
							$.ajax({

								url : "/purchaseProductCommit",
								type : "post",
								data : {
									"id" : id,
									"corp_num" : corp_num,
									"product_code" : product_code,
									"count" : "1",
									"settlement_method" : "credit-card"
								},
								success : function() {
									 alertify.success('구매되었습니다.');
								}
								});
						  },
						  function(){
						    alertify.error('취소되었습니다.');
						  });
					}
				});
	
			}
		}
	});
}

//로그아웃 버튼 클릭
function logoutButtonClickEvent(){
	callController('/logout');
}