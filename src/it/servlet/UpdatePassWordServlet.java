package it.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.entity.User;
import it.service.UserService;
import it.service.impl.UserServiceImpl;

/*
 * 更改用户密码
 * 
 * 从userInfo.jsp传入
 * 更改成功后,重定向到login.jsp
 * */
@WebServlet("/UpdatePassWordServlet")
public class UpdatePassWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String old = request.getParameter("old");
		String new1 = request.getParameter("new1");
		String new2 = request.getParameter("new2");
		
		//判空
		if(old == null || "".equals(old.trim()) || new1 == null || "".equals(new1.trim()) ||
				new2 == null || "".equals(new2.trim())){
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("updatePassWord.jsp").forward(request, response);
			return;
		}
		
		//密码长度应小于10位,并且大于6位
		if(old.length() > 10 || old.length() < 6 || new1.length() > 10 || new1.length() < 6 ||
				new2.length() > 10 || new2.length() < 6 ){
			request.setAttribute("msg", "密码不能超过10位,也不能小于6位");
			request.getRequestDispatcher("updatePassWord.jsp").forward(request, response);
			return;
		}
		
		if(!new1.equals(new2)){		//两次密码不同
			request.setAttribute("msg", "两次输入的新密码不同,请重新输入");
			request.getRequestDispatcher("updatePassWord.jsp").forward(request, response);
			return;
		}
		
		try {
			User user = (User) request.getSession(false).getAttribute("user");
			
			UserService service = new UserServiceImpl();
			boolean isExists = service.findUser(user.getUserName(), old);
			
			if(!isExists){	//该用户不存在,说明旧密码输入错误
				request.setAttribute("msg", "旧密码输入错误");
				request.getRequestDispatcher("updatePassWord.jsp").forward(request, response);
				return;
			}
			
			//在数据库中更新密码
			user.setPassWord(new2);
			service.updatePassWord(user);
			
			request.setAttribute("msg", "更改密码成功");
			response.sendRedirect("login.jsp");
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
