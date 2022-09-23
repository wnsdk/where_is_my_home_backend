package com.ssafy.backend.user.dao;

import java.sql.SQLException;

import com.ssafy.backend.user.dto.User;

public interface IUserDao {
	User login (User user) throws SQLException;
	User getUser (String id) throws SQLException;
	void registry (User user) throws SQLException;
	void userUpdate (User user) throws SQLException;
	void userDelete (String id) throws SQLException;
	String getPassword(String id) throws SQLException;
}
