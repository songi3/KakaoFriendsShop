
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
 * 마이페이지
 * 버튼 클릭
 * 구매이력 버튼 클릭 시
 */
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

		url : contextPath + "/sessionLoginInfo",
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

					url : contextPath + "/orderHistory/" + sessionLoginInfo.id + "?id=" + sessionLoginInfo.id,
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
		},
		beforeSend : function() { // 로딩 이미지 처리
			$(".loading-image").addClass("on"); // 로딩 이미지 show
			$(".mask").addClass("on"); //마스크 show
			$(".mask").fadeTo("slow", 0.4); // 배경 흐리게 효과
		},
		complete : function() { // 로딩 이미지 사라짐
			$(".loading-image").removeClass("on"); // 로딩 이미지 hide
			$(".mask").fadeTo("slow", 0);
			$(".mask").removeClass("on"); // 마스크 hide
		}
	});
}
