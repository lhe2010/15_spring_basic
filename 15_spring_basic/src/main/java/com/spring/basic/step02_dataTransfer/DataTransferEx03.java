package com.spring.basic.step02_dataTransfer;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 3. DAO > Mybatis-Mapper로 데이터 전송
// 원래는 commit해야 들어간다. 
@Controller
public class DataTransferEx03 {
	
	@Autowired
	SqlSession session;
	
	// 예시 1) DTO 클래스 이용 (가장 일반적인 전송 방법으로 사용)
	@RequestMapping(value="/dataTransferEx10")
	public String dataTransferEx10() {
		System.out.println("\n========= dataTransferEx10 전달받은 파라메타 확인 =========");

		Member member = new Member();
		member.setName("팀버너스리");
		member.setId("id팀버너스리");
		member.setPwd("비미르번호");
		member.setContent("내용팀버너스리내용");
		
		session.insert("tester.insertData1", member);
		
		return "home";
	}
	
	// 예시 2) Map 컬렉션 프레임워크 이용 (특정 데이터를 묶음으로 전송할 때 사용)
	// 모델이외의 정보들 ex.pageCount, currentPageNumber 같은 건 뷰에서 "맵으로" 받아와서 컨트롤러로 서비스로 통통통.  
	@RequestMapping(value="/dataTransferEx11")
	public String dataTransferEx11() {
		System.out.println("\n========= dataTransferEx11 전달받은 파라메타 확인 =========");
		
//		HashMap<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();	// 인터페이스로 연결
		
		map.put("id", "id11");
		map.put("pwd", "pwd1123");

		session.insert("tester.insertData2", map);
		
		return "home";
	}
	
	// 예시 3) 메서드의 파라메타로 전달(하나의 데이터 전송시 사용)
	@RequestMapping(value="/dataTransferEx12")
	public String dataTransferEx12() {
		System.out.println("\n========= dataTransferEx12 전달받은 파라메타 확인 =========");
		
		String name = "엘런 튜링";
				
		session.insert("tester.insertData3", name);	// 인수 여러개 불가능. 
		
		return "home";
	}
}