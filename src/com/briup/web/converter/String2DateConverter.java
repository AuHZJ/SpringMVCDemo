package com.briup.web.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class String2DateConverter implements Converter<String, Date> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	@Override
	public Date convert(String str) {//2018-11-16
		Date date = null;
		try {
			if(str!=null&&!"".equals(str.trim())){
				date = dateFormat.parse(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}
}
