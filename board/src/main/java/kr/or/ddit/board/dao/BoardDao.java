package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.CommentVo;
import kr.or.ddit.board.vo.FileVo;
import kr.or.ddit.board.vo.NoticeVo;
import kr.or.ddit.board.vo.PostsVo;
import kr.or.ddit.db.SqlFactoryBuilder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao implements BoardDaoInf {
	public BoardDao(){
		 
	}
	/**
	 * 21312
	* Method : boardListAll
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 내용 전부 가져오기
	 */
	public List<PostsVo> boardListAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();

		List<PostsVo> boardList = session.selectList("board.boardListAll");
		session.close();

		return boardList;
		
	}
	
	
	/**
	 * 
	* Method : select_notice
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 notice 리스트 가져오기
	 */
	public List<NoticeVo> select_notice() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<NoticeVo> noticeList = session.selectList("board.select_notice");
		session.close();
		
		return noticeList;
		
	}
	
	/**
	 * 
	* Method : select_notice
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 메뉴 가져오기
	 */
	public List<NoticeVo> select_menu() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<NoticeVo> noticeMenu = session.selectList("board.select_menu");
		session.close();
		
		return noticeMenu;
		
	}
	
	
	/**
	 * 
	* Method : insertNotice
	* 작성자 : chan
	* 변경이력 :
	* @param noticeVo
	* @return
	* Method 설명 : 게시판 생성	
	*  */
	@Override
	public int insertNotice(NoticeVo noticeVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("board.insertNotice",noticeVo);
		// insert 필수 commit
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	
	@Override
	public int updateNotice(NoticeVo noticeVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("board.updateNotice",noticeVo);
		session.commit();
		session.close();
		
		return updateCnt;
		
	}
	
	public int getBoardCnt(int nt_id){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int getBoardCnt = session.selectOne("board.getBoardCnt", nt_id);
		session.close();
		
		return getBoardCnt;
	};
	
	public int getBoardCntSet(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int getBoardCntSet = session.selectOne("board.getBoardCntSet");
		session.close();
		
		return getBoardCntSet;
	};
	

	
	
	/**
	 * 
	* Method : selectBoardPageList
	* 작성자 : chan
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 페이징 리스트
	 */
	
	public List<PostsVo> selectBoardPageList(Map<String, Object> page){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<PostsVo> selectBoardPageList = session.selectList("board.selectBoardPageList", page);
		session.close();
		
		return selectBoardPageList;
	}
	
	
	public PostsVo selectPosts(int postsId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		PostsVo selectPosts = session.selectOne("board.selectPosts", postsId);
		session.close();
		
		return selectPosts;
		
	}
	
	public PostsVo selectPostsByVo(PostsVo postsVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		PostsVo selectPosts = session.selectOne("board.selectPostsByVo",postsVo);
		session.close();
		
		return selectPosts;
		
	}
	
	public List<FileVo> selectFile(int postsId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<FileVo> selectFile = session.selectList("board.selectFile", postsId);
		session.close();
		
		return selectFile;
	}
	
	public int insertPosts(PostsVo postsVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("board.insertPosts",postsVo);
		session.commit();
		session.close();
		
		return postsVo.getPo_id();
	}
	
	
	public int updatePosts(PostsVo postsVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("board.updatePosts",postsVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}
	
	public int deletePosts(PostsVo postsVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int deleteCnt = session.update("board.deletePosts",postsVo);
		session.commit();
		session.close();
		
		return deleteCnt;
	}
	
	public List<CommentVo> selectComment(int po_id){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<CommentVo> commentList = session.selectList("board.selectComment", po_id);
		session.close();
		
		return commentList;
	}
	
	
	public int insertComment(CommentVo comVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("board.insertComment",comVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	public int deleteComment(CommentVo comVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int deleteCnt = session.update("board.deleteComment",comVo);
		session.commit();
		session.close();
		
		return deleteCnt;
	}
	
	public int insertReply(PostsVo postsVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("board.insertReply",postsVo);
		session.commit();
		session.close();
		
		return postsVo.getPo_id();
	}
	
	public int insertFile(FileVo fileVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int insertFileCnt = session.insert("board.insertFile",fileVo);
		session.commit();
		session.close();
		
		return insertFileCnt;
	}
	
	public int updateFile(FileVo fileVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("board.updateFile",fileVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}
	
	public List<PostsVo> selectRecent(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<PostsVo> recentList = session.selectList("board.selectRecent");
		session.close();

		return recentList;
	}
	
}
