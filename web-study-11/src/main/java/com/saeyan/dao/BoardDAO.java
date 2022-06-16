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
				vo.setTitle(rs.getString(5));
				vo.setContent(rs.getString(6));
				vo.setReadcount(rs.getInt(7));
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

	public void insertBoard(BoardVO vo) {
		String sql = "insert into board(num, name, email, pass, title, content)" +
						"values(BOARD_SEQ.NEXTVAL, ?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3,  vo.getPass());
			pstmt.setString(4, vo.getTitle());
			pstmt.setString(5, vo.getContent());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}

	public int updateReadCount(String num) {
		int result = -1;
		String sql = "update board set  readcount = readcount +1 where  num=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		
		return result;
	}

	public BoardVO selectOneBoardByNum(String num) {
		BoardVO vo =new BoardVO();
		
		String sql = "select * from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			if(rs.next() ) {
				vo.setNum(rs.getInt(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setTitle(rs.getString(5));
				vo.setContent(rs.getString(6));
				vo.setReadcount(rs.getInt(7));
				vo.setWritedate(rs.getTimestamp(8));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt,rs);
		}
		
		
		return vo;
	}

	public void updateBoard(BoardVO vo) {
	
		String sql = "update board set name=?, pass=? ,email=?,"+
						"title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getTitle());
			pstmt.setString(5, vo.getContent());
			pstmt.setInt(6, vo.getNum());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}

	public void deleteBoard(String num) {
		int result = -1;
		String sql = "delete from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}
}
