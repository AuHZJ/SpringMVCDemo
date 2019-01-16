package com.briup.web.converter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateJsonSerializer extends JsonSerializer<Date> {  
	@Override  
	public void serialize(Date value, JsonGenerator jgen,  
			SerializerProvider provider) throws IOException,  
			JsonProcessingException {  
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		 String formattedDate = formatter.format(value);//2018-11-19  
		 
		 jgen.writeString(formattedDate);  
	}  
} 
