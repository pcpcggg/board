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

@WebServlet("/updateComment")
public class UpdateCommentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String po_id = request.getParameter("po_id");
		int co_id = Integer.parseInt(request.getParameter("co_id"));
		String co_delete = request.getParameter("co_delete");
		
		CommentVo comVo = new CommentVo();
		comVo.setCo_id(co_id);
		comVo.setCo_delete(co_delete);
		
		BoardServiceInf bsi = new BoardService();
		
		int delete = bsi.deleteComment(comVo);
		
		response.sendRedirect("postsDetail?postsId="+po_id);
		
	}

}
