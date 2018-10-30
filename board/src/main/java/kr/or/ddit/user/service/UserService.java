package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.vo.UserVo;
import kr.or.ddit.board.vo.PageVo;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;

public class UserService implements UserServiceInf {
	
	UserDaoInf ud = new UserDao();

	@Override
	public List<UserVo> getUserAll() {
		return ud.getUserAll();
	}
	
	@Override
	public UserVo selectUser(String userId) {
		return ud.selectUser(userId);
	}
	
	@Override
	public UserVo selectUser(UserVo userVo) {
		return ud.selectUser(userVo);
	}

	@Override
	public UserVo selectUser() {
	
		return null;
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
	public Map<String, Object> selectUserPageList(PageVo page){

		List<UserVo> userList = ud.selectUserPageList(page);
	
		int totalUserCnt = ud.getUserCnt();

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCnt", (int)Math.ceil( (double)totalUserCnt / page.getPageSize()));
		
		return resultMap;
	}



	public int getUserCnt() {
		return ud.getUserCnt();
	}
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원 추가
	 */

	public int insertUser(UserVo userVo) {
		return ud.insertUser(userVo);
	}
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : chan
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 회원 삭제
	 */
	
	public int deleteUser(String userId) {
		return ud.deleteUser(userId);
	}

	
	/**
	 * 
	* Method : updateUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원 업데이트
	 */
	
	public int updateUser(UserVo userVo) {
		return ud.updateUser(userVo);
	}
	
	
	
}
