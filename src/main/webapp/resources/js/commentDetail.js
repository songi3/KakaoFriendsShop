
$(document).ready(function() {
	setCommentInfo();
});

/*******************************************************************************
 * 변수
 ******************************************************************************/

var commentIndex; //게시물 번호

/*******************************************************************************
 * 함수
 ******************************************************************************/

function setCommentInfo(){
	
	var paramsList = location.search.substring(1).split("&"); //파라미터가 담긴 배열
	commentIndex = paramsFunc(paramsList, "commentIndex");	
	
	$.ajax({

		url : "/comment/" + commentIndex + "?commentIndex=" + commentIndex,
		type : "get",
		error : function(comment) {
			alert("해당 게시물이 없습니다.");
		},
		success : function(comment) {
			var commentHeader = $(".comment-header");
			var h1 = commentHeader.children("h1");
			h1.text(comment.title);
			
			var companyDiv = $(".company");
			companyDiv.html("<i class='fa fa-user'></i> " + comment.corp_num);
			
			var regDateDiv = $(".regDate");
			regDateDiv.html("<i class='fa fa-table'></i> " + comment.reg_date);
			
			var commentContent = $(".comment-content");
			commentContent.html(comment.comment);
			
			var priceDiv = $(".price");
			priceDiv.text(comment.price + "원");
		}
	});
	
}

//파라미터명으로 파라미터값 추출

function paramsFunc(paramsList, paramsNm) {

	var nullChk = "";

	for(var i=0; i<paramsList.length; i++) {

		if(paramsNm == paramsList[i].split("=")[0]) {

			return paramsList[i].split("=")[1]; 

		}else {

			if(i == paramsList.length-1) nullChk = true;
		}
	}

	if(nullChk) {
		alertify.alert("경고", "파라미터가 존재하지 않습니다.");
	}
}

/*******************************************************************************
 * 클릭 이벤트 각종 버튼, 리소스 클릭 시
 ******************************************************************************/

/**
 * 상품
 * 상품 구매 버튼 클릭 시 
 * */
function buyButtonClickEvent() {

	var user;
	var product;

	// 로그인 체크
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

			user = sessionLoginInfo;
			
			// 로그인 중
			$.ajax({
				url : "/product/" + commentIndex + "?commentIndex=" + commentIndex,
				type : "get",
				success : function(product) {

					alertify.confirm("구매", product.product_name + "(가격 "
							+ product.price + "원)을(를) 구매하시겠습니까?", 
						function() {
						
						//구매 확인 클릭 시 
						var id = user.id;
						var corp_num = product.corp_num;
						var product_code = product.product_code;
						var product_price = product.price;
						
						$.ajax({

							url : "/orderHistory",
							type : "post",
							data : JSON.stringify({
								"id" : id,
								"corp_num" : corp_num,
								"product_code" : product_code,
								"count" : "1",	
								"settlement_method" : "credit-card",
								"price" : product_price
							}),
							contentType: 'application/json',
							error : function(){
								alertify.alert("경고", "에러발생");
							},
							success : function() {
								alertify.success('구매되었습니다.');
							}
						});
					}, function() {
						//구매 취소 클릭 시 
						alertify.error('취소되었습니다.');
					});
				}
			});
		}
	});
}

