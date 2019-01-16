package com.briup.test;

public class ProduceChar {
	
	public static void toChar() throws Exception {
		HanyuPinyinHelper hypy = new HanyuPinyinHelper() ;
		//������ʼλ��
		int start = Integer.parseInt("4e00", 16);
		//�������λ��
		int end = Integer.parseInt("9fa5", 16);
		
		//���������[0,1)
		double r = Math.random();
		//[start,end]
		double rr = r * ( end - start ) + start;
		
		long unicode = Math.round( rr );
		//10������--->16������
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
