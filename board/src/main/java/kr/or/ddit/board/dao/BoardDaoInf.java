package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.CommentVo;
import kr.or.ddit.board.vo.FileVo;
import kr.or.ddit.board.vo.NoticeVo;
import kr.or.ddit.board.vo.PostsVo;

public interface BoardDaoInf {
	
	/**
	 * 
	* Method : boardListAll
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시글 조회
	 */
	public List<PostsVo> boardListAll();
	
	/**
	 * 
	* Method : selectUserPageList
	* 작성자 : chan
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 페이징 리스트 
	 */
	public List<PostsVo> selectBoardPageList(Map<String, Object> page);
	
	/**
	 * 
	* Method : getBoardCnt
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 전체 수 읽어오기
	 */
	public int getBoardCnt(int nt_id);
	public int getBoardCntSet();
	
	
	/**
	 * 
	* Method : select_notice
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : notice 가져오기
	 */
	public List<NoticeVo> select_notice();
	public List<NoticeVo> select_menu();
	
	
	int insertNotice(NoticeVo noticeVo);

	int updateNotice(NoticeVo noticeVo);

	
	
	public PostsVo selectPosts(int postsId);
	public PostsVo selectPostsByVo(PostsVo postsVo);
	
	
	public List<FileVo> selectFile(int postsId);
	
	public int insertPosts(PostsVo postsVo);
	
	public int updatePosts(PostsVo postsVo);
	
	public int deletePosts(PostsVo postsVo);
	
	public List<CommentVo> selectComment(int po_id);
	
	public int insertComment(CommentVo comVo);

	public int deleteComment(CommentVo comVo);
	
	public int insertReply(PostsVo postsVo);
	
	public int insertFile(FileVo fileVo);
	
	public int updateFile(FileVo fileVo);
	
	public List<PostsVo> selectRecent();
}
