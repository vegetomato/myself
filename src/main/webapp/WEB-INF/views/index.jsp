<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<a href="?lang=ko">한국어</a>
	<a href="?lang=en">영어</a>
</div>
<spring:message code="board.bno" /><br>
<spring:message code="board.title" /><br>
<spring:message code="board.content" /><br>
<spring:message code="board.writer" />
</body>
</html>