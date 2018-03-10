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
 * 添加收货地址
 * 
 * 从shopBuy.jsp传入,转发到goodAddress.jsp
 * */
@WebServlet("/AddGoodAddressServlet")
public class AddGoodAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String address = request.getParameter("address");
		String postCode = request.getParameter("postCode");
		
		try {
		
			User user = (User) request.getSession(false).getAttribute("user");
			GoodService service = new GoodServiceImpl();
			
			//从数据库中查找所有的收货地址,并转发.
			List<GoodAddress> list = service.findGoodAddressByUserId(user.getId());
			request.setAttribute("list", list);
			
			//判空
			if(address == null || postCode == null
					|| "".equals(address.trim()) || "".equals(postCode.trim())){
				request.setAttribute("msg", "输入数据不能为空!");
				request.getRequestDispatcher("goodAddress.jsp").forward(request, response);
				return;
			}
			
			//地址长度检验
			if(address.length() > 30){
				request.setAttribute("msg", "输入地址过长!");
				request.getRequestDispatcher("goodAddress.jsp").forward(request, response);
				return;
			}
			
			//邮编长度检验
			if(postCode.length() > 6){
				request.setAttribute("msg", "输入邮编过长,不可以超过6位!");
				request.getRequestDispatcher("goodAddress.jsp").forward(request, response);
				return;
			}
			
			
			GoodAddress goodAddress = new GoodAddress();
			
			//封装数据
			goodAddress.setU_id(user.getId());
			goodAddress.setAddress(address);
			goodAddress.setPostCode(postCode);
			
			//保存收货地址到数据库
			service.addGoodAddress(goodAddress);
			
			//注意: 这里不应该直接加入list集合,这样加入的话,goodAddress对象的id属性没赋值,是0.
			//list.add(goodAddress);
			//所以需要从数据库中读取才行.
			list = service.findGoodAddressByUserId(user.getId());
			request.setAttribute("list", list);
			
			request.setAttribute("msg", "添加地址成功!");
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
