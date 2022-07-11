package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT = "insert into board(seq, title, writer,content) "+
				"values( (select nvl(max(seq), 0)+1 from board), ?,?,?)";

	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";
	private final String BOARD_GET = "selete * from board where seq = ?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_LIST_T = "select * from board where title like '%' || ? ||'%' order by seq desc";;
	private final String BOARD_LIST_C = "select * from board where content like '%' || ? ||'%' order by seq desc";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		int cnt = jdbcTemplate.update(BOARD_INSERT, vo.getTitle(),  vo.getWriter(),vo.getContent());
		System.out.println("cnt ==>" + cnt);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(),  vo.getWriter(),vo.getContent());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args= {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		//-----검색
		Object[] args = {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		}else if(vo.getSearchCondition().equals("CONTENT")){
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		//-----검색 끝
		return null;
	}
	
	
}

class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		
		vo.setSeq(rs.getInt("SEQ"));
		vo.setTitle(rs.getString("TITLE"));
		vo.setWriter(rs.getString("WRITER"));
		vo.setContent(rs.getString("CONTENT"));
		vo.setRegDate(rs.getDate("REGDATE"));
		vo.setCnt(rs.getInt("CNT"));
				
		return vo;
	}
}
