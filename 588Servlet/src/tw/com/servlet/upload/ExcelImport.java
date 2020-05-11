package tw.com.servlet.upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.servlet.BaseSerlvet;



/**
 * Servlet implementation class UserList
 */
@WebServlet("/excelImport")
public class ExcelImport extends BaseSerlvet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("excelImportServlet#doGet start");
		try {
			response.setContentType("application/json; charset=utf-8");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/upload/ImportExcel.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause

		}
	}

	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("excelImportServlet#doPost start");
		doGet(request, response);

	}
}
