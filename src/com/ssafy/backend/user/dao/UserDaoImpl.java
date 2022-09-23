package com.ssafy.backend.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.backend.user.dto.User;
import com.ssafy.backend.util.DBUtil;

public class UserDaoImpl implements IUserDao {
	
	DBUtil db = DBUtil.getInstance();
	
	@Override
	public User login(User user) throws SQLException {
		User loginUser = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select id, name, delflag, role");
		sql.append(" from user");
		sql.append(" where id = ? and password = ?");
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				loginUser = new User();
				loginUser.setId(rs.getString(1));
				loginUser.setName(rs.getString(2));
				loginUser.setDelflag(rs.getInt(3));
				loginUser.setRole(rs.getInt(4));
			}
			
			// 삭제된 회원
			if (loginUser != null && loginUser.getDelflag() == 1) {
				loginUser = null;
			}
			
		} finally {
			
			db.close(rs, pstmt, conn);
		}

		return loginUser;
	}

	@Override
	public User getUser(String id) throws SQLException {
		User user = new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select id, name, address, phone, delflag, role");
		sql.append(" from user");
		sql.append(" where id = ?");
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				if (rs.getString(3) != null)
					user.setAddress(rs.getString(3));
				if (rs.getString(4) != null)
					user.setPhone(rs.getString(4));
				user.setDelflag(rs.getInt(5));
				user.setRole(rs.getInt(6));
			}
			else
				user = null;
		} finally {
			
			db.close(rs, pstmt, conn);
		}
		
		return user;
	}

	@Override
	public void registry(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into user (id, password, name, address, phone, delflag, role)");
		sql.append(" values (?, ?, ?, ?, ?, ?, ?)");
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			pstmt.setString(i++, user.getId());
			pstmt.setString(i++, user.getPassword());
			pstmt.setString(i++, user.getName());
			pstmt.setString(i++, user.getAddress());
			pstmt.setString(i++, user.getPhone());
			pstmt.setInt(i++, user.getDelflag());
			pstmt.setInt(i++, user.getRole());
			pstmt.executeUpdate();
			
		} finally {
			
			db.close(pstmt, conn);
		}
	}

	@Override
	public void userUpdate(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" update user");
		if (user.getPassword().equals(""))
			sql.append(" set name = ?, address = ?, phone = ?");
		else
			sql.append(" set password = ?, name = ?, address = ?, phone = ?");
		sql.append(" where id = ?");
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			if (!user.getPassword().equals(""))
				pstmt.setString(i++, user.getPassword());
			pstmt.setString(i++, user.getName());
			pstmt.setString(i++, user.getAddress());
			pstmt.setString(i++, user.getPhone());
			pstmt.setString(i++, user.getId());
			pstmt.executeUpdate();
			
		} finally {
			
			db.close(pstmt, conn);
		}
		
	}

	@Override
	public void userDelete(String id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" update user");
		sql.append(" set delflag = ?");
		sql.append(" where id = ?");
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, 1);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		} finally {
			
			db.close(pstmt, conn);
		}
	}

	@Override
	public String getPassword(String id) throws SQLException {
		String password = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select password");
		sql.append(" from user");
		sql.append(" where id = ?");
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				password = rs.getString(1);
			}

		} finally {
			
			db.close(rs, pstmt, conn);
		}
		
		return password;
	}
}
