package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.vo.UserVo;
import kr.or.ddit.board.vo.PageVo;

public interface UserDaoInf {
	public List<UserVo> getUserAll();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);
	
	public List<UserVo> selectUserPageList(PageVo page);
	
	/**
	* Method : getUserCnt
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	int getUserCnt();
	
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	 */
	
	int insertUser(UserVo userVo);
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : chan
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	 */
	
	int deleteUser(String userId);
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 업데이트
	 */
	int updateUser(UserVo userVo);
	
}