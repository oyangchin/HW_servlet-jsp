package tw.com.framwork;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tw.com.web.web.UserDao;

@WebFilter("/*")
public class FilterWork implements Filter {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		
		System.out.println("CharsetEncodingFilter--->>>begin");
		//設置字符集
		request.setCharacterEncoding("GB18030");
		HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        
        //
//        if (requestURI.endsWith("login")) {
//			doFilter
//		}
        
		if (requestURI.endsWith("login")) {
			HttpSession session = req.getSession();
			String userId = request.getParameter("userId");
			UserDao userDao = new UserDao();
			System.out.println(" doFilter userId : " +  userId);
			
			Boolean isSession = userDao.checkSession(userId);
			System.out.println("CharsetEncodingFilter--->>>isSession " + isSession);
			if (!isSession) {
				req.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			}
			if (isSession) {
				String newSessionId = session.getId();
				String currentSessionId = userDao.getSessionByUserID(userId);
				System.out.println("CharsetEncodingFilter--->>>newSessionId " + newSessionId );
				System.out.println("CharsetEncodingFilter--->>>currentSessionId " + currentSessionId );
				if (!newSessionId.equals(currentSessionId)) {
					System.out.println("CharsetEncodingFilter--->>> newSessionId !== newSessionId "  );
					// 清空 sessionID
					userDao.saveSession(userId,"");
					// 回傳 此帳號已登入
					request.setAttribute("message", "此帳號已登入～～～～～");
					req.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				}
				if (newSessionId.equals(currentSessionId)) {
					System.out.println("CharsetEncodingFilter--->>> newSessionId === newSessionId "  );
					// 回傳 登入成功
					request.setAttribute("message", "登入成功～～～～～");
					req.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
				}
				
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
			
//            req.getRequestDispatcher(newURI).forward(req, res);
        } else {
            chain.doFilter(request, response);
        }
		
		if (!requestURI.endsWith("login")) {
			
		}
		
//		//繼續執行
//		chain.doFilter(request, response);
		System.out.println("CharsetEncodingFilter--->>>end");
	}

//	@Override
//	//初始化方法
//	public void init(FilterConfig filterConfig) throws ServletException {
//		this.endcoding=filterConfig.getInitParameter("encoding");
//		System.out.println("CharsetEncodingFilter.init()--->>endcoding=" + endcoding);
//	}

}
