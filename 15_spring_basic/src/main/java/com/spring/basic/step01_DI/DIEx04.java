package com.spring.basic.step01_DI;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DIEx04 {
	
	@Autowired
	ClassTester1 classTester1_1;

	@Autowired
	ClassTester1 classTester1_2;
	
	@Resource(name="resourceTester")
	ClassTester1 classTester1_3;
	
	@Autowired
	ClassTester2 classTester2_1;
	
	@Autowired
	ClassTester2 classTester2_2;

	@Autowired
	ClassTester2 classTester2_3;
	
	@Autowired
	ClassTester3 classTester3;

	@RequestMapping(value="/test4")
	public String main() {
		
		System.out.println("\n ======= ClassTester1 =======");
		classTester1_1.printInfo();
		classTester1_2.printInfo();
		classTester1_3.printInfo();
		
		
		System.out.println("\n ======= ClassTester2 =======");
		classTester2_1.print();
		classTester2_2.print();
		classTester2_3.print();
		
		
		System.out.println("\n ======= ClassTester3 =======");
		System.out.println("...printing TestList...");
		for (String data : classTester3.getTestList()) {
			System.out.println(data);
		}
		
		System.out.println("\n...printing TestMap<String,String>...");
		for (String key : classTester3.getTestMap().keySet()) {
			System.out.printf("key : %s , val : %s", key, classTester3.getTestMap().get(key));
			System.out.println();
		}
		
		System.out.println("\n...printing TestMap<String,Obj>...");
		for (String key : classTester3.getTestMapObj().keySet()) {
//			System.out.printf("key: %s , val : %s", key, classTester3.getTestMapObj().get(key).printCharacer1Info());
			classTester3.getTestMapObj().get(key).printInfo();
		}
		
		return "home";
	}

}
