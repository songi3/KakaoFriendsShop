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

		<section class="content">
		<div class="wrap district-services">
			<div class="signup-form">
				<div class="text-info">회원가입</div>
				<div class="input-form">
					<form class="input-form">
						<div class="one-layers">
							<input type="text" id="id" name="id" placeholder="ID...">
						</div>
						<div class="one-layers">
							<input type="password" id="password" name="password"
								placeholder="PASSWORD..." />
						</div>
						<div class="two-layers">
							<input type="text" id="name" name="name" placeholder="NAME..."
								style="margin-right: 0.5em;" /> <input type="text" id="phone"
								name="phone" placeholder="PHONE NUMBER..." />
						</div>
						<div class="one-layers">
							<input type="email" id="email" name="email"
								placeholder="EMAIL..." />
						</div>
						<div class="one-layers">
							<input type="text" id=address name="address"
								placeholder="ADDRESS..." />
						</div>

						<input type="button" class="button big" value="SIGN UP"
							onclick="signupCommitButtonClickEvent()"
							style="width: 100%; margin-top: 1em;"> <input
							type="button" class="button big" value="CANCEL"
							onclick="homeButtonClickEvent()"
							style="width: 100%; margin-top: 1em;">

					</form>
				</div>
			</div>
		</div>
		</section>

	</div>

</body>
</html>