package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.MemberVO;

import util.DBManager;

public class ProductDAO {
	
	private ProductDAO() {}
	
	//싱글톤 객체 생성
	private static ProductDAO instance  = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<MemberVO> selectAllProdcuts(){
		List<MemberVO> list =  new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "select * from product order by code desc";
		
		try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					MemberVO vo = new MemberVO();
					vo.setCode(rs.getInt(1));
					vo.setName(rs.getString(2));
					vo.setPrice(rs.getInt(3));
					vo.setPictureurl(rs.getString(4));
					vo.setDescription(rs.getString(5));
					list.add(vo);
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return list;
	}

	//insert
	public int insertProduct(MemberVO pVo) {
		int result = -1;
		
		String sql = "insert into product values(product_seq.nextval, ?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pVo.getName());
				pstmt.setInt(2, pVo.getPrice());
				pstmt.setString(3,pVo.getPictureurl());
				pstmt.setString(4, pVo.getDescription());
				
				result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeConnection(conn, pstmt);
		}
		
		return result;
	}

	public MemberVO selectProductByCode(String code) {
			MemberVO pVo = new MemberVO();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from product where code = ?";
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
			   
				if(rs.next()) {
					pVo.setCode(rs.getInt(1));
					pVo.setName(rs.getString(2));
					pVo.setPrice(rs.getInt(3));
					pVo.setPictureurl(rs.getString(4));
					pVo.setDescription(rs.getString(5));
			   }
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.closeConnection(conn, pstmt, rs);
			}
			
		return pVo;
	}

	public int updateProduct(MemberVO pVo) {
		int result=-1;
		Connection conn= null;
		PreparedStatement pstmt=null;
		String sql = "update product set name=?, price=?, pictureUrl=? ,description=?" 
							+ "where code = ?";
		try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pVo.getName());
				pstmt.setInt(2,pVo.getPrice());
				pstmt.setString(3,pVo.getPictureurl());
				pstmt.setString(4, pVo.getDescription());
				pstmt.setInt(5, pVo.getCode());
				
				result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		return result;
	}

	public int productDelete(int code) {
		int result=-1;
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql = "delete from product where code=?";
			
			try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, code);
					result = pstmt.executeUpdate();		
					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.closeConnection(conn, pstmt);
			}
		
		return result;
	}
	
}



















