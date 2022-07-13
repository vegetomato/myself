<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
<sec:authentication property="principal.memberVO.userId" var="userId"/>
	<div class="loginForm">
		<h2>회원 페이지</h2>
		<a href="${contextPath }/customLogout">로그아웃</a><br>
		<a href="${contextPath }/anno/myPage/${userId}">마이페이지</a>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
<style>
	.loginForm{width: 400px ; margin : auto}
</style>