<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:choose>
	<c:when test="${empty authUser }">
		<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
		<li><a href="${pageContext.request.contextPath}/blog/index">블로그</a></li>
	</c:when>
	<c:otherwise>
		<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
		<li><a href="${pageContext.request.contextPath}/blog/${userVo.name }/admin">블로그관리</a></li>
		<li><a href="${pageContext.request.contextPath}/blog/index">블로그</a></li>
	</c:otherwise>
</c:choose>