package com.briup.test;

import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class HeaderTest {
	
	public static void main(String[] args) {
		try {
			String url = "http://localhost:8889/SpringMVC_407/requestHeader/header/test6";
			//创建HttpRequest
			ClientHttpRequest request =
			new SimpleClientHttpRequestFactory().
			createRequest(new URI(url), HttpMethod.POST);
			//设置请求头的内容类型头和内容编码
			request.getHeaders().set("Content-Type", "application/json");
			request.getHeaders().set("Accept", "application/json");
			//request.getHeaders().set("abc", "123");
			//写出请求内容体
			String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
			request.getBody().write(jsonData.getBytes("UTF-8"));
			//发送请求并得到响应
			ClientHttpResponse response = request.execute();
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
