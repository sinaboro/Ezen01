package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;



//pom.xml --> Junit(<version>4.12</version>) -> 12, log4j (<version>1.2.17</version>)
//<artifactId>spring-test</artifactId>(Ãß°¡)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try( Connection con = dataSource.getConnection()){
			log.info("dataSource" + dataSource);
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}







