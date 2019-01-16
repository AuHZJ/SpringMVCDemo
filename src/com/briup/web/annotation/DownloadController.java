package com.briup.web.annotation;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/download")
public class DownloadController {

	@RequestMapping("/show")
	public String showDownLoadPage(){
		return "download";
	}
	
	@RequestMapping("/test")
	public ResponseEntity<byte[]> test(String fileName,HttpServletRequest request) throws IOException {
		//��������ļ�����·�� ����ָ��ϵͳ�е�����һ����Ȩ���ʵ�·��
		String downLoadPath = request.getServletContext().getRealPath("/download");

		//����Ҫ���ص��ļ�����
		File file = new File(downLoadPath,fileName);

		//����һ��Ҫ���ص��ļ�����,�����������
		String downFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");

		//������Ӧͷ��Ϣ�Ķ���
		HttpHeaders headers = new HttpHeaders();
		//�������ص���Ӧͷ��Ϣ,ͨ���������Ӧ���ĵ��������û�Ҫ���ص�,�������������
		headers.setContentDispositionFormData("attachment", downFileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		//ͨ����Ӧ���ݡ���Ӧͷ��Ϣ����Ӧ״̬������һ����Ӧ���󲢷���
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
