package tw.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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

		Map<String, Object> result = new HashMap<String, Object>();
		PrintWriter out = null;
		Gson g = new Gson();
		String body = getBody(request);
		System.out.println("UserAddServlet#doPost body "+body);
		AddUserInput inputBody = g.fromJson(body, AddUserInput.class);
		System.out.println(">>>>>> UserAddServlet inputBody : ");
		response.setContentType("application/json; charset=utf-8");
		out = response.getWriter();
		UserDao dao = new UserDao();
		int count = dao.addUser(inputBody);

	
		result.put("add", count);
		out.print(new Gson().toJson(result));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
