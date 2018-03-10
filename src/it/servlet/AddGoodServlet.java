package it.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 添加商品进购物车
 * 
 * 从goodDetails.jsp转发过来
 * 转发到shopBuy.jsp
 * */

@WebServlet("/AddGoodServlet")
public class AddGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("goodid");
		String num = request.getParameter("goodNum");	//当前数量
		
		//是否存在相同商品的标志
		boolean flag = false;	
		
		try {
			//购物车字符串
			String shopCar = (String) request.getSession().getAttribute("shopCar");
			
			//第一次添加商品时,由于session中没有shopCar,所以返回null,避免后面solit报错,所以需要处理一下
			if(shopCar == null){
				shopCar = "";
			}
			
			//如果购物车为空
			if("".equals(shopCar)){
				shopCar += "/" + id + "&" + num;
			}else {		//购物车不空
				//若购物车里存在该商品,则数量增加.
				String[] arr = shopCar.split("/");
				//i从1开始,越过null
				for(int i = 1; i < arr.length; i++){
					//存在相同id的商品
					if(id.equals(arr[i].split("&")[0])){
						//旧数量
						int oldNum = Integer.parseInt(arr[i].split("&")[1]);
						//新数量
						int newNum = oldNum + Integer.parseInt(num);
						String old = ("/" + id + "&" + oldNum).trim();
						String rep = ("/" + id + "&" + newNum).trim();
						shopCar = shopCar.replace(old,rep);
						flag = true;
						break;
					}
				}
				
				//不存在相同商品
				if(!flag){	
					//商品id&数量
					shopCar += "/" + id + "&" + num;
				}
			}
			
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
