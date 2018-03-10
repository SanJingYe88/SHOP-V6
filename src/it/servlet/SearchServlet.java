package it.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.entity.Good;
import it.service.GoodService;
import it.service.impl.GoodServiceImpl;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String shopType = request.getParameter("shopType");
		
		//判空
		if(shopType == null || "".equals(shopType.trim()) ){
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		try {
			//转型
			int typeId = Integer.parseInt(shopType);
			
			GoodService service = new GoodServiceImpl();
			List<Good> list = service.findGoodByType((Integer)typeId);
			
			request.setAttribute("list", list);
			request.setAttribute("typeId", typeId);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch (NumberFormatException e) {
			System.out.println("商品类别编号不合法");
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
