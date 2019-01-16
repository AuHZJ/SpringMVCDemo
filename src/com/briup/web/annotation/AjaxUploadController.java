package com.briup.web.annotation;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ajax_upload")
public class AjaxUploadController {

	@RequestMapping("/show")
	public String show() {
		return "ajaxUpload";
	}

	@RequestMapping(value = "/test",produces="text/html;charset=utf-8", method = RequestMethod.POST)
	//@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam(value = "myfile", required = false) MultipartFile[] files,
			HttpServletRequest request) throws Exception {
		if (files != null && files.length > 0) {
			for (MultipartFile file : files) {
				saveFile(request, file);
			}
		}
		//这里要解决中文乱码问题
		//return new String("上传成功".getBytes("UTF-8"),"ISO-8859-1");
		return "上传成功";
	}

	private void saveFile(HttpServletRequest request, MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				String filePath = request.getServletContext().getRealPath("/") + "upload/" + file.getOriginalFilename();

				File newFile = new File(filePath);
				if (!newFile.getParentFile().exists()) {
					newFile.getParentFile().mkdirs();
				}

				file.transferTo(newFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
