package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	public BoardVO read(Long bno);
	public int delete(Long bno);
}
