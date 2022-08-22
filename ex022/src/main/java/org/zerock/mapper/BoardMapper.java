package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList();
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int insert(BoardVO vo);
	public int insertSelectKey(BoardVO vo);
	public int update(BoardVO vo);
	public List<BoardVO> getListWithPagging(Criteria cri);
	public int getTotalCount(Criteria cri);
	
	//검색조건
	public List<BoardVO> searchTest(Map<String, Map<String,String>> map);
	
	//댓글수 등록  --> MyBatis의 2개 파라미터를 사용하기 위해서는 @param 어노테이선 사용해야함.
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
