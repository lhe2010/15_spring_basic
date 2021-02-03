package com.spring.basic.step01_DI;

public class CharacterManager2 {

	Character1 char1;
	Character2 char2;
	Character3 char3;
	
	public CharacterManager2() { }
	
	// 방법 1) 생성자를 통해 외부객체를 주입한다 > 결합력(의존성)이 약하다. 
	public CharacterManager2(Character1 char1) {
		this.char1 = char1;
	}
	
	public CharacterManager2(Character2 char2) {
		this.char2 = char2;
	}
	
	public CharacterManager2(Character3 char3) {
		this.char3 = char3;
	}

	public Character1 getChar1() {
		return char1;
	}

	// 방법 2) setter 메서드를 통해 외부객체를 주입한다 > 결합력(의존성)이 약하다. 
	public void setChar1(Character1 char1) {
		this.char1 = char1;
	}

	public Character2 getChar2() {
		return char2;
	}

	public void setChar2(Character2 char2) {
		this.char2 = char2;
	}

	public Character3 getChar3() {
		return char3;
	}

	public void setChar3(Character3 char3) {
		this.char3 = char3;
	}
	
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
