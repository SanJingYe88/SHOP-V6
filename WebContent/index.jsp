<%@page import="java.util.ArrayList"%>
<%@page import="it.entity.GoodType"%>
<%@page import="it.entity.User"%>
<%@page import="it.entity.Good"%>
<%@page import="java.util.List"%>
<%@page import="it.service.impl.GoodServiceImpl"%>
<%@page import="it.service.GoodService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>简易网上商城</title>
<style type="text/css">
  a { text-decoration:none}
  .div1 {width: 150px;height: 30px}
  .div2 {width: 200px;height: 30px}
  .div3 {width: 250px;height: 300px}
  .div4 {width: 500px;height: 300px}
  .div5 {height: 80px}
  .header{height:80px;}
  h1{float:left;margin-left:200px;}
  h3{float:right;margin-right:100px;cursor:pointer;}
</style>
</head>

<body>
	<%-- 头部 --%>
	<jsp:include page="top.jsp"></jsp:include>
	
	<form action="LikeSearchServlet" method="post" name="search">
		<table align="center">
			<tr align="center">
				<%
					GoodService service = new GoodServiceImpl();
					//获取商品类别
					List<GoodType> goodTypes = service.findAllGoodTypes();
					pageContext.setAttribute("goodTypes", goodTypes);
				%>
				<c:forEach var="goodType" items="${pageScope.goodTypes }" >
					<td>
						<div class="div1">
							<a href="SearchServlet?shopType=${goodType.id }">${goodType.name }</a>
						</div>
					</td>
				</c:forEach>
					
				<td><div class="div2">
					<input type="text" name="likeSearch">
					<input type="submit" value="查找">
				</div></td>
			</tr>
			<tr>
				<td colspan="5"><br></td>
			</tr>
			<%
				List<Good> list = null;
				Object typeId = request.getAttribute("typeId");
				Object likeSearch = request.getAttribute("likeSearch");
				
				if(typeId != null || likeSearch != null){
					list = (List<Good>) request.getAttribute("list");
				}else{
					list = service.findAllGoods();
				}
				int tr = 1;					//商品显示的行数
				int lasttr = 0;				//最后一行显示的商品数量
				if(list.size() % 5 == 0){
					tr = list.size() / 5;
				}else{
					tr = (list.size() / 5) + 1;
					lasttr = list.size() % 5;
				}
			%>
			
			<%
					//循环每一行商品
					for(int i = 0; i < tr; i++){
			%>
				<tr>
			<%
						//循环每一行中的每个商品
						for(int j = 0; j < 5; j++){			//每行显示5个商品
							int index = i*5+j;				//当前商品在list中的位置
							if(index == list.size()){		//全部遍历完毕
								break;
							}
							Good good = list.get(index);
							pageContext.setAttribute("good", good);
			%>
					<td><div class="div3">
						<a href="GoodDetailServlet?goodid=${pageScope.good.id }">
							<img src="${pageScope.good.picPath }"/><br/>
							${pageScope.good.name }<br/>
							<font style="color: red">¥ ${pageScope.good.price }</font>
						</a>
						</div>
					</td>
			<%
						}
			%>
				</tr>
			<%
				}
			%>
		</table>
		<br>
		<hr>
		<div class="div5" align="center"><a href="#top">回到顶部</a></div>
	</form>
</body>
</html>