package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.vo.UserVo;
import kr.or.ddit.board.vo.PageVo;

public class UserDao implements UserDaoInf {
	
	
	public UserDao(){}


	public List<UserVo> getUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<UserVo> userList = session.selectList("user.user");
		session.close();

		return userList;
	}
	
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		UserVo selectUser = session.selectOne("user.selectUser",userId);
		session.close();
		
		return selectUser;
		
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		UserVo selectUser = session.selectOne("user.selectUserByVo",userVo);
		session.close();
		
		return selectUser;
		
	}
	
	public List<UserVo> selectUserPageList(PageVo page){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<UserVo> selectUserPageList = session.selectList("user.selectUserPageList", page);
		session.close();
		
		return selectUserPageList;
	}
	
	/**
	 * 
	* Method : getUserCnt
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	 */
	
	public int getUserCnt(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int getUserCnt = session.selectOne("user.getUserCnt");
		session.close();
		
		return getUserCnt;
	}
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("user.insertUser",userVo);
		// insert 필수 commit
		session.commit();
		session.close();
		
		return insertCnt;
	}


	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : chan
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	 */
	
	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int delereCnt = session.delete("user.deleteUser", userId);
		
		session.commit();
		session.close();
		
		return delereCnt;
	}
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 업데이트 
	 */
	public int updateUser(UserVo userVo){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.update("user.updateUser", userVo);
		
		session.commit();
		session.close();
		
		return updateCnt;
		
	}
	
	
}
