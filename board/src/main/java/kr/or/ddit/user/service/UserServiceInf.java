package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.vo.UserVo;
import kr.or.ddit.board.vo.PageVo;

public interface UserServiceInf {

	List<UserVo> getUserAll();

	UserVo selectUser();

	UserVo selectUser(UserVo userVo);

	UserVo selectUser(String userId);
	
	/**
	 * 
	* Method : selectUserPageList
	* 작성자 : chan
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 사용자 페이지 조회
	 */

	Map<String, Object> selectUserPageList(PageVo page);
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원 가입
	 */
	int insertUser(UserVo userVo);
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : chan
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :회원 정보삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 업데이트
	 */
	
	int updateUser(UserVo userVo);
	
}
