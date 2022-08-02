package org.zerock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/* 작업      URL            HTTP전송방식
 * 등록 : /replies/new  :  POST
 * 조회 : /replies/:rno    : GET
 * 삭제 : /replies/:rno   : DELETE
 * 수정 : /replies/:rno   : PUT or PATCH
 * 페이지  : /replies/pages/:bno/:page   : GET
 */
@RestController
@RequestMapping("/replies/")
@Log4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;
}
