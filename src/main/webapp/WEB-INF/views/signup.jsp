<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<%-- <%@ include file="/WEB-INF/views/included/included_head.jsp"%> --%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>KAKAO FRIENDS SHOP</title>
</head>
<body>
	
	<div id="signup-wrapper"
		style="padding: 2em 1em 0.1em 1em; display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; text-align: center;">
	
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
							style="margin-right: 0.5em;" /> <input type="text" id="phone_number"
							name="phone_number" placeholder="PHONE NUMBER..." />
					</div>
					<div class="one-layers">
						<input type="email" id="email" name="email" placeholder="EMAIL..." />
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
	<%-- <%@ include file="/WEB-INF/views/included/included_foot.jsp"%> --%>
</body>
</html>