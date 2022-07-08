<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<div class="container">
	<h3>Home</h3>
	<p><a href="${contextPath}/security/all">모든 방문자 허용</a></p>
	<p><a href="${contextPath}/security/member">회원등급 이상</a></p>
	<p><a href="${contextPath}/security/admin">관리자만</a></p>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>