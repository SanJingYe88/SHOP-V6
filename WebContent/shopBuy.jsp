<%@page import="it.entity.GoodAddress"%>
<%@page import="java.util.List"%>
<%@page import="it.service.impl.GoodServiceImpl"%>
<%@page import="it.service.GoodService"%>
<%@page import="it.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付款页面</title>
<style type="text/css">
  a { text-decoration:none}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
</style>

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
	
	<form action="PaySuccessServlet" method="post">
		<table align="center" width="80%">
			<tr>
				<td colspan="3">选择收货地址:</td>
			</tr>
			<tr>
				<td>选择</td>
				<td>地址</td>
				<td>邮编</td>
				<td>电话</td>
			</tr>
			<%
				GoodService service = new GoodServiceImpl();
				List<GoodAddress> list = service.findGoodAddressByUserId(user.getId());
				pageContext.setAttribute("size", list.size());
				pageContext.setAttribute("list", list);
			%>
			<c:choose>
				<c:when test="${not empty list }">
					<c:forEach var="goodAddress" items="${pageScope.list }" varStatus="vs">
						<tr>
							<!-- 指定第一个地址被选中 -->
							<c:if test="${vs.count == 1 }">
								<td><input type="radio" name="address" value="${goodAddress.id }" checked></td>
							</c:if>
							<c:if test="${vs.count != 1 }">
								<td><input type="radio" name="address" value="${goodAddress.id }"></td>
							</c:if>
							
							<td>${goodAddress.address }</td>
							<td>${goodAddress.postCode }</td>
							<td>${pageScope.user.phone }</td>
						</tr>
					</c:forEach>
					<% // 收货地址小于3个时,可以添加  %>
					<c:if test="${size < 3 }">
						<tr>
							<td colspan="3"><a href="GoodAddressServlet">添加新的收货地址.</a></td>
						</tr>
					</c:if>
					<tr><td colspan="3"><hr></td></tr>
					<tr>
						<td colspan="3" align="center">
							<font style="color: red">${msg }</font>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><img src="pic/sk.png"></td>
					</tr>
					<tr>
						<td colspan="3" align="center">扫一扫,完成付款</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<input type="submit" value="完成付款">
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>还没有收货地址,<a href="goodAddress.jsp">点击添加!</a></td>
					</tr>
				</c:otherwise>
			</c:choose>
			
		</table>
	</form>
</body>
</html>