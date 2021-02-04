package com.spring.basic.step01_DI;

// 기본 데이터모델 주입 예시
public class ClassTester1 {
	
	String id;
	String pw;
	String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ClassTester1 [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	public void printInfo() {
		System.out.println(this);
	}
}