package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.CommentVo;

@WebServlet("/comment")
public class CommentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int po_id = Integer.parseInt(request.getParameter("po_id")) ;
		String userid = request.getParameter("userId");
		String co_contents = request.getParameter("co_contents");
		
		CommentVo comVo = new CommentVo();
		comVo.setCo_contents(co_contents);
		comVo.setPo_id(po_id);
		comVo.setUserid(userid);
		
		BoardServiceInf  bsi = new BoardService();
		
		int insertComment = bsi.insertComment(comVo);
		
		response.sendRedirect("/postsDetail?postsId="+po_id);
		
	}

}
