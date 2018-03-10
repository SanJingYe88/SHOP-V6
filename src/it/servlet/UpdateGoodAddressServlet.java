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
 * 修改收货地址
 * 
 * 从goodAddress.jsp的a标签传入,转发到goodAdress.jsp
 * 
 * */
@WebServlet("/UpdateGoodAddressServlet")
public class UpdateGoodAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//获取请求来源
		String retUrl = request.getHeader("Referer");
		System.out.println(retUrl);
		
		//判空
		if(retUrl == null || "".equals(retUrl.trim())){
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
			return;
		}
		
		GoodService service = new GoodServiceImpl();
		String id = request.getParameter("addressId");

		if(retUrl.contains("GoodAddressServlet")){
			GoodAddress goodAddress = service.findGoodAddressById(Integer.parseInt(id));
			request.setAttribute("goodAddress", goodAddress);
			request.getRequestDispatcher("updateGoodAddress.jsp").forward(request, response);
			return;
		}
		
		if(retUrl.contains("UpdateGoodAddressServlet")){
			User user = (User) request.getSession(false).getAttribute("user");
			
			String address = request.getParameter("address");
			String postCode = request.getParameter("postCode");
			
			//封装数据
			GoodAddress goodAddress = new GoodAddress();
			goodAddress.setId(Integer.parseInt(id));
			goodAddress.setAddress(address);
			goodAddress.setPostCode(postCode);
			
			//更新数据
			service.updateGoodAddress(goodAddress);
			
			//从数据库中查找所有的收货地址,并转发.
			List<GoodAddress> list = service.findGoodAddressByUserId(user.getId());
			request.setAttribute("list", list);
			request.getRequestDispatcher("goodAdress.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
