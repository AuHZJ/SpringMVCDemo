package com.briup.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class UnicodeForeach {
	
	public static void unicodeToChar() throws Exception {
		int start = Integer.parseInt("4e00", 16);
		int end = Integer.parseInt("9fa5", 16);
		//[start,end] 
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("unicode.txt")));
		//������
		int count = 0;
		for (int i = start; i <= end; i++) {
			char param = (char) i;
			//System.out.print(param+"("+i+")"+" ");
			System.out.print(param+"("+Integer.toHexString(i)+")"+" ");
			
			bw.write(param+"("+Integer.toHexString(i)+")"+" ");
			
			if ((count++)%20==0) {
				System.out.println();
				bw.newLine();
				bw.flush();
			}
		}
		bw.close();
	}
	
	private static void charToUncode(char c) {
		int code  = (int)c;
		String hexString = Integer.toHexString(code);
		System.out.print("\\u"+hexString);
	}
	
	private static void StringtoUncode(String str) {
		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			int code  = (int)c;
			String hexString = Integer.toHexString(code);
			System.out.print("\\u"+hexString);
		}
	}
	
	public static void main(String[] args) throws Exception {
		unicodeToChar();
		/*char c = '·';
		charToUncode(c);
		String str = "�Է�";
		StringtoUncode(str);*/
		
		String s = "\u8def\u5403\u996d";
		System.out.println(s);
		
		// unicode ��Ӧ��
		//char --> unicode
		// unicode --> char
	}
	
}
