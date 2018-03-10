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


@WebServlet("/LikeSearchServlet")
public class LikeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String likeSearch =request.getParameter("likeSearch");
		
		try {
			//判空
			if(likeSearch == null || "".equals(likeSearch.trim()) ){
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
			
			GoodService service = new GoodServiceImpl();
			List<Good> list = service.findGoodByName((String)likeSearch);
			
			request.setAttribute("list", list);
		
			request.setAttribute("likeSearch", likeSearch);
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
