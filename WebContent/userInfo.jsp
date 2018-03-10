<%@page import="it.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<style type="text/css">
  a { text-decoration:none}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<table align="center" width="50%">
		<c:choose>
			<c:when test="${not empty user }">
				<tr>
					<td><a href="updatePassWord.jsp">修改密码!</a></td>
				</tr>
				<tr>
					<td><a href="BuyHistoryServlet">查看购物历史!</a></td>
				</tr>
				<tr>
					<td><a href="GoodAddressServlet">管理收货地址!</a></td>
				</tr>
				<tr>
					<td><a href="ExitServlet">退出登录!</a></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td align="center">
						<h3>您还未登录,请登录后查看.<a href="login.jsp">点击登录</a></h3>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>