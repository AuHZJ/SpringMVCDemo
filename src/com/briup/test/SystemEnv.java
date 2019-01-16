package com.briup.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class SystemEnv {
	public static void main(String[] args) throws Exception {
		/*Map<String, String> getenv = System.getenv();
		for (Entry<String, String> entry : getenv.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+": "+value);
		}*/
		
		//SystemProperties[os.name] Windows 10
		Properties p = System.getProperties();
		for (Object key : p.keySet()) {
			//key
			//value
			Object value = p.get(key);
			System.out.println(key+": "+value);
		}
		
		/*
		System.out.println(new Date());
		String dob = "2018-11-16";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String format = dateFormat.format(new Date());
		System.out.println(format);
		
		Date date = dateFormat.parse("2018-11-16");
		System.out.println(date);*/
	}
}
