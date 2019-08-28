package com.mvc.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDaoImp implements MVCBoardDao {
	
	@Override
	public List<MVCBoardDto> selectList() {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs= null;
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		
		try {
			stmt = con.createStatement();
			System.out.println("03.query 준비 : "+ SELECT_LIST_SQL);
			
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("03.04.error");
			e.printStackTrace();
			
		}finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05.db 종료");
		}
	
		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto dto = new MVCBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			System.out.println("03.query 준비" + SELECT_ONE_SQL);
			
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			System.out.println("03.04.error");
			e.printStackTrace();
			
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}
		
		return dto;
	}

	@Override
	public int insert(MVCBoardDto dto) {
		Connection con=getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("03.query 준비" + INSERT_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");			
			
		} catch (SQLException e) {
			System.out.println("03.04.error");
			e.printStackTrace();
			
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

	@Override
	public int update(MVCBoardDto dto) {
		Connection con=getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPADATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			System.out.println("03.query 준비" + UPADATE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");			
			
		} catch (SQLException e) {
			System.out.println("03.04.error");
			e.printStackTrace();
			
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

	@Override
	public int delete(int seq) {
		Connection con=getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, seq);
			System.out.println("03.query 준비" + DELETE_SQL);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");			
			
		} catch (SQLException e) {
			System.out.println("03.04.error");
			e.printStackTrace();
			
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

}
