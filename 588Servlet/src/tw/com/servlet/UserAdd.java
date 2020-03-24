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
import tw.com.input.AddUserInput;
import tw.com.web.web.UserDao;

/**
 * Servlet implementation class UserAdd
 */
@WebServlet("/UserAdd")
public class UserAdd extends BaseSerlvet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserAddServlet#doPost start");

		List<User> list = null;
		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = null;

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age")) ;
		String country = request.getParameter("country");
		System.out.println("UserListServlet#doPost start"+name+phone+password+userId+country+age);

		
		AddUserInput addUserInput = new AddUserInput();
		addUserInput.setName(name);
		addUserInput.setPhone(phone);
		addUserInput.setAge(age);
		addUserInput.setUserId(userId);
		addUserInput.setPassword(password);
		addUserInput.setCountry(country);
		
		try {
			UserDao dao = new UserDao();
			int addCount = dao.addUser(addUserInput);
			
			if (addCount > 0) {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/UserEdit.jsp");
		view.forward(request, response);
	}

}
