package tw.com.servlet.upload;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import tw.com.bean.Currency;
import tw.com.servlet.BaseSerlvet;
import tw.com.web.web.ExcelDao;

/**
 * Servlet implementation class UserList
 */
@MultipartConfig
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

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/upload/ImportExcel.jsp");
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
		System.out.println("excelImportServlet#doPost start");

		try {
			response.setContentType("text/html; charset=utf-8");

			Part filepart = request.getPart("excel");

			InputStream inputstream = null;
			inputstream = filepart.getInputStream();
			HSSFWorkbook wb = new HSSFWorkbook(inputstream);
			HSSFSheet sheet = wb.getSheetAt(2);
			HSSFRow row;

//			List<Currency> rowData = new ArrayList<Currency>();
			
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				
				ExcelDao dao = new ExcelDao();
				Currency data = new Currency();
				Currency data1 = new Currency();
				
				String currency = (String) row.getCell(0).getStringCellValue();
				String type = (String) row.getCell(1).getStringCellValue();
				double money = row.getCell(2).getNumericCellValue();
				double spot =  row.getCell(3).getNumericCellValue();
				
				double forward10 = row.getCell(4).getNumericCellValue();
				double forward30 =  row.getCell(5).getNumericCellValue();
				double forward60 = row.getCell(6).getNumericCellValue();
				double forward90 = row.getCell(7).getNumericCellValue();
				double forward120 =  row.getCell(8).getNumericCellValue();
				double forward150 =  row.getCell(9).getNumericCellValue();
				double forward180 =  row.getCell(10).getNumericCellValue();
				
				data.setCurrency(currency);
				data.setType(type);
				data.setMoney(money);
				data.setSpot(spot);
				data.setForward10(forward10);
				data.setForward30(forward30);
				data.setForward60(forward60);
				data.setForward90(forward90);
				data.setForward120(forward120);
				data.setForward150(forward150);
				data.setForward180(forward180);
				
				System.out.println(">>>>> currency >>>>>>>> " + currency);
				System.out.println(">>>>> spot >>>>>>>> " + spot);
				String type1 =  (String) row.getCell(11).getStringCellValue();
				double money1 = row.getCell(12).getNumericCellValue();
				double spot1 =  row.getCell(13).getNumericCellValue();
			
				double forward101 =  row.getCell(14).getNumericCellValue();
				double forward301 =  row.getCell(15).getNumericCellValue();
				double forward601 =  row.getCell(16).getNumericCellValue();
				double forward901 =  row.getCell(17).getNumericCellValue();
				double forward1201 =  row.getCell(18).getNumericCellValue();
				double forward1501 =  row.getCell(19).getNumericCellValue();
				double forward1801 =  row.getCell(20).getNumericCellValue();
				
				data1.setCurrency(currency);
				data1.setType(type1);
				data1.setMoney(money1);
				data1.setSpot(spot1);
				data1.setForward10(forward101);
				data1.setForward30(forward301);
				data1.setForward60(forward601);
				data1.setForward90(forward901);
				data1.setForward120(forward1201);
				data1.setForward150(forward1501);
				data1.setForward180(forward1801);
				System.out.println(">>>>> data >>>>>>>> " + data.getCurrency());
				dao.insertData(data);
				System.out.println(">>>>> data1 >>>>>>>> " + data1.getType());
				dao.insertData(data1);
//				rowData.add(data);
//				rowData.add(data1);
				System.out.println(">>>>> type1 >>>>>>>> " + type1);
				
			}
			
//			for (Currency item : rowData) {
//				ExcelDao dao = new ExcelDao();
//				dao.InsertData(item);
//			}

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/upload/ImportExcel.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause

		}
	}
}
