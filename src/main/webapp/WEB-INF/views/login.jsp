<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="/WEB-INF/views/included/included_head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>KAKAO FRIENDS SHOP</title>
</head>
<body>
	<div id="login-wrapper"
		style="padding: 2em 1em 0.1em 1em; display: flex; justify-content: center; align-items: center; width: 100%; height: 100%; text-align: center;">
		
		<div class="login-form">
			<div class="text-info">LOGIN</div>
			<div class="input-form">
				<form class="input-form">
					<div class="one-layers">
						<input type="text" id="id" name="id" placeholder="ID...">
					</div>
					<div class="one-layers">
						<input type="password" id="password" name="password"
							placeholder="PASSWORD..." />
					</div>
					<input type="button" class="button big" value="LOGIN"
						onclick="loginCheckButtonClickEvent()"> <input
						type="button" class="button big" value="CANCEL"
						onclick="homeButtonClickEvent()">
					<div class="one-layers">
						<input type="button" class="button big" value="SIGN UP"
						onclick="signupButtonClickEvent()" style="width: 100%; margin-top:1em;">
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/included/included_foot.jsp"%>
</body>
</html>