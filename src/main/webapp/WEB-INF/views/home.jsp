<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="/WEB-INF/views/included/included_head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>KAKAO FRIENDS SHOP</title>
</head>
<body>
	<!-- Wrapper -->
	<div class="outwrapper main">
	
		<!-- Header -->
		<%@ include file="/WEB-INF/views/included/included_header.jsp"%>
		
		<section class="content">
			<div class="wrap">
				<div class="table">
					<div class="table-cell">
						<div class="inner">
							<h2>제품</h2>
						</div>
						<div class="district-services">
							<div class="services" style="zoom: 1; height: 100%;">
								<div class="boxwrap">
									<div class="bx-wrapper">
										<div><img src="${pageContext.request.contextPath}/resources/img/kakaofriends_img_product.png" /></div>
										<div><img src="${pageContext.request.contextPath}/resources/img/kakaofriends_img_product.png" /></div>	
										<div><img src="${pageContext.request.contextPath}/resources/img/kakaofriends_img_product.png" /></div>
										<div><img src="${pageContext.request.contextPath}/resources/img/kakaofriends_img_product.png" /></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<%@ include file="/WEB-INF/views/included/included_fotter.jsp"%>
	</div>
</body>
</html>