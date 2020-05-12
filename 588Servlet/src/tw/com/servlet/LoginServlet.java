package tw.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.web.web.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		System.out.println("LoginServlet#doGet start");
		try {
			response.setContentType("application/json; charset=utf-8");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("LoginServlet#doGet  ERROR " + e.toString());
		} finally {
			// TODO: handle finally clause
			System.out.println("LoginServlet#doGet FINAL");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/login.jsp");
			view.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet#doPost start");
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		out = response.getWriter();

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		
		String getPassword = userDao.findPWByUserId(userId);
		
		if (getPassword == null) {
			request.setAttribute("errorMessage", "帳號不存在！");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/login.jsp");
			view.forward(request, response);
			return;
		}
		
		if (!getPassword.equals(password) ) {
			request.setAttribute("errorMessage", "密碼錯誤！");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/login.jsp");
			view.forward(request, response);
			return;
		}
		
		String sessionId = session.getId();
		System.out.println(">>>>> sessionId : " + sessionId + userId );
		userDao.saveSession(userId, sessionId);
		session.setAttribute("userId", userId);
		request.setAttribute("successMessage", "登入成功！");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
		
	}

}
