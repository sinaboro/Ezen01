package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = 
					new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
		//BoardService boardService = container.getBean("boardService", BoardService.class);
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목2");
		vo.setWriter("홍길동2");
		vo.setContent("임시 내용2.......");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList();
		
		for(BoardVO board : boardList) {
			System.out.println("---->  " + board.toString());
		}
		container.close();
	}
}
