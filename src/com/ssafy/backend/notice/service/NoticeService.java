package com.ssafy.backend.notice.service;

import java.util.List;

import com.ssafy.backend.notice.dao.INoticeDao;
import com.ssafy.backend.notice.dao.NoticeDaoImpl;
import com.ssafy.backend.notice.dto.Notice;

public class NoticeService {
	
	private static NoticeService service = new NoticeService();
	
	public static NoticeService getInstance() {
		return service;
	}
	
	private INoticeDao ndao;
	private NoticeService() {
		ndao = new NoticeDaoImpl();
	}

	public boolean addNotice(Notice notice) {
		return ndao.addNotice(notice);
	}

	public List<Notice> getNoticeList() {
		return ndao.getNoticeList();
	}

	public Notice getNotice(int id) {
		return ndao.getNotice(id);
	}

	public boolean updateNotice(Notice notice) {
		return ndao.updateNotice(notice);
	}

	public boolean deleteNotice(int id) {
		return ndao.deleteNotice(id);
	}

	public boolean updateHit(int id) {
		return ndao.updateHit(id);
	}
}
