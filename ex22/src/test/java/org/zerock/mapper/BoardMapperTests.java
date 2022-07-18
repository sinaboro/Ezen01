package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.TimeMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		log.info("----------------------------------");
		log.info(mapper.getList());
	}
	@Test
	public void testRead() {
		log.info("----------------------------------");
		log.info(mapper.read(6L));
	}
	@Test
	public void testDelete() {
		log.info("----------------------------------");
	    log.info("delete : " + mapper.delete(6L));
	}
	@Test
	public void testInsert() {
		BoardVO vo  =  new BoardVO();
		vo.setTitle("spring2");
		vo.setContent("¾î·Æ´Ù2");
		vo.setWriter("±è½Å¿µ2");
		log.info("----------------------------------");
		log.info("insert : " + mapper.insert(vo));
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO vo  =  new BoardVO();
		vo.setTitle("java");
		vo.setContent("java");
		vo.setWriter("java2");
		log.info("----------------------------------");
		log.info("insert : " + mapper.insertSelectKey(vo));
	}
	@Test
	public void testupdate() {
		BoardVO vo  =  new BoardVO();
		vo.setBno(9L);
		vo.setTitle("aa");
		vo.setContent("bbb........");
		vo.setWriter("cc");
		log.info("----------------------------------");
		log.info("insert : " + mapper.update(vo));
	}
	
	
}




