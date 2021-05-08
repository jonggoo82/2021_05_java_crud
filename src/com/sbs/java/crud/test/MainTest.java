package com.sbs.java.crud.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {

	public static void main(String[] args) {
	
		String str="abcde2";
		String[] test = str.split("abc");
		int test1= str.indexOf("1");
		
		int test2 = str.indexOf('1');
		char test3 = str.charAt(str.length()-1);
		
		
		System.out.println(test3);
		
		Date today = new Date();
		
		SimpleDateFormat format1;
		
		format1 = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(format1.format(today));
		

	}

}
