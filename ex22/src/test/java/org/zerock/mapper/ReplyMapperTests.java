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
	
	private Long[]  bnoArr= {3342362L, 3342357L,3342351L,3342401L,3342346L};
	@Test
	public void testMapper() {
		log.info("mapper : " + mapper);
	}
	
	@Test
	public void testCreate() {
			ReplyVO vo = new ReplyVO();
			
			for(int i=0; i<10; i++) {
				vo.setBno(bnoArr[i%5]);
				vo.setReply("댓글 테스트   " +i);
				vo.setReplyer("replyer"+i);
				mapper.insert(vo);
			}
	}
	
	@Test
	public void testRead() {
			mapper.read(5L);
	}

	@Test
	public void testDelete() {
		log.info("delete-------------  : ");
		mapper.delete(5L);
	}

	@Test
	public void testUpdate() {
		log.info("update-------------  : ");
		ReplyVO vo = mapper.read(4L);
		vo.setReply("Update Reply");
		int count = mapper.update(vo);
		log.info("update count : " + count);
	}

	@Test
	public void testGetListWithpaging() {
		Criteria cri = new Criteria();
		log.info("cir================: " + cri);
		List<ReplyVO> replies = mapper.getListWithpaging(cri, bnoArr[0]);
		log.info(replies);
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2,10);
		List<ReplyVO> replies = mapper.getListWithpaging(cri, 10000L);
		replies.forEach(reply->log.info(replies));
	}
	
	@Test
	public void testTotalCount() {
		int count = mapper.getCountByBno(10000L);
		log.info("count : " + count);
	}
	
}
