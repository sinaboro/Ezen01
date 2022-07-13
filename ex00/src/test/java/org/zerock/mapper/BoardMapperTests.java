package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.DataSourceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
	//	mapper.getList().forEach(board->log.info(board));
		for (BoardVO vo : mapper.getList()) {
			log.info(vo);
		}
	}
	@Test
	public void testinsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("java의 정석");
		vo.setContent("자바 책 ........");
		vo.setWriter("남궁성");
		mapper.insert(vo);
		log.info(vo);
	}
	@Test
	public void testSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Jsp2");
		vo.setContent("JSP2/servlet");
		vo.setWriter("성윤정2");
		mapper.insertSelectKey(vo);
		log.info(vo);
	}
	@Test
	public void testread() {
		BoardVO vo = mapper.read(42L);
		log.info(vo);
	}
	@Test
	public void testdelete() {
		log.info("delete count : "+mapper.delete(42L) );
	}
	@Test
	public void testupdate() {
		BoardVO vo  =  new BoardVO();
		vo.setBno(21L);
		vo.setTitle("자바2");
		vo.setContent("자바2");
		vo.setWriter("자바2");
		log.info("update : " +   mapper.update(vo) );
	}
	
	
	
	
	
	
}
