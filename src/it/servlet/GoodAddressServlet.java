package it.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.entity.GoodAddress;
import it.entity.User;
import it.service.GoodService;
import it.service.impl.GoodServiceImpl;


/*
 * 获取所有的收货地址
 * 
 * 从shopBuy.jsp的a标签传入,转发到goodAddress.jsp
 * 从userInfo.jsp的a标签传入,转发到goodAddress.jsp
 * */

@WebServlet("/GoodAddressServlet")
public class GoodAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		try {
			User user = (User) request.getSession(false).getAttribute("user");
			
			//从数据库中查找所有的收货地址,并转发.
			GoodService service = new GoodServiceImpl();
			List<GoodAddress> list = service.findGoodAddressByUserId(user.getId());
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("goodAddress.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			return;
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
