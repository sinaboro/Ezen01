package com.ezen.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardmapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("이젠컴퓨터학원");
		vo.setContent("스프링 공부중");
		vo.setWriter("kdc");
		mapper.insert(vo);
		log.info("------------------: " + vo);
	}

	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("이젠컴퓨터학원 Selectkey");
		vo.setContent("스프링 공부중 SelectKey");
		vo.setWriter("kdc_Select");
		mapper.insertSelectKey(vo);
		log.info("------------------: " + vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo =mapper.read(22L);
	}
	@Test
	public void testdelete() {
		int num =mapper.delete(21L);
		log.info("testdelete ==> " + num);
	}

	@Test
	public void testupdatge() {
		BoardVO vo  = new BoardVO();
		vo.setBno(8L);
		vo.setTitle("홍길동");
		vo.setContent("의적 내용");
		vo.setWriter("허균");
		int num = mapper.update(vo);
		log.info("UPDATE ==>   " + num);
	}
}
