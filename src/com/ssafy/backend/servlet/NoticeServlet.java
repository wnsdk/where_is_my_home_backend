package com.ssafy.backend.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.notice.dto.Notice;
import com.ssafy.backend.notice.service.NoticeService;
import com.ssafy.backend.user.dto.User;

@WebServlet("/notice")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService service = NoticeService.getInstance();

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
		case "list":
			doNoticeList(request, response);
			break;
		case "detail":
			doShowDetail(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "bfwrite":
			doBfWrite(request, response);
			break;
		case "delete":
			doDel(request, response);
			break;
		case "bfupdate":
			doBfUpdate(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		}
	
		
	}

	private void doBfWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if (loginUser == null || loginUser.getRole() != 3) {
			request.setAttribute("msg", "관리자만 글을 작성할 수 있습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./notice?action=list");
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./boardWrite.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	private void doBfUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("notice", service.getNotice(Integer.parseInt(id)));
		RequestDispatcher dispatcher = request.getRequestDispatcher("./boardupdate.jsp");
		dispatcher.forward(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Notice notice = new Notice();
		notice.setId(id);
		notice.setTitle(title);
		notice.setContent(content);
		boolean isS=service.updateNotice(notice);
		if(isS) {
//			request.setAttribute("url","./notice?action=list");
//			request.setAttribute("msg","글쓰기에 성공했습니다.");
//			request.setAttribute("title","글목록");
//			RequestDispatcher dispatch=request.getRequestDispatcher("./success.jsp");
//			dispatch.forward(request, response);
			response.sendRedirect("./notice?action=list");
		}else {
//			request.setAttribute("url","./notice?action=write");
//			request.setAttribute("msg","글쓰기에 실패했습니다.");
//			request.setAttribute("title","글쓰기");
//			RequestDispatcher dispatch=request.getRequestDispatcher("./fail.jsp");
//			dispatch.forward(request, response);
			response.sendRedirect("./notice?action=list");
		}
	}

	private void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean isS=service.deleteNotice(id);
		if(isS) {
//			request.setAttribute("url","./notice?action=list");
//			request.setAttribute("msg","글쓰기에 성공했습니다.");
//			request.setAttribute("title","글목록");
//			RequestDispatcher dispatch=request.getRequestDispatcher("./success.jsp");
//			dispatch.forward(request, response);
			response.sendRedirect("./notice?action=list");
		}else {
//			request.setAttribute("url","./notice?action=write");
//			request.setAttribute("msg","글쓰기에 실패했습니다.");
//			request.setAttribute("title","글쓰기");
//			RequestDispatcher dispatch=request.getRequestDispatcher("./fail.jsp");
//			dispatch.forward(request, response);
			response.sendRedirect("./notice?action=list");
		}
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer=request.getParameter("writer");
		String title=request.getParameter("title");
		String content=request.getParameter("content");

		boolean isS=service.addNotice(new Notice(title, content, 0, writer));
		if(isS) {
//			request.setAttribute("url","./notice?action=list");
//			request.setAttribute("msg","글쓰기에 성공했습니다.");
//			request.setAttribute("title","글목록");
//			RequestDispatcher dispatch=request.getRequestDispatcher("./success.jsp");
//			dispatch.forward(request, response);
			response.sendRedirect("./notice?action=list");
		}else {
//			request.setAttribute("url","./notice?action=write");
//			request.setAttribute("msg","글쓰기에 실패했습니다.");
//			request.setAttribute("title","글쓰기");
//			RequestDispatcher dispatch=request.getRequestDispatcher("./fail.jsp");
//			dispatch.forward(request, response);
			response.sendRedirect("./notice?action=list");
		}
		
	}

	private void doShowDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Notice notice = service.getNotice(Integer.parseInt(id));
		service.updateHit(notice.getId());
		request.setAttribute("notice", notice);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./boarddetail.jsp");
		dispatcher.forward(request, response);
	}

	private void doNoticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("notices", service.getNoticeList());
		RequestDispatcher dispatcher = request.getRequestDispatcher("./boardlist.jsp");
		dispatcher.forward(request, response);
	}

}
