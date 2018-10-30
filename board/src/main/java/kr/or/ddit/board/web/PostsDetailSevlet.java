package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.CommentVo;
import kr.or.ddit.board.vo.FileVo;
import kr.or.ddit.board.vo.PostsVo;

@WebServlet("/postsDetail")

public class PostsDetailSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardServiceInf bsi = new BoardService();
		String postsId = request.getParameter("postsId");
		
		PostsVo postsVo = bsi.selectPosts(Integer.parseInt(postsId));
		List<FileVo> fileVo = bsi.selectFile(Integer.parseInt(postsId));
		
	
		request.setAttribute("postsVo", postsVo);
		request.setAttribute("fileVo", fileVo);
		
		
		/************* 댓글 리스트 *****************/
		
		List<CommentVo> comList = bsi.selectComment(Integer.parseInt(postsId));
		
		request.setAttribute("comList", comList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/view.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
