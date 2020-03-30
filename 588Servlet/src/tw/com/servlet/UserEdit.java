package tw.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.User;
import tw.com.web.web.UserDao;

/**
 * Servlet implementation class UserEdit
 */
@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>> Servlet Start UserEdit #doGet :  >>>>");
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>> Servlet Start UserEdit #doPost:  >>>>");

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		System.out.println(">>>> Servlet Start UserEdit :  >>>>" + userId);
		List<User> list = null;
//		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = null;
		
		try {
			UserDao dao = new UserDao();
			int delCount = dao.del(userId);
			
			if (delCount > 0) {
				list = dao.getAll();
			}
			
			response.setContentType("application/json; charset=utf-8");
			out = response.getWriter();
			
			request.setAttribute("userList", list);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/UserOverview.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

}
