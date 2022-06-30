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
		vo.setWriter("홍길동");
		service.register(vo);
		log.info("-------------------------------");
		log.info("생성된 번호는 : " + vo.getBno());
	}
	
	@Test
	public void testGet() {
		log.info("------------------------");
		log.info("testGet : " +  service.get(41L));
	}
	
	@Test
	public void testUpdate() {
		log.info("------------------------");
		BoardVO vo = service.get(41L);
		
		if(vo == null ) return ;
		vo.setTitle("제목을 수정합니다.");
		log.info("modify : " + service.modify(vo));
	}
	
	@Test
	public void testDelete() {
		log.info("------------------------");
		log.info("delete : " + service.remove(44L));
	}
}
