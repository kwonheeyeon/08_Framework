package edu.kh.project.myPage.service;

import edu.kh.project.member.dto.Member;

public interface MyPageService{

	/** 회원 정보 수정
	 * 
	 * @param inputMember
	 * 
	 * @return result
	 */
	int updateInfo(Member inputMember);

	/** (비동기) 닉네임 중복 검사
	 * 
	 * @param input
	 * 
	 * @return 0 : 중복 X / 1 :중복 O
	 */
	int checkNickname(String input);

}
