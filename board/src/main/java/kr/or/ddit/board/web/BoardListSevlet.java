package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.PostsVo;
import kr.or.ddit.board.vo.PageVo;


@WebServlet("/boardS")
public class BoardListSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 전체 사용자 정보조회
		BoardServiceInf postService = new BoardService();
		List<PostsVo> postList = postService.boardListAll();
		
		// 해당 게시판 게시물 숫자
		int nt_id = Integer.parseInt(request.getParameter("pageId"));
		int BoardCnt = postService.getBoardCnt(nt_id);
		request.setAttribute("BoardCnt", BoardCnt);
		
		
		// 페이징 처리 리스트
		
		// userPageList 호출 : 메소드 인자 - pageVo : page, pageSize
		PageVo pageVo = new PageVo() ;
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		
		Map<String, Object> prams = new HashMap<String, Object>();
		prams.put("pageVo", pageVo);
		prams.put("nt_id", request.getParameter("pageId"));
	
		/*===============================================================*/
		
		//pageVo.set
		Map<String, Object> resulMap = postService.selectBoardPageList(prams);
		
		// 페이지 리스트
		List<PostsVo> pageList = (List<PostsVo>)resulMap.get("postsListP");
		
		// 페이지 건수
		int pageCnt = (int) resulMap.get("pageCnt");
						
		// request 객체에 저장
		request.setAttribute("pageList", pageList);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("nt_id", request.getParameter("pageId"));
		request.setAttribute("selectPage", request.getParameter("page"));
			
		RequestDispatcher rd = request.getRequestDispatcher("/board/list.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
