package org.zerock.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "c:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("---------------------------");
			log.info("file : " + multipartFile.getOriginalFilename());
			log.info("upload size : " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			}catch( Exception e){
				e.printStackTrace();
			}
		}
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("uploadAjax");
	}
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		String uploadFolder = "c:\\upload";
		log.info("uploadAjaxAction");
		for(MultipartFile multipartFile : uploadFile) {
			log.info("upload file name : " + multipartFile.getOriginalFilename());
			log.info("upload file getSize : " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			log.info("only fileName : " + uploadFileName);
			
			File savaFile = new File(uploadFolder, uploadFileName);
			
			try {
				multipartFile.transferTo(savaFile);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//end for
		
	}//clas for

}
	

