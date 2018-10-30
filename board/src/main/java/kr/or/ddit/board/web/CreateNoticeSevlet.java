package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.NoticeVo;
import kr.or.ddit.user.vo.UserVo;

@WebServlet("/createNotice")
public class CreateNoticeSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		UserVo useridVo = new UserVo();
		
		useridVo = (UserVo) request.getSession().getAttribute("S_USER");
		
		String userId = useridVo.getUserId() ;
		System.out.println("userId :" +userId);
		String nt_name = request.getParameter("nt_name");
		System.out.println("nt_name :" +nt_name);
		String nt_ues = request.getParameter("nt_ues");
		
		NoticeVo noticeVo = new NoticeVo();
		noticeVo.setUserid(userId);
		noticeVo.setNt_name(nt_name);
		noticeVo.setNt_ues(nt_ues);

		BoardServiceInf bsi = new BoardService();
		int insertNoticeCnt = bsi.insertNotice(noticeVo);
		
		List<NoticeVo> menuList = bsi.select_menu();
		getServletContext().setAttribute("menuList", menuList);
		
		response.sendRedirect("/notice");
	}

}
