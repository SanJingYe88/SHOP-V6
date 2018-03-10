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
 * 删除收货地址
 * 
 * 从goodAddress.jsp接收,转发到goodAddress.jsp
 * 
 * */
@WebServlet("/DeleteAddressServlet")
public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String addressId = request.getParameter("addressId");
		
		//判空
		if(addressId == null || "".equals(addressId.trim())){
			request.getRequestDispatcher("goodAddress.jsp").forward(request, response);
			return;
		}
		
		try {
			User user = (User) request.getSession(false).getAttribute("user");
			
			int id = Integer.parseInt(addressId);
			
			//从数据库中删除收货地址
			GoodService service = new GoodServiceImpl();
			service.deleteGoodAddressById(id);
			
			//从数据库中查找所有的收货地址,并转发.
			List<GoodAddress> list = service.findGoodAddressByUserId(user.getId());
			request.setAttribute("list", list);
			
			request.setAttribute("msg", "删除收货地址成功!");
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
