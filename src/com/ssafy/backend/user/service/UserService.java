package com.ssafy.backend.user.service;

import java.sql.SQLException;

import com.ssafy.backend.user.dao.IUserDao;
import com.ssafy.backend.user.dao.UserDaoImpl;
import com.ssafy.backend.user.dto.User;

public class UserService {
	
	private IUserDao dao;
	
	private static UserService service = new UserService();
	private UserService() {
		dao = new UserDaoImpl();
	}
	public static UserService getInstance() {
		return service;
	}
	
	public User login(User user) throws SQLException {
		return dao.login(user);
	}

	public User getUser(String id) throws SQLException {
		return dao.getUser(id);
	}

	public void registry(User user) throws SQLException {
		dao.registry(user);
	}
	
	public void userUpdate(User user) throws SQLException {
		dao.userUpdate(user);
	}
	
	public void userDelete(String id) throws SQLException {
		dao.userDelete(id);
	}
	public String getPassword(String id) throws SQLException {
		return dao.getPassword(id);
	}
}
