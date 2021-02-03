package com.spring.basic.step01_DI;

public class CharacterManager1 {
	
	// 클래스 내부에서 다른 객체를 생성 > 결합력(의존성)이 강하다. 

	Character1 char1 = new Character1();
	Character2 char2 = new Character2();
	Character3 char3 = new Character3();
	
	// 단순 테스트용 print 해보기
	void printCharacer1Info() {
		System.out.println(char1);
	}
	
	void printCharacer2Info() {
		System.out.println(char2);
	}
	
	void printCharacer3Info() {
		System.out.println(char3);
	}
	
	
}
