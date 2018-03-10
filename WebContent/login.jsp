<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
  a { text-decoration:none}
</style>
</head>
<body>
	<p style="color:red" align="center">${requestScope.msg }</p>
	
	<form action="LoginServlet" method="post">
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
				<td colspan="2"><input type="submit" value="点击登录" /></td>
			</tr>
			<tr align="center">
				<td colspan="2"><a href="register.jsp">前去注册</a></td>
			</tr>
		</table>
	</form>
</body>
</body>
</html>