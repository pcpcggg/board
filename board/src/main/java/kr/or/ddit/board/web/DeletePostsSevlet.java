package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.PostsVo;

@WebServlet("/deletePosts2")
public class DeletePostsSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int po_id = Integer.parseInt(request.getParameter("postsId"));
		String po_delete = request.getParameter("po_delete");
		int nt_id = Integer.parseInt(request.getParameter("nt_id"));
		
		PostsVo postsVo = new PostsVo();
		postsVo.setPo_id(po_id);
		postsVo.setPo_delete(po_delete);
		
		BoardServiceInf bsi = new BoardService(); 
		
		int deleteCnt = bsi.deletePosts(postsVo);
		
		response.sendRedirect("/boardS?pageId="+nt_id+"&page=1&pageSize=10");
		
	}

}
