package tw.com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public abstract class BaseSerlvet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String getBody(HttpServletRequest request) throws IOException {
		
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			in = request.getInputStream();
			isr = new InputStreamReader(in, Charset.forName("UTF-8"));
			br = new BufferedReader(isr);
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			// 最先创建的最后关，最后创建的最先关
			// 关闭最外面的 最外面的关闭里面的 里面的关闭更里面的
			br.close();
			isr.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				System.out.print("Close BufferedReader Error : " + e);
			}

		}
		return sb.toString();
	}

}
