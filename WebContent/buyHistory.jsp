<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="it.entity.Good"%>
<%@page import="it.entity.BuyHistory"%>
<%@page import="java.util.List"%>
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
<title>我的购物历史</title>
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
		<tr>
			<td>商品名</td>
			<td>购买数量</td>
			<td>小计</td>
			<td>购买时间</td>
			<td>操作</td>
		</tr>
		<tr>
			<td colspan="5"><hr></td>
		</tr>
		
		<%
			GoodService service = new GoodServiceImpl();
			//List<BuyHistory> list = service.findBuyHistory(user.getId());
			List<BuyHistory> list = (List<BuyHistory>) request.getAttribute("list");
			pageContext.setAttribute("list", list);
		%>
		
		<c:choose>
			<c:when test="${not empty list }">
				<%
					for(int i = 0; i < list.size(); i++){
						BuyHistory buyHistory = list.get(i);
						int g_id = buyHistory.getG_id();			//商品编号
						Good good = service.findGoodById(g_id);
						String name = good.getName();				//商品名
						int id = buyHistory.getId();				//购买记录编号
						String time = buyHistory.getBuyTime();		//购买时间
						int num = buyHistory.getNum();				//购买数量
						int money = buyHistory.getMoney();			//小计 (购买数量*单价)
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String date = sdf.format(new Date(Long.parseLong(time)));
						pageContext.setAttribute("g_id", g_id);
						pageContext.setAttribute("name", name);
						pageContext.setAttribute("id", id);
						pageContext.setAttribute("date", date);
						pageContext.setAttribute("num", num);
						pageContext.setAttribute("money", money);
				%> 
					<tr>
						<td><a href="GoodDetailServlet?goodid=${pageScope.g_id }">${pageScope.name }</a></td>
						<td>${pageScope.num }</td>
						<td><font style="color: red">¥${pageScope.money }</font></td>
						<td>${pageScope.date }</td>
						<td><a href="DeleteBuyHistoryServlet?id=${pageScope.id }">删除</a></td>
					</tr>
				<%
					}
				%>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">购物历史为空!</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="5"><hr></td>
		</tr>
		<tr>
			<td colspan="5">${msg }</td>
		</tr>
		
	</table>
</body>
</html>