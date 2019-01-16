package com.briup.test;

public class ProduceChar {
	
	public static void toChar() throws Exception {
		HanyuPinyinHelper hypy = new HanyuPinyinHelper() ;
		//定义起始位置
		int start = Integer.parseInt("4e00", 16);
		//定义结束位置
		int end = Integer.parseInt("9fa5", 16);
		
		//产生随机数[0,1)
		double r = Math.random();
		//[start,end]
		double rr = r * ( end - start ) + start;
		
		long unicode = Math.round( rr );
		//10进制数--->16进制数
		String hexString = Integer.toHexString((int)unicode);
		
		System.out.print( (char)unicode);
		//System.out.print("\t\t\t\t\t\t\t");
		System.out.println(hypy.toHanyuPinyin( "(" + hexString + ") " + (char)unicode));
	}
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 8; i++) {
			toChar();
		}
	}
}
