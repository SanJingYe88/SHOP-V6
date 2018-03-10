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
 * 注册时所用的servlet
 * 从register.jsp传入
 * 注册成功: 转发到registerSuccess.jsp
 * 注册失败: 转发到register.jsp
 * */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		//判空
		if(userName.trim().length() == 0 || passWord.trim().length() == 0){
			request.setAttribute("msg", "用户名或密码不能为空");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		//用户名长度应小于16位
		if(userName.length() > 16){
			request.setAttribute("msg", "用户名不能超过16位字符");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		//密码长度应小于10位,并且大于6位
		if(passWord.length() > 10 || passWord.length() < 6){
			request.setAttribute("msg", "密码不能超过10位,也不能小于6位");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		try {
			User user = new User();
			user.setUserName(userName);
			user.setPassWord(passWord);
		
			UserService service = new UserServiceImpl();
			boolean flag = service.register(user);
			
			if(flag){	 // 注册成功，跳转到注册成功界面
				request.getSession().setAttribute("user", user);
				request.setAttribute("msg", "注册成功,可以登录.");
				request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
				return;
			}else {
				request.setAttribute("msg", "用户名已经存在，注册失败！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
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
