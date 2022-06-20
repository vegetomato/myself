<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
<table class="table">
	<h3>자유 게시판</h3>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>E-mail</th>
		<th>Password</th>
	</tr>
	<c:forEach items="${list}" var="b">
	<tr>
		<td>${b.id }</td>
		<td>
		<a href="${b.id}" class="get">${b.userName }</a>
		</td>
		<td>${b.email }</td>
		<td>${b.password }</td>
	</tr>
	</c:forEach>
</table>
<div>
	<a href="register" class="btn btn-primary">회원가입</a>
</div>
<div class="pagination">
<c:if test="${pageMaker.prev }">
	<a href="${pageMaker.startPage-1 }">[이전페이지]</a>
</c:if>
<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
<a href="${pageNum}" class="${pageMaker.criteria.page == pageNum ? 'on' : '' }">[${pageNum}]</a>
</c:forEach>
<c:if test="${pageMaker.next }">
	<a href="${pageMaker.endPage+1 }">[다음페이지]</a>
</c:if>
</div>
</div>
<%@ include file="../layout/footer.jsp"%>