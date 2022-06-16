package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.EmployeesVO;

import util.DBManager;


public class EmployeesDAO {
	private static EmployeesDAO instance = new EmployeesDAO();
	private EmployeesDAO() {}
	
	public static  EmployeesDAO getInstance() {
		return instance;
	}

	public List<EmployeesVO> selectAllBoards() {
		String sql = "select * from Employees order by id desc";
		
		List<EmployeesVO> list = new ArrayList<EmployeesVO>();
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeesVO vo = new EmployeesVO();
				vo.setId(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setLev(rs.getString(4));
				vo.setEnter(rs.getDate(5));
				vo.setGender(rs.getString(6));
				vo.setPhone(rs.getString(7));
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
