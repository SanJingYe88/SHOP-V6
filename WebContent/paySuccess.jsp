<%@page import="it.entity.GoodAddress"%>
<%@page import="it.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买成功</title>
<style type="text/css">
  a { text-decoration:none}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
</style>

</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<%
		String isBuy = request.getAttribute("isBuy").toString();
		boolean flag = false;
		if("true".equals(isBuy)){
			flag = true;
		}
		pageContext.setAttribute("flag", flag);
	%>
	
	<table align="center">
	<c:choose>
		<c:when test="${flag }">
			<%
				GoodAddress goodAddress = (GoodAddress) request.getAttribute("goodAddress");
				pageContext.setAttribute("goodAddress", goodAddress);
			%>
			<tr>
				<td><font style="color: red">支付成功!</font></td>
			</tr>
			<tr>
				<td>收货人为:</td>
				<td>${pageScope.user.userName }</td>
			</tr>
			<tr>
				<td>收货地址为:</td>
				<td>${goodAddress.address }</td>
			</tr>
			<tr>
				<td><a href="index.jsp">去浏览其他商品!</a></td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td><font style="color: red">支付失败</font>,请<a href="shopCar.jsp">点击重试!</a></td>
			</tr>
		</c:otherwise>
	</c:choose>
	</table>
	
</body>
</html>