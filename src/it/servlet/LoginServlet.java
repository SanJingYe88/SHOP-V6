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
 * 登录时所用的servlet
 * 
 * 从login.jsp页面传入
 * 登录成功: 转发到index.jsp
 * 登录失败: 转发到login.jsp
 * */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		//判空
		if(userName.trim().length() == 0 || passWord.trim().length() == 0){
			System.out.println("用户名或密码不能为空");
			response.sendRedirect("login.jsp");
			return;
		}
		
		try {
			
			User user = new User();
			user.setUserName(userName);
			user.setPassWord(passWord);
			
			UserService service = new UserServiceImpl();
			user = service.login(user);
			
			if(user == null){
				request.setAttribute("msg", "用户名或密码不正确!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}

			//创建session
			request.getSession().setAttribute("user", user);
			
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
