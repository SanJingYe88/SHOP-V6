package it.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.entity.BuyHistory;
import it.entity.User;
import it.service.GoodService;
import it.service.impl.GoodServiceImpl;

/*
 * 删除购物历史
 * 
 * 从buyHistory.jsp接收
 * 转发到buyHistory.jsp
 * */
@WebServlet("/DeleteBuyHistoryServlet")
public class DeleteBuyHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		//判空
		if(id == null || "".equals(id.trim())){
			request.getRequestDispatcher("buyHistory.jsp").forward(request, response);
			return;
		}
			
		try {
			User user = (User) request.getSession(false).getAttribute("user");
			
			int id2 = Integer.parseInt(id);
			
			//从数据库中删除购物历史
			GoodService service = new GoodServiceImpl();
			service.deleteBuyHistoryById(id2);
			
			//从数据库中查找所有的收货地址,并转发.
			List<BuyHistory> list = service.findBuyHistory(user.getId());
			request.setAttribute("list", list);
			
			request.setAttribute("msg", "删除成功!");
			request.getRequestDispatcher("buyHistory.jsp").forward(request, response);
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
