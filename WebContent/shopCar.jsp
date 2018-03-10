<%@page import="it.entity.Good"%>
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
<title>我的购物车</title>
<style type="text/css">
  a { text-decoration:none}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
  tr{height:50px;}
  td{padding-left:50px;}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<form action="ShopBuyServlet" method="post">
		<table align="center">
			<tr>
				<td>选择</td>
				<td>商品名称</td>
				<td>商品单价</td>
				<td>商品数量</td>
				<td>小计</td>
				<td>操作</td>
			</tr>
			<tr><td colspan="6"><hr/></td></tr>
			
			<c:choose>
				<c:when test="${not empty user }">
					<%
						//从AddGoodServlet传过来
						String shopCar = (String) request.getSession(false).getAttribute("shopCar");
						if(shopCar == null || "".equals(shopCar.trim())){
					%>
					<tr>
						<td colspan="6" align="center">购物车为空! <a href="index.jsp">前去购物</a></td>
					</tr>
					<% 
						}else{
							String[] arr = shopCar.split("/");
							for(int i = 1; i < arr.length; i++){
								if("".equals(arr[i].trim())){
									continue;
								}
								//商品编号
								int goodId = Integer.parseInt(arr[i].split("&")[0]);
								//购买数量
								int num = Integer.parseInt(arr[i].split("&")[1]);
								GoodService service = new GoodServiceImpl();
								Good good = service.findGoodById(goodId);
								pageContext.setAttribute("good", good);
								pageContext.setAttribute("num", num);
					%>
						<tr>
							<td><input name="shop" type="checkbox" value="<%=arr[i] %>"></td>
							<td><a href="GoodDetailServlet?goodid=${good.id }">${good.name }</a></td>
							<td>${good.price }</td>
							<td>${num }</td>
							<td class="price">${num * good.price }</td>
							<td><a href="DeleteShopServlet?goodid=${good.id }&num=${num }">删除该商品</a></td>
						</tr>		
					<%		
							}
						}
					%>
					<tr><td colspan="6"><hr/></td></tr>
					<tr>
						<td>全选<input type="checkbox" name="selectShop"></td>
						<td></td><td></td>
						<td>商品总价: </td>
						<td id="zongJia">0</td>
						<td><input type="submit" value="点击购买"></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="6" align="center">
							<h3>您还未登录,请登录后查看.<a href="login.jsp">点击登录</a></h3>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
	
	
	<script>
		window.onload=function(){
			var checkBs = document.getElementsByName("shop");
			var all = document.getElementsByName("selectShop")[0];
			var zongJia = document.getElementById("zongJia");
			var prices = document.getElementsByClassName("price");
		
			//复选框全选按钮
			all.onclick = function(){
				if(all.checked){
					for(var i = 0;i < checkBs.length; i++){	
						checkBs[i].checked = true;
					}
				}else if(!all.checked){
					for(var i = 0;i < checkBs.length; i++){	
						checkBs[i].checked = false;
					}
				}
				var sum = 0;
				for(var j = 0;j < checkBs.length; j++){
					if(checkBs[j].checked){
						var n = parseInt(prices[j].innerHTML);
						sum += n;
					}
				}
				zongJia.innerHTML = sum;
			}
			
			//定义每个checkbox的点击事件
			for(var i = 0;i < checkBs.length; i++){
				checkBs[i].onclick=function(){
					var sum = 0;
					for(var j = 0;j < checkBs.length; j++){
						if(checkBs[j].checked){
							var n=parseInt(prices[j].innerHTML);
							sum += n;
						}
					}
					zongJia.innerHTML = sum;
				}
			}
		}
	</script>
</body>
</html>