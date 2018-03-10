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
	<form action="RegisterSuccessServlet" method="post">
		<table align="center">
			<tr>
				<td colspan="2">是否使用当前注册的用户登录?</td>
			</tr>
			<tr align="center">
				<td><input type="submit" name="yes" value="是"></td>
				<td><input type="submit" name="yes" value="不,我要使用其他用户."></td>
			</tr>
		</table>
	</form>
</body>
</html>