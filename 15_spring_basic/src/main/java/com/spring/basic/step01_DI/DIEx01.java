package com.spring.basic.step01_DI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DIEx01 {
	
	@RequestMapping(value="/test1")
	public String main() {
		System.out.println("=========================DIEx01=========================");
		
		System.out.println("1. 클래스 내부에서 외부 객체를 생성한 예시");
		CharacterManager1 cm1 = new CharacterManager1();
		cm1.printCharacer1Info();
		cm1.printCharacer2Info();
		cm1.printCharacer3Info();
		// cm1하나에 ch1,2,3가 포함되어있다. 
		
		System.out.println("\n2. 생성자를 통하여 외부의 객체를 주입한 예시");
		CharacterManager2 cm2 = new CharacterManager2(new Character1());
		cm2.printCharacer1Info();
		cm2 = new CharacterManager2(new Character2());
		cm2.printCharacer2Info();
		cm2 = new CharacterManager2(new Character3());
		cm2.printCharacer3Info();
		// cm2는 하나고 다른거에서 넣어줌. 결합력이 낮아지는 것!
		// 결과는 같다. 과정이 다를 뿐. 		
		
		System.out.println("\n3. Setter메서드를 통하여 외부의 객체를 주입한 예시");
		cm2 = new CharacterManager2();
		cm2.setChar1(new Character1());
		cm2.printCharacer1Info();
		
		cm2 = new CharacterManager2();
		cm2.setChar2(new Character2());
		cm2.printCharacer2Info();
		
		cm2 = new CharacterManager2();
		cm2.setChar3(new Character3());
		cm2.printCharacer3Info();
		
		return "home";	// 이건 명목용. 우리는 연습이니까 콘솔로 찍어보자
	}
}
