package com.spring.basic.step02_dataTransfer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataTransferEx01 {

	// Controller에서 View(jsp)로 데이터 전송
	
	// 예시 1) Model 인터페이스 이용
	@RequestMapping(value="/dataTransferEx01")
	public String dataTransferEx01(Model model) {
		model.addAttribute("method", "방법1");		// addAttribute("key", "value")
		model.addAttribute("productCode", "0000-97571");
		model.addAttribute("productName", "멀티리더기");
		model.addAttribute("productPrice", 50000);	
		return "dataTransferPro";
	}
	
	// 예시 2) ModelAndView 클래스 이용
	@RequestMapping(value="/dataTransferEx02")
	public ModelAndView dataTransferEx02() {	// return 타입은 ModelAndView 클래스
			
		ModelAndView mv = new ModelAndView();	// ModelAndView 객체 생성
		mv.setViewName("dataTransferPro");		// 포워딩할 jsp파일명
		mv.addObject("method", "방법2");		// addObject("key", "value");
		mv.addObject("productCode", "2222-97572");
		mv.addObject("productName", "멀티리더기2");
		mv.addObject("productPrice", 70000);

		return mv;								// ModelAndView 객체를 리턴
	}
	
	// 예시 3) httpServeletRequest 인터페이스 이용
	@RequestMapping(value="/dataTransferEx03")
	public String dataTransferEx03(HttpServletRequest request) {
		
		request.setAttribute("method", "방법3");
		request.setAttribute("productCode", "0000-97573");
		request.setAttribute("productName", "멀티리더기3");
		request.setAttribute("productPrice", 30000);	
		
		return "dataTransferPro";
	}
}
