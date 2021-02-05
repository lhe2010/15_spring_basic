package com.spring.basic.step02_dataTransfer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 2. View에서 Controller로 데이터 전송
@Controller
public class DataTransferEx02 {

	// 예시 1) DTO 클래스 이용
	@RequestMapping(value="/dataTransferEx04")
	public String dataTransferEx04() {
		return "form";
	}
	
	// form의 name들이 Member와 변수명이 맞아야하고, setter있으면 request.getParameter()안해도 알아서 매칭해준다. 
	@RequestMapping(value="/dataTransferEx05")
	public String dataTransferEx05(Member member) {
		System.out.println("\n========= dataTransferEx05 전달받은 파라메타 확인 =========");
		System.out.println(member);
		return "home";
	}
	
	// 예시 2) Map 컬렉션 프레임워크 이용 (form의 action값 수정)
	@RequestMapping(value="/dataTransferEx06")
	public String dataTransferEx06(@RequestParam Map<String, String> param) {
		System.out.println("\n========= dataTransferEx06 전달받은 파라메타 확인 =========");
		System.out.println("name : "+ param.get("name"));
		System.out.println("id : "+ param.get("id"));
		System.out.println("pw : "+ param.get("pwd"));
		System.out.println("content : "+ param.get("content"));
		
		return "home";
	}
	
	// 예시 3) HttpServletRequest 이용 (form의 action값 수정)
	@RequestMapping(value="/dataTransferEx07")
	public String dataTransferEx07(HttpServletRequest request) {
		System.out.println("\n========= dataTransferEx07 전달받은 파라메타 확인 =========");
		System.out.println("name : "+ request.getParameter("name"));
		System.out.println("id : "+ request.getParameter("id"));
		System.out.println("pw : "+ request.getParameter("pwd"));
		System.out.println("content : "+ request.getParameter("content"));
		
		return "home";
	}
	
	// 예시 4) parameter에 직접 form 태그의 값 입력 -> request 안써도됨
	@RequestMapping(value="/dataTransferEx08")
	public String dataTransferEx08(String id, String pwd) {
		System.out.println("\n========= dataTransferEx08 전달받은 파라메타 확인 =========");
		System.out.println("id : "+ id);
		System.out.println("pw : "+ pwd);
		
		return "home";
	}
	
	// 예시 5) @RequestParam을 이용 : 형변환이 자유롭고, 변수명을 바꿔서 쓸 수 있다. default값을 설정할 수있다. (이경우는 생략되었던 name써야함)
	@RequestMapping(value="/dataTransferEx09")
	public String dataTransferEx09(@RequestParam("id") String memberId, @RequestParam(name="pwd", defaultValue = "defaultpwd") String memberPwd) {
		System.out.println("\n========= dataTransferEx09 전달받은 파라메타 확인 =========");
		System.out.println("id : "+ memberId);
		System.out.println("pw : "+ memberPwd);
		
		return "home";
	}
	
}
