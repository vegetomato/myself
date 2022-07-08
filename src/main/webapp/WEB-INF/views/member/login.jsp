<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<div class="loginForm">
		<h2>로그인 페이지</h2>
		<div class="error">
			<p>${error}</p>
		</div>
		<form action="${contextPath}/login" method="post">
			<div class="form-group">
				<input type="text" name="username" placeholder="아이디" class="form-control">
			</div>
			<div class="form-group">
				<input type="text" name="password" placeholder="비밀번호" class="form-control">
			</div>
			<div class="form-group">
				<button class="btn btn-primary">로그인</button>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		</form>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
<style>
	.loginForm{width: 400px ; margin : auto}
</style>