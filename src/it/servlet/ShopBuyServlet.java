package it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.entity.User;

/*
 * 商品购买
 * 从shopCar.jsp传过来
 * 转到shopBuy.jsp
 * */

@WebServlet("/ShopBuyServlet")
public class ShopBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//获取多选框的值
		String[] values = request.getParameterValues("shop");
		
		try {
			//判空
			if(values == null || values.length <= 0){
				request.setAttribute("msg", "请选择要购买的商品!");
				request.getRequestDispatcher("shopCar.jsp").forward(request, response);
				return;
			}

			User user = (User) request.getSession(false).getAttribute("user");
			
			//判空
			if(user == null){
				request.setAttribute("msg", "您为登录, 请登录!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			String str = "";
			
			for (int i = 0; i < values.length; i++) {
				str += "/" + values[i];
			}
			
			request.getSession().setAttribute("selected", str);
			
			request.getRequestDispatcher("shopBuy.jsp").forward(request, response);
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
