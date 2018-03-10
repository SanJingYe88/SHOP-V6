<%@page import="it.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改密码</title>
<style type="text/css">
  a { text-decoration:none}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<p style="color:red" align="center">${requestScope.msg }</p>
	<form action="UpdatePassWordServlet" method="post">
		<table align="center">
			<tr>
				<td>输入旧密码:</td>
				<td><input type="password" name="old"></td>
			</tr>
			<tr>
				<td>输入新密码:</td>
				<td><input type="password" name="new1"></td>
			</tr>
			<tr>
				<td>再次输入新密码:</td>
				<td><input type="password" name="new2"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="点击修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>