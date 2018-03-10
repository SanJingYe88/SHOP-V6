package it.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 删除商品,从购物车中
 * 
 * 从shopCar.jsp传过来
 * 转发到shopCar.jsp
 * */

@WebServlet("/DeleteShopServlet")
public class DeleteShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//获取要删除的商品的编号和数量
		String goodid = request.getParameter("goodid");
		String num = request.getParameter("num");
		
		//判空
		if(goodid == null || "".equals(goodid.trim())){
			request.getRequestDispatcher("shopCar.jsp").forward(request, response);
			return;
		}

		try {
			
			//shopCar位于session中,保存购物车内的商品的id和数量
			String shopCar = (String) request.getSession(false).getAttribute("shopCar");
			
			//用""替换掉
			shopCar = shopCar.replace("/" + goodid + "&" + num, "");
			
			request.getSession(false).setAttribute("shopCar",shopCar);
			request.getRequestDispatcher("shopCar.jsp").forward(request, response);
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
