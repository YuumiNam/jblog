<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Spring 이야기</h1>
			<ul>
				<!-- header -->
				<c:import url="/WEB-INF/views/includes/header.jsp" />
			</ul>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin/write">글작성</a></li>
				</ul>
		      	<table class="admin-cat">
			      	<tr>
			      		<th>번호</th>
			      		<th>카테고리명</th>
			      		<th>포스트 수</th>
			      		<th>설명</th>
			      		<th>삭제</th>      			
			      	</tr>
			      		<c:forEach items = '${list }' var ='vo' varStatus = 'status'>
			      			<tr>
								<td>[${status.index + 1}]</td>
								<td>${vo.title }</td>
								<td>${vo.postCount }</td>
								<td>${vo.expla }</td>
								<td><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin/category/delete/${vo.no }"><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></a></td>
							</tr>
						</c:forEach>			  
				</table>
      			
      			<h4 class="n-c">새로운 카테고리 추가</h4>
      			<form class="category-form" method="post" action="${pageContext.request.contextPath}/blog/${authUser.id }/admin/category">
			      	<table id="admin-cat-add">
			      		<tr>
			      			<td class="t">카테고리명</td>
			      			<td><input type="text" name="title"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">설명</td>
			      			<td><input type="text" name="expla"></td>
			      		</tr>
			      		<tr>
			      			<td class="s">&nbsp;</td>
			      			<td><input type="submit" value="카테고리 추가"></td>
			      		</tr>      		      		
			      	</table>
		      	</form>
			</div>
		</div>
		
		<!-- footer -->
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
		
	</div>
</body>
</html>