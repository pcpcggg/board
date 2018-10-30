package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.board.vo.FileVo;
import kr.or.ddit.board.vo.PostsVo;
import kr.or.ddit.user.vo.UserVo;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/reply2")
public class ReplySevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int po_id = Integer.parseInt(request.getParameter("po_id"));
		
		BoardServiceInf bsi = new BoardService();
		PostsVo postsVo  = bsi.selectPosts(po_id);
		
		request.setAttribute("postsVo", postsVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/re_write.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		UserVo useridVo = new UserVo();
		useridVo = (UserVo) request.getSession().getAttribute("S_USER");
		int po_id2 = Integer.parseInt(request.getParameter("po_id"));
		
		int nt_id = Integer.parseInt(request.getParameter("nt_id"));
		String po_subject = request.getParameter("po_subject");
		String po_contents = request.getParameter("smarteditor");
		int po_reply = Integer.parseInt(request.getParameter("po_reply"));
		String userId = useridVo.getUserId();
		
		PostsVo postsVo = new PostsVo();
		postsVo.setPo_id2(po_id2);
		postsVo.setNt_id(nt_id);
		postsVo.setPo_subject(po_subject);
		postsVo.setPo_contents(po_contents);
		postsVo.setPo_reply(po_reply);
		postsVo.setUserid(userId);
		
		
		BoardServiceInf bsi = new BoardService();
		
		int insertReply = bsi.insertReply(postsVo);
		
		int po_id = 0 ;
		String fl_file = "";
		
		for(int i = 1; i <= 5; i++){
			/********************* 파일 첨부 시작 *******************************/
			// 파일 업로드 처리
			
			System.out.println("111");
			
			String req_flFile = "fl_flie"+i;
			
			System.out.println(req_flFile);
			if(request.getPart(req_flFile) != null){
			Part profilePart = request.getPart(req_flFile);
			
		
			String ContentDisposition = profilePart.getHeader("Content-disposition");
			String fileName = StringUtil.getFileNameFrimHeader(ContentDisposition);
			
			/********************* 파일 첨부 끝 *******************************/
		
				if(fileName != "" || fileName != null){
				
					String path = getServletContext().getRealPath("/file");
					
					profilePart.write(path + File.separator + fileName);
					profilePart.delete(); // 파일업로드 과정에서 사용한 디스크 임시 영역에서 지원줌
					
					po_id  = insertReply;
					System.out.println("po_id"+po_id);
					fl_file = "/file/"+ fileName;
					
					System.out.println("fl_file"+fl_file);
					
					FileVo fileVo = new FileVo();
					fileVo.setPo_id(po_id);
					fileVo.setFl_file(fl_file);
					
					
					
					int insertFileCnt = bsi.insertFile(fileVo);
				}
			}
		}
		
		
		
		response.sendRedirect("/boardS?pageId="+nt_id+"&page=1&pageSize=10");
		
	}

}
