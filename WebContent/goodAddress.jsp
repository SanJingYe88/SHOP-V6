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
<title>收货地址</title>
<style type="text/css">
  a { text-decoration:none}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<form action="AddGoodAddressServlet" method="post">
		<table align="center" width="60%">
			<tr>
				<td colspan="3"><b>添加收货地址:</b></td>
			</tr>
			<tr>
				<td>地址</td>
				<td>邮编</td>
				<td>操作</td>
			</tr>
			<%
				List<GoodAddress> list = (List<GoodAddress>) request.getAttribute("list");
				if(list != null){
					pageContext.setAttribute("size", list.size());
					pageContext.setAttribute("list", list);
				}
			%>
			<c:choose>
				<%-- 收货地址不为空时显示 --%>
				<c:when test="${not empty list }">
					<%-- 循环输出收货地址 --%>
					<c:forEach var="goodAddress" items="${pageScope.list }" varStatus="vs">
						<tr>
							<td>${goodAddress.address }</td>
							<td>${goodAddress.postCode }</td>
							<td><a href="UpdateGoodAddressServlet?addressId=${goodAddress.id }">修改</a>
								<a href="DeleteAddressServlet?addressId=${goodAddress.id }">删除</a>
							</td>
						</tr>
					</c:forEach>
					<%-- 收货地址小于3个时,可以添加 --%>
					<c:if test="${size < 3 }">
						<tr>
							<td><input type="text" name="address"></td>
							<td><input type="text" name="postCode"></td>
							<td><input type="submit" value="添加"></td>
						</tr>
					</c:if>
					<tr><td colspan="3"><hr></td></tr>
				</c:when>
				<%-- 收货地址为空时显示 --%>
				<c:otherwise>
					<tr>
						<td><input type="text" name="address"></td>
						<td><input type="text" name="postCode"></td>
						<td><input type="submit" value="添加"></td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="3"><font style="color: red;">${msg }</font></td>
			</tr>
		</table>
	</form>
</body>
</html>