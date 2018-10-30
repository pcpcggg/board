package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.NoticeVo;
import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.user.vo.UserVo;

@WebServlet("/loginBoard")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
	
		String rememberMe = request.getParameter("remember-me");
		System.out.println("rememberMe :" + rememberMe);
		
		if(rememberMe == null){
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				System.out.println(cookie.getName());
				
				if(cookie.getName().equals("remember")||
				  cookie.getName().equals("userId")){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}

		else{

			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdCookie = new Cookie("userId", userId);
			
			response.addCookie(cookie);
			response.addCookie(userIdCookie);
		}
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw =response.getWriter();

		UserServiceInf userS = new UserService();
		
		UserVo usv = userS.selectUser(userId);

		String encryptPass = KISA_SHA256.encrypt(password);
		
		System.out.println(password);
		
		System.out.println(usv);
		System.out.println(usv.authPass(encryptPass));
		
		
		if(usv != null && usv.authPass(encryptPass)){
			BoardServiceInf bsi = new BoardService();
			List<NoticeVo> menuList = bsi.select_menu();
			getServletContext().setAttribute("menuList", menuList);
			
			request.getSession().setAttribute("S_USER", usv);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

		}else{
			response.sendRedirect("/login/login.jsp");
		}
	}

}
