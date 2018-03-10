package it.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterSuccessServlet")
public class RegisterSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String yes = request.getParameter("yes");
		
		try {
			if("是".equals(yes)){
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/error/error.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
