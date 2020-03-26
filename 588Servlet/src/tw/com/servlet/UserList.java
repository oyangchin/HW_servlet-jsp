package tw.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.bean.User;
import tw.com.input.QueryUserInput;
import tw.com.web.web.UserDao;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserQuery")
public class UserList extends BaseSerlvet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserListServlet#doGet start");
		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = null;
		try {
			response.setContentType("application/json; charset=utf-8");
			out = response.getWriter();
			UserDao dao = new UserDao();
			List<User> list = dao.getAll();
			result.put("list", list);
			request.setAttribute("userList", list);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/UserOverview.jsp");
			view.forward(request, response);
//			out.print(new Gson().toJson(result));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserListServlet#doPost start");

		request.setCharacterEncoding("UTF-8");
		
		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = null;

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		System.out.println("UserListServlet#doPost start"+name+phone);

		
		QueryUserInput queryUserInput = new QueryUserInput();
		queryUserInput.setName(name);
		queryUserInput.setPhone(phone);

		try {
			UserDao dao = new UserDao();
			List<User> list = dao.query(queryUserInput);

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
