package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testRegister() {
		BoardVO vo  = new BoardVO();
		vo.setTitle("삼국지");
		vo.setContent("영웅호걸전..........");
		vo.setWriter("황석영");
		
		service.register(vo);
		log.info("생성된 게시물 번호 : " + vo.getBno());
	}
	@Test
	public void testRead() {
		service.get(24L);
		//log.info("검색된 데이타  : " + 	service.get(24L));
	}
	@Test
	public void testDelete() {
		//service.remove(24L);
		log.info("삭제된 개수  : " + 	service.remove(7L));
	}

	@Test
	public void testGetList() {
		log.info("----------------------------");
		service.getList(new Criteria(2,10));
	}

	@Test
	public void testModify() {
		BoardVO vo = new BoardVO();
		vo.setBno(21L);
		vo.setTitle("홍길동");
		vo.setContent("도둑이야기...........");
		vo.setWriter("허균");
		service.modify(vo);
		log.info("수정된 데이타 : " + service.modify(vo));
	}
	
	
	
	
	
	
}
