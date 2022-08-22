package org.zerock.mapper;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {215L, 216L, 217L, 218L, 219L};
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	public void testCreate() {
		for(int i=0; i<5; i++) {
			ReplyVO vo = new ReplyVO();
			vo.setBno(10L);
			vo.setReply("홍길동전0 " + i+1);
			vo.setReplyer("길동0" + i+1);
			mapper.insert(vo);
		}
	}
	
	@Test
	public void testRead() {
		ReplyVO vo = mapper.read(100L);
		log.info(vo);
	}

	@Test
	public void testDelete() {
		log.info(mapper.delete(100L));
	}

	@Test
	public void testupdate() {
		ReplyVO vo = new ReplyVO();
		vo.setReply("수정중......");
		vo.setRno(2L);		
		log.info(mapper.update(vo));
	}
	
	@Test
	public void testList() {
		Criteria cri =  new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		log.info(replies);
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(1,10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 10000L);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testCount() {
		int num = mapper.getCountByBno(10000L);
		log.info("num : " + num);
	}
	
	
	
	
	
	
	
	
	
	
}
