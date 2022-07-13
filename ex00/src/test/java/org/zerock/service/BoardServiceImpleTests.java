package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.TimeMapperTests;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImpleTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testregister() {
		log.info("testregister--------------");
		BoardVO vo = new BoardVO();
		vo.setTitle("비온다4");
		vo.setContent("아주많이4");
		vo.setWriter("이런4");
		service.register(vo);
		log.info("생성된 게시물 번호 : " + vo.getBno());
	}
	
	@Test
	public void testread() {
		log.info("read-------------------------------");
		log.info(service.get(48L));
	}
	
	@Test
	public void testgetList() {
		log.info("getList------------------------------");
		service.getList();
	}
	@Test
	public void testremove() {
		log.info("remove------------------------------");
		log.info("삭제 : " + service.remove(48L));
	}

	@Test
	public void testmodify() {
		BoardVO vo  = new BoardVO();
		vo.setBno(47L);
		vo.setTitle("수원");
		vo.setContent("경기도");
		vo.setWriter("이젠");
		log.info("testmodify------------------------------");
		log.info("수정 : " + service.modify(vo));
	}
	
	
	
	
	
	
	
	
}
