package com.ezen.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.BoardVO;
import com.ezen.mapper.BoardmapperTests;
import com.ezen.service.BoardService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info("-------------------------------");
		log.info(service);
		
	}

	@Test
	public void testregister() {
		BoardVO vo =  new BoardVO();
		vo.setTitle("Jsp");
		vo.setContent("MVC2 Study");
		vo.setWriter("全辨悼");
		service.register(vo);
		log.info("-------------------------------");
		log.info("积己等 锅龋 : " + vo.getBno());
	}
}
