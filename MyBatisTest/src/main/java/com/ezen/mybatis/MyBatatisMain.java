package com.ezen.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatatisMain {

	public static void main(String[] args) {
		
		String resource = "com/ezen/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			
			BoardMethod mapper = session.getMapper(BoardMethod.class);
			BoardVO vo = mapper.selectOne(1);
			System.out.println(vo.toString());
			
			//mapper.deleteBoard(5);
//			BoardVO vo3 = new BoardVO();
//			vo3.setId(10);
//			vo3.setName("¼ÕÈï¹Î");
//			vo3.setPhone("111-2222-3333");
//			vo3.setAddress("¿µ±¹");
//			
//			mapper.insertBoard(vo3);
			vo.setId(4);
			vo.setName("¹Úµµ±Õ");
			vo.setPhone("111-1111-1111");
			vo.setAddress("busan");
			mapper.updateBoard(vo);
			session.commit();
			
			
			
			System.out.println("----------------------");
			List<BoardVO> list =  mapper.selectAllMember();
			for(BoardVO vo2 : list)
				System.out.println(vo2.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
