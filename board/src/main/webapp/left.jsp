<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<style>
	.left_menu li:hover a {font-weight: bolder;}
	
</style>
    
<div class="left_menu">
	<ul>
		<li><a href="/notice">게시판 생성</a></li>
		<c:forEach items="${menuList}" var="pv" varStatus="status">
			<li><a href="/boardS?pageId=${pv.nt_id}&page=1&pageSize=10">${pv.nt_name}</a></li>
		</c:forEach>
	</ul>
</div>