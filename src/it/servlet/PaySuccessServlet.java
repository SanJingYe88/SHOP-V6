package it.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.entity.BuyHistory;
import it.entity.GoodAddress;
import it.entity.User;
import it.service.GoodService;
import it.service.impl.GoodServiceImpl;

/*
 * 支付成功
 * 从shopBuy.jsp传过来
 * */

@WebServlet("/PaySuccessServlet")
public class PaySuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//获取选中的
		String str = (String) request.getSession(false).getAttribute("selected");
		
		if(str == null){
			request.getRequestDispatcher("shopBuy.jsp").forward(request, response);
			return;
		}
		
		try {
			User user = (User) request.getSession(false).getAttribute("user");
			if(user == null){
				request.setAttribute("msg", "您为登录, 请登录!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			String[] values = str.split("/");
			List<BuyHistory> list = new ArrayList<BuyHistory>();
			//循环获取传过来的参数值, 并封装
			for(int i = 0; i < values.length; i++){
				//去""
				if("".equals(values[i].trim())){
					continue;
				}
				String id = values[i].split("&")[0];
				String num = values[i].split("&")[1];
				
				BuyHistory bh = new BuyHistory();
				bh.setU_id(user.getId());			//用户id
				bh.setG_id(Integer.parseInt(id));	//商品id
				long time = new Date().getTime();
				bh.setBuyTime(time + "");			//时间
				bh.setNum(Integer.parseInt(num));	//购买数量
				GoodService service = new GoodServiceImpl();
				bh.setMoney(service.findGoodById(Integer.parseInt(id)).getPrice() * Integer.parseInt(num));
				list.add(bh);
			}
			
			//全部插入是否成功的标志,默认全部插入成功
			boolean flag = true;
			if(list != null){
				GoodService service = new GoodServiceImpl();
				for(int i = 0; i < list.size(); i++){
					boolean b = service.addBuyHistory(list.get(i));
					if(!b){	
						flag = false;
						break;
					}
				}
			}
			request.setAttribute("isBuy", flag);
			
			String shopCar = (String) request.getSession(false).getAttribute("shopCar");
			
			shopCar = shopCar.replace(str, "");

			request.getSession(false).setAttribute("shopCar", shopCar);
			
			String address = request.getParameter("address");
			int id = Integer.parseInt(address);
			
			GoodService service = new GoodServiceImpl();
			GoodAddress goodAddress = service.findGoodAddressById(id);
			request.setAttribute("goodAddress", goodAddress);
			
			request.getRequestDispatcher("paySuccess.jsp").forward(request, response);
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
