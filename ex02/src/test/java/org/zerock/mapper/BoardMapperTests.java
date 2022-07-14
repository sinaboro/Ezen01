package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
	
	
}




