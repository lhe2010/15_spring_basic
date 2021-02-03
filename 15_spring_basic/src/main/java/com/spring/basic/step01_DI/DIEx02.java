package com.spring.basic.step01_DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DIEx02 {

	@RequestMapping(value="/test2")
	public String main() {
		
		// xml파일 정보를 읽어온다. 
		ApplicationContext context = new GenericXmlApplicationContext("classpath:CharacterApplicationContext.xml");
		
		// 방법 1,2,3)
//		CharacterManager2 cm2 = context.getBean("characterManager2", CharacterManager2.class);	// xml파일의 bean id 값 명시
//		CharacterManager2 cm2 = (CharacterManager2)context.getBean("characterManager2");
		CharacterManager2 cm2 = context.getBean(CharacterManager2.class);
		
		Character1 char1 = context.getBean(Character1.class);
		Character2 char2 = context.getBean(Character2.class);
		Character3 char3 = context.getBean(Character3.class);
		
		System.out.println("=========================DIEx02=========================");
		System.out.println(char1);
		System.out.println(char2);
		System.out.println(char3);
		
		return "home";
	}
}
