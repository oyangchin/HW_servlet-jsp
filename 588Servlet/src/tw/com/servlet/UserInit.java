package tw.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.User;
import tw.com.web.web.UserDao;

/**
 * Servlet implementation class UserInit
 */
@WebServlet("/UserInit")
public class UserInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println(">>>> Servlet Start UserInit #doPost:  >>>>");

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		System.out.println(">>>> Servlet Start UserEdit :  >>>>" + userId);
//		List<User> list = null;
//		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = null;
		
		try {
			UserDao dao = new UserDao();
			User user = dao.getById(userId);
			
			
			
			response.setContentType("application/json; charset=utf-8");
			out = response.getWriter();
			
			request.setAttribute("user", user);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/UserEdit.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
		
	}

}
