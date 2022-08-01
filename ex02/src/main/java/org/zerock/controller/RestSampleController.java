package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

//@Controller
@RestController  //@Controller + @ResponseBody
@RequestMapping("/sample")
@Log4j
public class RestSampleController {
	                                                             //¹ÝÈ¯Çü
//	@GetMapping(value="/getText" , produces = "text/plain; charset=utf-8")
	@GetMapping(value="/getText" , produces = {MediaType.TEXT_PLAIN_VALUE})
//	@ResponseBody
	public String getText() {
		log.info("MINY TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "¾È³çÇÏ¼¼¿ä";
	}
	
	//°´Ã¼¹ÝÈ¯
	@GetMapping(value="/getSample", produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	//@ResponseBody
	public SampleVO getSample() {
		log.info("getSample---------------------");
		return new SampleVO(111,  "È«",  "±æµ¿");
	}
	
	@GetMapping(value="/getList", produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public List<SampleVO> getList(){
//		List<SampleVO> list = new ArrayList<SampleVO>();
//		SampleVO vo = new SampleVO();
//		vo.setMno(000);
//		vo.setFirstName("¹Ú");
//		vo.setLastName("ÂùÈ£");
//		list.add(vo);
//		
//		SampleVO vo2 = new SampleVO();
//		vo2.setMno(111);
//		vo2.setFirstName("±è");
//		vo2.setLastName("ÂùÈ£");
//		list.add(vo2);
//		
//		SampleVO vo3 = new SampleVO();
//		vo3.setMno(222);
//		vo3.setFirstName("È«");
//		vo3.setLastName("ÂùÈ£");
//		list.add(vo3);
//		
//		return list;
		return IntStream.range(1, 5).mapToObj(i->new SampleVO(i, i+"FistName", i+"LastName"))
				.collect(Collectors.toList());
		
	}
	
	@GetMapping(value="/getMap", produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map =  new HashMap<>();
		map.put("First", new SampleVO(111, "¼ö¿ø", "ÀÌÁ¨"));
		map.put("Second", new SampleVO(222, "°æ±â", "ÆÈ´Þ±¸"));
		return map;
	}
	
	@GetMapping(value="/check", params = {"height", "weight"}	)
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(1, " " + height , " "+ weight);
		ResponseEntity<SampleVO> result = null;
		
		if( height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			//result = ResponseEntity.status(HttpStatus.OK).body(vo);
			result = new ResponseEntity<SampleVO>(vo,  HttpStatus.OK);
		}
		return result;
	}
	
	@GetMapping(value="/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") String pid
			) {
		return new String[] { "category : " + cat, "productid : " + pid } ;
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert : "+ticket);
		return ticket;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
