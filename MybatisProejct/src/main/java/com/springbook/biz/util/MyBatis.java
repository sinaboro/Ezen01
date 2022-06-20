package com.springbook.biz.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.springbook.biz.board.BoardVO;

public class MyBatis {
	public static void main(String[] args) {
		String resource = "com/springbook/biz/util/mybatis-config.xml";
		
		InputStream inputStream=null;;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("sqlSessionFactory : " + sqlSessionFactory);
			
			SqlSession session = sqlSessionFactory.openSession());
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			BoardVO vo = mapper.selectBlog(101);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
