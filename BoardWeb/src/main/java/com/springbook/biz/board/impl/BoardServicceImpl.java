package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;

@Repository("boardService")
public class BoardServicceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	
	
//	public BoardServicceImpl() {
//		log = new Log4jAdvice();
//	}
	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq()==0)
//			throw new IllegalArgumentException("0번글은 등록할 수 없습니다.");
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
//		log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
//		log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
//		log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
//		log.printLogging();
		return boardDAO.getBoardList();
	}
}
