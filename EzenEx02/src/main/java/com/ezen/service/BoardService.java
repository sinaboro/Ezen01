package com.ezen.service;

import java.util.List;

import com.ezen.domain.BoardVO;

public interface BoardService {
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public int modify(BoardVO board);
	public int remove(Long bno);
	public List<BoardVO> getList();
}
