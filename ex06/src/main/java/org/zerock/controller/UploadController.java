package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {
	
	@GetMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(
			@RequestHeader("User-Agent") String userAgent, String fileName){
		Resource resource = new FileSystemResource("c:\\upload\\"+fileName);
		log.info("resource : " + resource);
		log.info("userAgent" + userAgent);
		
		if(resource.exists() == false) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		String resourceName = resource.getFilename();
		HttpHeaders headers = new HttpHeaders();
		
		//uuid 제거..
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
		
		try {
			String downloadName = null;
			log.info("try---------------------");
			if(userAgent.contains("Trident")) {
				log.info("IE brower");
				downloadName = URLEncoder.encode(resourceOriginalName,"utf-8").replaceAll("\\+", " ");
			}else if(userAgent.contains("Edg")){
				log.info("Edge brower");
				downloadName = URLEncoder.encode(resourceOriginalName,"utf-8");
				log.info("Edge Name : " + downloadName);
			}else {
				log.info("Chrome brower");
				downloadName = new String(resourceOriginalName.getBytes("utf-8")	, "ISO-8859-1");
			}
			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, headers,HttpStatus.OK);
	}
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(String fileName){
		log.info("fileName  : " + fileName );
		
		File file = new File("c:\\upload\\"+fileName);
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header =  new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),header, HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
		
	}
	
	//이미지 파일 여부 판단- 셈네일 이미지 생성
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			log.info("contentType :  " + contentType);
			return contentType.startsWith("image");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
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
	} //end uploadFormAction
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("uploadAjax");
	}
	
	@PostMapping(value="/uploadAjaxAction",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>>  uploadAjaxPost(MultipartFile[] uploadFile) {
		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
		String uploadFolder = "c:\\upload";
		String uploadFolderPath = getFolder();

		//make Folder create.....
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.info("uplaodPath===>" + uploadPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		} 
		
		for(MultipartFile multipartFile : uploadFile) {
			AttachFileDTO attachDTO = new AttachFileDTO();
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			log.info("only file name : " +uploadFileName );
			attachDTO.setFileName(uploadFileName);
			
			//중복방지..
			UUID uuid= UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
	        log.info("uuid==> " +uploadFileName );		
	        
//			File savaFile = new File(uploadFolder, uploadFileName);
			
			try {
				File savaFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(savaFile);
				
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
				
				//check image type file
				if(checkImageType(savaFile)) {
					attachDTO.setImage(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				list.add(attachDTO);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//end for
		return new ResponseEntity<List<AttachFileDTO>>(list, HttpStatus.OK);
	}//uploadAjaxPost for
	
	//첨부파일 삭제
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("delete File --------> " + fileName);
		File file ;
		try {
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "utf-8"));
			file.delete();
			
			if(type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				file =  new File(largeFileName);
				file.delete();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

}
	

