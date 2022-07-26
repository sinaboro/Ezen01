package org.zerock.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	
	@PostMapping(value="/new",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE}
			)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("ReplyVO------------------ : " + vo);
		int insertCount = service.register(vo);
		log.info("Reply Insert Count------------------- : " + insertCount);
		
		return insertCount == 1 ? new ResponseEntity<String>("success",HttpStatus.OK):
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//3342362L, 3342357L,3342351L,3342401L,3342346L
	@GetMapping(value="/pages/{bno}/{page}",
			produces = {MediaType.APPLICATION_XML_VALUE,
								  MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno
			) {
		log.info("getList-----------------------");
		Criteria cri = new Criteria(page, 10);
		log.info("cri----------------- : " + cri);
		return new ResponseEntity<List<ReplyVO>>(service.getList(cri, bno),HttpStatus.OK);
	}
	
	@GetMapping(value="/{rno}",
			produces = {MediaType.APPLICATION_XML_VALUE,
								MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		log.info("get..................: "+ rno);
		return new ResponseEntity<ReplyVO>(service.get(rno),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{rno}",produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno")Long rno){
		log.info("deleteMapping ------ : " + rno);
		System.out.println("--------------------------------------");
		return service.remove(rno)==1? new ResponseEntity<String>("success", HttpStatus.OK):
							new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value="/{rno}", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE},
			method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo,
																		@PathVariable("rno")Long rno){
		vo.setRno(rno);
		log.info("rno -----------"  + rno);
		log.info("modify ----------" + vo);
		return service.modify(vo) ==1 ?new ResponseEntity<String>("success", HttpStatus.OK):
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
