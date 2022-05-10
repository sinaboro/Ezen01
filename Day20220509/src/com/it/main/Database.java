package com.it.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {

	private Connection con;                //mqsql 연결
	private PreparedStatement pstmt;       //sql 문장 전송
	
	private final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
	
	//드라이버 등록 : 한번만 등록하면된다.
	public Database() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//연결
	public void getConnection() {
		try {
			con = DriverManager.getConnection(URL, "root", "1234"); //경로, 아이디, 비번
//			System.out.println("connection!!!!!!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//연결해제
	public void disConnection() {
		
		try {
			
			if(pstmt != null ) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//데이타 목록
	public void mydbListData() {
		try {
			
			//1. Mysql 연결
			getConnection();

			
			//2. SQL문장 작성
			String sql = "select * from member";
			
			//3. MySql로 SQL문장 전송
			pstmt = con.prepareStatement(sql);
			
			//4. 실행결과를 받아 온다.
			ResultSet rs = pstmt.executeQuery();  //db 값을 조회
			
			//5. 결과를 출력
			
			/*
			 * no integer auto_increment,  
			 *	name varchar(34) not null, 
			 *  sex varchar(10) not null,
			 *  content text,
			 * */
			while(rs.next()) {
				System.out.println(rs.getInt(1) 
				    + ", " + rs.getString(2)
				    + ", " + rs.getString(3)
				    + ", " + rs.getString(4) + " ");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	
	/*
	 *	try {
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disConnection();
		} 
	 */
	//추가(Insert)
	public void mydbInsert(int no1, String name1, String sex1, String content1) {
		try {
			//1. 연걸
			getConnection();
			
			//2. sql문장 작성
			String sql = "insert into member(no, name, sex, content) "
					+ "values(?,?,?,?)";
			//3. MySql로 SQL문장 전송
			pstmt = con.prepareStatement(sql);
			
			//4. ????에 값을 채운다.
			pstmt.setInt(1, no1);
			pstmt.setString(2, name1);
			pstmt.setString(3, sex1);
			pstmt.setString(4, content1);
			
			//5. 실행
			pstmt.executeUpdate(); //db 값 변동시에는 executeUpdate  
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	//수정
	public void mydbUpdate(int no, String name1, String sex1, String content1) {
		try {
				
				getConnection();
				String sql = "update member set name=?, sex=?, content=? "
						    + "where no = ?";
				pstmt  = con.prepareStatement(sql);
				
				pstmt.setString(1, name1);
				pstmt.setString(2, sex1);
				pstmt.setString(3, content1);
				pstmt.setInt(4, no);
				
				pstmt.executeUpdate();
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				disConnection();
		} 
	}
	
	//삭제
	public void mydbDelete(int no) {
		try {
			
			getConnection();
			String sql = "delete from member where no = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disConnection();
		} 
	}
	
	//검색
	public void mydbOneSelect(int no) {
		try {
			
			getConnection();
			String sql = "select * from member where no = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1) 
				    + ", " + rs.getString(2)
				    + ", " + rs.getString(3)
				    + ", " + rs.getString(4) + " ");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disConnection();
		} 
	}
	
	public static void main(String[] args) {
		Database db = new Database();
		db.mydbListData();
		System.out.println("----------------------");
		//db.mydbInsert(13, "최원태", "남성", "키움투수");
		//System.out.println("----------------------");
		db.mydbUpdate(15, "김연정", "여성", "배구선수");
		db.mydbListData();
		db.mydbDelete(11);
		System.out.println("----------------------");
		db.mydbListData();
		System.out.println("----------------------");
		db.mydbOneSelect(10);
		System.out.println("----------------------");
		
	}

}
