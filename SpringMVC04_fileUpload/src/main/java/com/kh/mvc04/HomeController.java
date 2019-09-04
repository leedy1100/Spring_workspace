package com.kh.mvc04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.kh.mvc04.validate.FileValidator;
import com.kh.mvc04.validate.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String getUploadForm() {
		return "uploadform";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		
		fileValidator.validate(uploadFile, result);
		if(result.hasErrors()) {
			return "uploadform";
		}
		
		MultipartFile file = uploadFile.getFile();
		String filename = file.getOriginalFilename();
		
		UploadFile fileobj = new UploadFile();
		fileobj.setFilename(filename);
		fileobj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream();
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		
			// 절대경로: c:\..
			// 상대경로: /, ./, ../
			
			System.out.println("업로드 될 실제 경로 : " + path);
			
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdirs();
			}
			
			File newfile = new File(path + "/" + filename);
			
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newfile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj", fileobj);
		
		return "uploadfile";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDown(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
		
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		File file = new File(path + "/" + filename);
	
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName().getBytes(), "8859_1");
		
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);
		response.setContentType("image/jpeg");
		// tomcat web.xml 확인(mime-type)
		
		return bytes;
	}
}






