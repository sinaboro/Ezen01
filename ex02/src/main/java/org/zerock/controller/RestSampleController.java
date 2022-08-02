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

@RestController
@RequestMapping("/sample")
@Log4j
public class RestSampleController {
	                                                             //��ȯ��
//	@GetMapping(value="/getText" , produces = "text/plain; charset=utf-8")
	@GetMapping(value="/getText" , produces = {MediaType.TEXT_PLAIN_VALUE})
	public String getText() {
		log.info("MINY TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	//객체반환
	@GetMapping(value="/getSample", produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public SampleVO getSample() {
		log.info("getSample---------------------");
		return new SampleVO(111,  "홍",  "길동");
	}
	
	@GetMapping(value="/getList", produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public List<SampleVO> getList(){
		List<SampleVO> list = new ArrayList<SampleVO>();
		SampleVO vo = new SampleVO();
		vo.setMno(000);
		vo.setFirstName("박");
		vo.setLastName("찬호");
		list.add(vo);
		
		SampleVO vo2 = new SampleVO();
		vo2.setMno(111);
		vo2.setFirstName("김");
		vo2.setLastName("찬호");
		list.add(vo2);
		
		SampleVO vo3 = new SampleVO();
		vo3.setMno(222);
		vo3.setFirstName("홍");
		vo3.setLastName("찬호");
		list.add(vo3);
		
		return list;
		
	}
	
	@GetMapping(value="/getMap", produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }
	)
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map =  new HashMap<>();
		map.put("First", new SampleVO(111, "수원", "이젠"));
		map.put("Second", new SampleVO(222, "경기", "팔달구"));
		return map;
	}
	
	
	//상태 코드로 함께 전송.
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
		ticket.setTno(200);
		ticket.setOwner("홍길동");
		ticket.setGrade("C등급");
		return ticket;
	}
	
	
}
