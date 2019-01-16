package com.briup.web.annotation;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping("/show")
	public String showUploadPage(){
		return "upload";
	}

	@RequestMapping("/test")
	public String upload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
		if (files != null && files.length > 0) {
			for (MultipartFile file : files) {
				// �����ļ�
				saveFile(request, file);
			}
		}
		// �ض���
		return "redirect:/upload/show";
	}

	private void saveFile(HttpServletRequest request, MultipartFile file) {
		// �ж��ļ��Ƿ�Ϊ��
		if (!file.isEmpty()) {
			try {
				//������ļ�·��
				//��Ҫ�Ļ����Ը��ļ����ϼ�ʱ���
				String filePath = request.getServletContext().getRealPath("/") + "upload/"
						+ file.getOriginalFilename();
				File newFile = new File(filePath);
				//�ļ�����Ŀ¼�����ھʹ���
				if (!newFile.getParentFile().exists()){
					newFile.getParentFile().mkdirs();
				}

				// ת���ļ�
				file.transferTo(newFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}


