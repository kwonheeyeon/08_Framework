package edu.kh.project.myPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.dto.Member;
import edu.kh.project.myPage.mapper.MyPageMapper;

@Service // Service 역할 명시 + Bean 등록
@Transactional // 서비스 내 메서드 수행 중
							 // UnCheckedException 발생 시 rollback 수행
							 // 아니면 메서드 종료 시 commit 수행
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired // 등록된 Bean 중에서 같은 자료형의 Bean을 대입 : 의존성 주입(DI) 
	private MyPageMapper mapper;
	
	// --------------------------------------
	
	// 회원 정보 수정
	@Override
	public int updateInfo(Member inputMember) {
		
		// 만약 주소가 입력되지 않은 경우 NULL로 변경
		
		if(inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null);
			// UPDATE 구문 수행 시 MEMBER_ADDRESS 컬럼 값이 NULL이 됨
		}
		
		// SQL 수행 후 결과 반환
		return mapper.updateInfo(inputMember);
	}

	// ---------------------------------------------------------------
	
	// (비동기) 닉네임 중복 검사
	@Override
	public int checkNickname(String input) {
		
		return mapper.checkNickname(input);
	}
}
