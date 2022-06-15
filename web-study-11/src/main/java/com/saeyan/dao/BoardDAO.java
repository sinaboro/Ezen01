package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;

import util.DBManager;


public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	
	public static  BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {
		String sql = "select * from board order by num desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setTitlel(rs.getString(5));
				vo.setContent(rs.getString(6));
				vo.setReadcound(rs.getInt(7));
				vo.setWritedate(rs.getTimestamp(8));
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
}
