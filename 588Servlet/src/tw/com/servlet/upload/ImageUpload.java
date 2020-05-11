package tw.com.servlet.upload;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Servlet implementation class ImageUpload
 */

@MultipartConfig
@WebServlet("/imageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImageUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ImageUploadServlet#doGet start");

		try {

			response.setContentType("application/json; charset=utf-8");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/upload/Image.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ImageUploadServlet#doPost start");

		try {
			Part image = request.getPart("image");
			String filename = image.getSubmittedFileName();
			String fileType = "data:image/jpeg;base64,";

			System.out.println(">>>> filename " + filename);
			InputStream imgInputStream = image.getInputStream();

			byte[] imageBytes = new byte[(int) imgInputStream.available()];
			imgInputStream.read(imageBytes, 0, imageBytes.length);
			imgInputStream.close();

			String imageStr = Base64.encodeBase64String(imageBytes);
			System.out.println(">>>> imageStr " + imageStr);
			System.out.println(">>>> fileType " + fileType);
			request.setAttribute("imageBase64", fileType + imageStr);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/upload/Image.jsp");
			view.forward(request, response);
			System.out.println(">>>> request " + request.getAttribute("imageBase64"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(">>>> fileUpload Error : " + e.toString());
		}

	}

}
