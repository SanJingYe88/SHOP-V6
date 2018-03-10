package it.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.entity.Good;
import it.service.GoodService;
import it.service.impl.GoodServiceImpl;

/*
 * 商品详情
 * 
 * 从index.jsp转发过来
 * 转发到goodDetails.jsp
 * */

@WebServlet("/GoodDetailServlet")
public class GoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String goodid = request.getParameter("goodid");
		
		try {
			if(goodid == null || "".equals(goodid.trim())){
				System.out.println("商品id为空");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
			
			// 转换
			int id = Integer.parseInt(goodid);
			
			GoodService service = new GoodServiceImpl();
			Good good = service.findGoodById(id);
			
			request.setAttribute("good", good);
			
			request.getRequestDispatcher("goodDetail.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			System.out.println("商品编号不合法");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
