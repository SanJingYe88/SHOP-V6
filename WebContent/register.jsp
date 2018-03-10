<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<p align="center" style="color:red;">${requestScope.msg}</p>
	<form action="RegisterServlet" method="post">
		<table align="center">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="passWord" /></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="点击注册" /></td>
			</tr>
		</table>
	</form>
</body>
</html>