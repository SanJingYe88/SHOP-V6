<%@page import="it.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
</head>
<body>
	<div class="header">
		<a name="top"></a>
		<h1><a href="index.jsp">简易网上商城</a></h1>
		<h3><a href="userInfo.jsp">个人中心</a></h3>
		<h3><a href="shopCar.jsp">购物车</a></h3>
		
		<%
			User user = (User) request.getSession(false).getAttribute("user");
			pageContext.setAttribute("user", user);
		%>
		<%-- 是否显示用户名 --%>
		<c:choose>
			<c:when test="${not empty user }">
				<h3><a href="userInfo.jsp">${user.userName }</a></h3>
			</c:when>
			<c:otherwise>
				<h3><a href="login.jsp">点击登录</a></h3>
			</c:otherwise>
		</c:choose>
	</div>
	<hr>
</body>
</html>