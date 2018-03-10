<%@page import="it.entity.GoodAddress"%>
<%@page import="it.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改收货地址</title>
<style type="text/css">
  a { text-decoration:none}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<form action="UpdateGoodAddressServlet" method="post">
		<table align="center" width="60%">
			<tr>
				<td colspan="3"><b>修改收货地址:</b></td>
			</tr>
			<tr>
				<td>地址</td>
				<td>邮编</td>
				<td>操作</td>
			</tr>
			<%
				GoodAddress goodAddress = (GoodAddress) request.getAttribute("goodAddress");
				pageContext.setAttribute("goodAddress", goodAddress);
			%>
			<tr>
				<td><input type="text" name="address" value="${goodAddress.address }"></td>
				<td><input type="text" name="postCode" value="${goodAddress.postCode }"></td>
				<td>
					<input type="submit" value="修改">
					<a href="DeleteAddressServlet?addressId=${goodAddress.id }">删除</a>
				</td>
			</tr>
			<tr>
				<td colspan="3"><font style="color: red;">${msg }</font></td>
			</tr>
		</table>
	</form>
</body>
</html>