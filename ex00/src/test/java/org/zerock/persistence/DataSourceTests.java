package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()){
			log.info("--------------------------------------");
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testMybatis() {
		try( SqlSession session = sqlSessionFactory.openSession(); 
				Connection con = session.getConnection() 	){
			log.info("--------------------------------------");
			log.info(con);
			log.info(session);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
