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
			//����HttpRequest
			ClientHttpRequest request =
			new SimpleClientHttpRequestFactory().
			createRequest(new URI(url), HttpMethod.POST);
			//��������ͷ����������ͷ�����ݱ���
			request.getHeaders().set("Content-Type", "application/json");
			request.getHeaders().set("Accept", "application/json");
			//request.getHeaders().set("abc", "123");
			//д������������
			String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
			request.getBody().write(jsonData.getBytes("UTF-8"));
			//�������󲢵õ���Ӧ
			ClientHttpResponse response = request.execute();
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
