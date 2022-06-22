<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script>let contextPath = '${contextPath}'</script>
<script src="${contextPath }/resources/js/reply.js"></script>
</head>
<body>
	
	<header>
		<nav class="navbar navbar-expand-sm bg-light">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="${contextPath}">HOME
						</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/board/list">BOARD-LIST</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/member/list">MEMBER-LIST</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/member/register">MEMBER-REGISTER</a></li>
			</ul>
		</nav>
	</header>
