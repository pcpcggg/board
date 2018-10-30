package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.vo.CommentVo;
import kr.or.ddit.board.vo.FileVo;
import kr.or.ddit.board.vo.NoticeVo;
import kr.or.ddit.board.vo.PostsVo;
import kr.or.ddit.board.vo.PageVo;


public class BoardService implements BoardServiceInf {
	BoardDaoInf  bdi = new BoardDao();

	public List<PostsVo> boardListAll() {
		return bdi.boardListAll();
	}
	
	/**
	 * 
	* Method : getBoardCnt
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 수 읽어오기
	 */
	@Override
	public int getBoardCnt(int nt_id) {
		return bdi.getBoardCnt(nt_id);
	}
	
	@Override
	public int getBoardCntSet(){
		return bdi.getBoardCntSet();
	}

	
	@Override
	public List<NoticeVo> select_notice(){
		return bdi.select_notice();
	};
	
	@Override
	public List<NoticeVo> select_menu() {
		return bdi.select_menu();
	}
	
	@Override
	public int insertNotice(NoticeVo noticeVo){
		return bdi.insertNotice(noticeVo);
	};
	
	@Override
	public int updateNotice(NoticeVo noticeVo){
		return bdi.updateNotice(noticeVo);
	}
	
	
	/**
	 * 
	* Method : selectUserPageList
	* 작성자 : chan
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 사용자 페이지 조회
	 */
	
	@Override
	public Map<String, Object> selectBoardPageList(Map<String, Object> page){
		
		List<PostsVo> postsListP = bdi.selectBoardPageList(page);
		
		PageVo pageVo = (PageVo) page.get("pageVo");
		int nt_id =  Integer.parseInt((String)page.get("nt_id"));


		// 페이지 내비게이션을 위한 유저 리스트 조회
		int totalPostsCnt = bdi.getBoardCnt(nt_id);
		
		// 결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("postsListP", postsListP);
		resultMap.put("pageCnt", (int)Math.ceil( (double)totalPostsCnt / pageVo.getPageSize()));
		
		return resultMap;
	}
	
	@Override
	public PostsVo selectPosts(int postsId){
		return bdi.selectPosts(postsId);
	}
	@Override
	public PostsVo selectPostsByVo(PostsVo postsVo){
		return bdi.selectPostsByVo(postsVo);
	}
	
	@Override
	public List<FileVo> selectFile(int postsId){
		return bdi.selectFile(postsId);
	}
	
	@Override
	public int insertPosts(PostsVo postsVo){
		return bdi.insertPosts(postsVo);
	}
	
	@Override
	public int updatePosts(PostsVo postsVo){
		return bdi.updatePosts(postsVo);
	}
	
	@Override
	public int deletePosts(PostsVo postsVo){
		return bdi.deletePosts(postsVo);
	}
	
	@Override
	public List<CommentVo> selectComment(int po_id){
		return bdi.selectComment(po_id);
	}
	
	@Override
	public int insertComment(CommentVo comVo){
		return bdi.insertComment(comVo);
	}
	
	@Override
	public int deleteComment(CommentVo comVo){
		return bdi.deleteComment(comVo);
	}
	
	@Override
	public int insertReply(PostsVo postsVo){
		return bdi.insertReply(postsVo);
	}
	
	@Override
	public int insertFile(FileVo fileVo){
		return bdi.insertFile(fileVo);
	}
	
	@Override
	public int updateFile(FileVo fileVo){
		return bdi.updateFile(fileVo);
	}
	
	@Override
	public List<PostsVo> selectRecent(){
		return bdi.selectRecent();
	}
	
}
