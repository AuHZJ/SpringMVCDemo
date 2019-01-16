package com.briup.test;

public class DataTran {
	byte a;
	short b;
	int c;
	long d;
	float e;
	double f;
	boolean g;
	char h='\u0000';
	
	public static void main(String[] args) {
		DataTran dt = new DataTran();
		System.out.println(dt.a);
		System.out.println(dt.b);
		System.out.println(dt.c);
		System.out.println(dt.d);
		
		System.out.println(dt.e);
		System.out.println(dt.f);
		
		System.out.println(dt.g);
		System.out.println(dt.h);
		
		//dt.ascllPrint();
		
		dt.unicodeTest();
		
	}
	
	public void dataTran() {
		String str = "1234";
		//String --> int Integer
		int parseInt = Integer.parseInt(str);
		Integer valueOf = Integer.valueOf(str);
		
		//String ---> long Long
		long parseLong = Long.parseLong(str);
		Long valueOf2 = Long.valueOf(str);
	}
	
	//char <--> int
	public void ascllPrint() {
		char param = 'a';
		System.out.println((int)param);
		
		//0--200
		for (int i = 0; i < 800; i++) {
			char ascllParam = (char) i;
			System.out.println(ascllParam+": "+i);
		}
	}
	
	public void unicodeTest() {
		char param = 'жа';
		System.out.println(param);
		
		char unicodeParam = '\u5aaa';
		System.out.println(unicodeParam);
		
		int start = Integer.parseInt("4e00", 16);
		int end = Integer.parseInt("9fa5", 16);
		for (int i = start; i < end; i++) {
			char pt = (char) i;
			System.out.println(pt);
			
		}
	}
	
}
