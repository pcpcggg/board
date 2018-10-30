package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/upWrite")
public class UpdatePostsSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf bsi = new BoardService();
		int pd_id = Integer.parseInt(request.getParameter("postsId"));
		
		PostsVo postsVo = bsi.selectPosts(pd_id);
		
		List<FileVo> fileVo = bsi.selectFile(pd_id);
		
		request.setAttribute("postsVo", postsVo);
		request.setAttribute("fileVo", fileVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/writeUpdate.jsp");
		rd.forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("po_id update : "+request.getParameter("po_id"));
		
		int po_id = Integer.parseInt(request.getParameter("po_id"));
		
		String po_subject = request.getParameter("po_subject");
		String po_contents = request.getParameter("smarteditor");
		
		PostsVo postsVo = new PostsVo();
		postsVo.setPo_id(po_id);
		postsVo.setPo_subject(po_subject);
		postsVo.setPo_contents(po_contents);
		
		BoardServiceInf bsi = new BoardService();
		int updateCnt = bsi.updatePosts(postsVo);
		
		
		String fl_file = "";
		
		for(int i = 1; i <= 5; i++){
			/********************* 파일 첨부 시작 *******************************/
			// 파일 업로드 처리
			
			String req_flFile = "fl_flie"+i;
			System.out.println(request.getPart(req_flFile));
			if(request.getPart(req_flFile) != null){
				
				System.out.println(req_flFile);
				
				Part profilePart = request.getPart(req_flFile);
				
			
				String ContentDisposition = profilePart.getHeader("Content-disposition");
				String fileName = StringUtil.getFileNameFrimHeader(ContentDisposition);
				
				/********************* 파일 첨부 끝 *******************************/
			
					if(fileName != "" || fileName != null){
					
						String path = getServletContext().getRealPath("/file");
						
						profilePart.write(path + File.separator + fileName);
						profilePart.delete(); // 파일업로드 과정에서 사용한 디스크 임시 영역에서 지원줌
						
						System.out.println("po_id"+po_id);
						fl_file = "/file/"+ fileName;
						
						System.out.println("fl_file"+fl_file);
						
						FileVo fileVo = new FileVo();
						fileVo.setFl_id(Integer.parseInt(request.getParameter("fl_id")));
						fileVo.setFl_file(fl_file);
						
						int updateFileCnt = bsi.updateFile(fileVo);
						System.out.println(updateFileCnt);
					}
			}
		}
		
		
		
		response.sendRedirect("postsDetail?postsId="+po_id);
		
		
	}

}
