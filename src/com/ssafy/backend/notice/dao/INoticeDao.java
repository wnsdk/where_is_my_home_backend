package com.ssafy.backend.notice.dao;

import java.util.List;

import com.ssafy.backend.notice.dto.Notice;

public interface INoticeDao {
	public List<Notice> getNoticeList();
	public Notice getNotice(int id);
	public boolean addNotice(Notice notice);
	public boolean updateNotice(Notice notice);
	public boolean deleteNotice(int id);
	public boolean updateHit(int id);
}
