package com.ssafy.backend.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.user.dto.User;
import com.ssafy.backend.user.service.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService service = UserService.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");

		switch (action) {
		case "login":
			doLogin(request, response);
			break;
		case "logout":
			doLogout(request, response);
			break;
		case "registry":
			doRegistry(request, response);
			break;
		case "userinfo":
			doUserInfo(request, response);
			break;
		case "userupdate":
			doUserUpdate(request, response);
			break;
		case "userdelete":
			doUserDelete(request, response);
			break;
		case "findpassword":
			doFindPassword(request, response);
			break;
		}
	}
	
	private void doFindPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("user_id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		User user;
		try {
			user = service.getUser(id);
			System.out.println(user.toString());
			if (user == null || !user.getName().equals(name) || !user.getAddress().equals(email) || user.getDelflag() == 1) {	// 그런 아이디 없음
				request.setAttribute("msg", "아이디 또는 이름 또는 이메일이 잘못되었습니다.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("./find.jsp");
				dispatcher.forward(request, response);
				
			} else {
				request.setAttribute("msg", "비밀번호는 " + service.getPassword(id) + " 입니다.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("./user?action=login");
				dispatcher.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private void doUserDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("loginUser");
			service.userDelete(user.getId());
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void doUserUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setAddress(request.getParameter("address"));
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		user.setId(request.getParameter("user_id"));
		System.out.println(user.toString());
		try {
			service.userUpdate(user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./user?action=userinfo");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void doUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		try {
			User user = service.getUser(loginUser.getId());
			request.setAttribute("user", user);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("./info.jsp");
		dispatcher.forward(request, response);
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = new User();
		user.setId(request.getParameter("user_id"));
		user.setPassword(request.getParameter("password"));
		
		try {
			User loginUser = service.login(user);
			if (loginUser == null) {	// 로그인 실패
				System.out.println("로그인 실패");
				RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
				dispatcher.forward(request, response);
			} else {	// 로그인 성공
				user = service.getUser(loginUser.getId());
				session.setAttribute("loginUser", loginUser);
				request.setAttribute("user", user);
				RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
		dispatcher.forward(request, response);
	}

	private void doRegistry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setId(request.getParameter("user_id"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(request.getParameter("phone"));
		user.setDelflag(0);
		user.setRole(1);
		
		try {
			service.registry(user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
