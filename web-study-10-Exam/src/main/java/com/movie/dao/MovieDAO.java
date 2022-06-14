package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.movie.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	
	private MovieDAO() {
	}

	// 싱글톤 객체 생성
	private static MovieDAO instance = new MovieDAO();

	public static MovieDAO getInstance() {
		return instance;
	}
	
	//전체 Data가져오기
	public List<MovieVO> selectAllMovies(){
		List<MovieVO> list =  new ArrayList<MovieVO>();
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select * from movie order by code desc";
		
		try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					MovieVO vo = new MovieVO();
					vo.setCode(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setPrice(rs.getInt(3));
					vo.setDirector(rs.getString(4));
					vo.setActor(rs.getString(5));
					vo.setPoster(rs.getString(6));
					vo.setSynopsis(rs.getString(7));
					
					list.add(vo);
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return list;
	}

	public int insertMovie(MovieVO pVo) {
		int result = -1;
		String sql = "insert into movie values(movie_seq.nextval, ?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pVo.getTitle());
				pstmt.setInt(2, pVo.getPrice());
				pstmt.setString(3, pVo.getDirector());
				pstmt.setString(4, pVo.getActor());
				pstmt.setString(5, pVo.getPoster());
				pstmt.setString(6, pVo.getSynopsis());
				result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeConnection(conn, pstmt);
		}
		
		return result;
	}
}
