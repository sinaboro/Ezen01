package com.springbook.biz.board;

import java.sql.SQLException;
import java.util.List;

import com.springbook.biz.board.impl.BoardDAO;

public class BoardServiceClient {
	public static void main(String[] args) throws SQLException{
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("myBaits 설정");
		vo.setWriter("홍길동");
		vo.setContent("myBatis 설정입니다.........");
		boardDAO.insertBoard(vo);
		
		vo.setSeq(12);
		boardDAO.deleteBoard(vo);
		
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		vo.setSeq(25);
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO list : boardList)
			System.out.println("------> " + list.toString());
	}
	
}
