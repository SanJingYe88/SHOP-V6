<%@page import="it.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<style>
  a { text-decoration:none}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
  table{float:right;margin-right:100px;margin-top:60px;}
  form{width:800px;margin:0 auto;height:400px;}
  img{margin-top:50px;}
  tr{height:50px;}
  #num{width:75px;height:50px;float:left;}
  #show{width:48px;height:48px;float:left;text-align:center;line-height:50px;font-size:30px;border:0;}
  #up{font-size:20px;width:25px;height:25px;float:right;transform:rotateX(180deg);text-align:center;cursor:pointer;}
  #down{font-size:20px;width:25px;height:25px;float:right;text-align:center;cursor:pointer;}
  .button{height:30px;margin-top:10px;margin-left:40px;}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<%-- requestScope.good 是从GoodDetailServlet中传过来的  --%>
	<form action="AddGoodServlet?goodid=${requestScope.good.id }" method="post" name="search">
		<img src="${requestScope.good.picPath }">
		<table>
			<tr>
				<td>商品编号:&nbsp;<b>${requestScope.good.id }</b></td>
			</tr>
			<tr>
				<td>商品名字:&nbsp;<b>${requestScope.good.name }</b></td>
			</tr>
			<tr>
				<td>商品价格:&nbsp;<font style="color: red"><b>¥${requestScope.good.price }</b></font></td>
			</tr>
			<tr>
				<td>累计销量:&nbsp;<b>${requestScope.good.xl }</b></td>
			</tr>
			<tr>
				<c:if test="${requestScope.good.kcl == 0}">
					<td>商品库存量:&nbsp;<b><font style="color: red;">暂时无货</font></b></td>
				</c:if>
				<c:if test="${requestScope.good.kcl != 0}">
					<td>商品库存量:&nbsp;<b>${requestScope.good.kcl }</b></td>
				</c:if>
			</tr>
			<tr>
				<td>
				<div id="num">
					<input id="show" name="goodNum" value="1"/>
					<div id="up"><b>+</b></div>
					<div id="down"><b>-</b></div> 
				</div>
					<c:if test="${requestScope.good.kcl == 0}">
						<input class="button" type="submit" value="加入购物车" disabled="disabled" />
					</c:if>
					<c:if test="${requestScope.good.kcl != 0}">
						<input class="button" type="submit" value="加入购物车" />
					</c:if>
				</td>
			</tr>
		</table>
		<br>
	</form>
	<hr>
		<div class="div5" align="center"><a href="#top">回到顶部</a></div>
		<script>
		window.onload = function(){
			var up = document.getElementById("up");
			var down = document.getElementById("down");
			var show = document.getElementById("show");
			
			up.onclick = function(){
				var n =show.value;
				n++;
				show.value=n;
			}
			down.onclick = function(){
				var n =show.value;
				n--;
				if(n<0){
					show.value=0;
				}else{
					show.value=n;
				}
			}
		}
		</script>
</body>
</html>