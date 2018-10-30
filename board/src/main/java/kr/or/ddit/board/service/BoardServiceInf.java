package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.CommentVo;
import kr.or.ddit.board.vo.FileVo;
import kr.or.ddit.board.vo.NoticeVo;
import kr.or.ddit.board.vo.PostsVo;

public interface BoardServiceInf {

	List<PostsVo> boardListAll();

	int getBoardCnt(int nt_id);
	int getBoardCntSet();

	List<NoticeVo> select_notice();

	int insertNotice(NoticeVo noticeVo);

	List<NoticeVo> select_menu();

	int updateNotice(NoticeVo noticeVo);


	Map<String, Object> selectBoardPageList(Map<String, Object> page);

	PostsVo selectPosts(int postsId);
	PostsVo selectPostsByVo(PostsVo postsVo);

	List<FileVo> selectFile(int postsId);

	int insertPosts(PostsVo postsVo);

	int updatePosts(PostsVo postsVo);

	int deletePosts(PostsVo postsVo);

	List<CommentVo> selectComment(int po_id);

	int insertComment(CommentVo comVo);

	int deleteComment(CommentVo comVo);

	int insertReply(PostsVo postsVo);

	int insertFile(FileVo fileVo);

	int updateFile(FileVo fileVo);

	List<PostsVo> selectRecent();


}
