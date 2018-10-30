package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.vo.FileVo;
import kr.or.ddit.board.vo.NoticeVo;
import kr.or.ddit.board.vo.PostsVo;
import kr.or.ddit.db.SqlFactoryBuilder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class BoardDaoTest {

	@Test
	public void boardListAll(){
		
		/***Given***/
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();

		/***When***/

		List<PostsVo> boardList = session.selectList("board.boardListAll");
		session.close();
		
		/***Then***/
		assertEquals(46, boardList.size());
	}
	
	@Test
	public void select_notice() {
	
		/***Given***/
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();

		/***When***/
		List<NoticeVo> noticeList = session.selectList("board.select_notice");
		session.close();

		/***Then***/
		assertEquals(7, noticeList.size());
		
	}
	
	
	@Test
	public void select_menu() {
		
		/***Given***/
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();

		/***When***/

		List<NoticeVo> noticeMenu = session.selectList("board.select_menu");
		session.close();

		/***Then***/
		
		assertEquals(2, noticeMenu.size());
		
	}
	
	@Test
	public void selectFile(){
		
		/***Given***/
		int postsId2 = 27;
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();

		/***When***/
		List<FileVo> selectFile = session.selectList("board.selectFile", postsId2);
		session.close();
		
		/***Then***/
		
		assertEquals(2, selectFile.size());

	}
	
}
