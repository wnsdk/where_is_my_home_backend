package com.ssafy.backend.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.backend.notice.dto.Notice;
import com.ssafy.backend.util.DBUtil;

public class NoticeDaoImpl implements INoticeDao {
	
	DBUtil dbutil = DBUtil.getInstance();
	
	@Override
	public boolean addNotice(Notice notice) {
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into notice(title, content, hit, writer) \r\n ");
		sql.append(" values(?,?,0,?) ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=dbutil.getConnection();
			System.out.println(this.getClass()+" addBoard 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			int j=1;
			psmt.setString(j++, notice.getTitle());
			psmt.setString(j++, notice.getContent());
			psmt.setString(j++, notice.getWriter());
			System.out.println(this.getClass()+" addBoard 3/6 S ");
			System.out.println(sql.toString());
			count=psmt.executeUpdate();
			System.out.println(this.getClass()+" addBoard 4/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" addBoard F "+e);
		} finally {
			dbutil.close(psmt, conn);
			System.out.println(this.getClass()+" addBoard 6/6 S ");
		}
		return count>0 ?true:false;
	}

	@Override
	public List<Notice> getNoticeList() {
		List<Notice> notices = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id, title, content, hit, writer, writedate \r\n");
		sql.append("from notice");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=dbutil.getConnection();
			System.out.println(this.getClass()+" getNoticeList 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			System.out.println(this.getClass()+" getNoticeList 3/6 S ");
			System.out.println(sql.toString());
			rs=psmt.executeQuery();
			System.out.println(this.getClass()+" getNoticeList 4/6 S ");
			while(rs.next()) {
				int i=1;
				Notice notice=new Notice(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++)
						);
				notices.add(notice);
			}
			System.out.println(this.getClass()+" getNoticeList 5/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" getNoticeList F ");
			e.printStackTrace();
		} finally {
			dbutil.close(rs, psmt, conn);
			System.out.println(this.getClass()+" getNoticeList 6/6 S ");
		}
		return notices;
	}

	@Override
	public Notice getNotice(int id) {
		Notice notice = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id, title, content, hit, writer, writedate \r\n");
		sql.append("from notice where id=?");
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			conn=dbutil.getConnection();
			System.out.println(this.getClass()+" getNotice 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			System.out.println(this.getClass()+" getNotice 3/6 S ");
			System.out.println(sql.toString());
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			System.out.println(this.getClass()+" getNotice 4/6 S ");
			while(rs.next()) {
				int i=1;
				notice=new Notice(
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getString(i++)
						);
			}
			System.out.println(this.getClass()+" getNotice 5/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" getNotice F ");
			e.printStackTrace();
		} finally {
			dbutil.close(rs, psmt, conn);
			System.out.println(this.getClass()+" getNotice 6/6 S ");
		}
		return notice;
	}

	@Override
	public boolean updateNotice(Notice notice) {
		StringBuilder sql=new StringBuilder();
		sql.append(" update notice set title=?,content=? \r\n ");
		sql.append(" where id=? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=dbutil.getConnection();
			System.out.println(this.getClass()+" updateNotice 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			int j=1;
			psmt.setString(j++, notice.getTitle());
			psmt.setString(j++, notice.getContent());
			psmt.setInt(j++, notice.getId());
			System.out.println(this.getClass()+" updateNotice 3/6 S ");
			System.out.println(sql.toString());
			count=psmt.executeUpdate();
			System.out.println(this.getClass()+" updateNotice 4/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" updateNotice F "+e);
		} finally {
			dbutil.close(psmt, conn);
			System.out.println(this.getClass()+" updateNotice 6/6 S ");
		}
		return count>0 ?true:false;
	}

	@Override
	public boolean deleteNotice(int id) {
		StringBuilder sql=new StringBuilder();
		sql.append(" delete from notice \r\n ");
		sql.append(" where id=? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=dbutil.getConnection();
			System.out.println(this.getClass()+" deleteNotice 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			psmt.setInt(1, id);
			System.out.println(this.getClass()+" deleteNotice 3/6 S ");
			System.out.println(sql.toString());
			count=psmt.executeUpdate();
			System.out.println(this.getClass()+" deleteNotice 4/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" deleteNotice F "+e);
		} finally {
			dbutil.close(psmt, conn);
			System.out.println(this.getClass()+" deleteNotice 6/6 S ");
		}
		return count>0 ?true:false;
	}

	@Override
	public boolean updateHit(int id) {
		StringBuilder sql=new StringBuilder();
		sql.append(" update notice set hit = hit + 1 \r\n ");
		sql.append(" where id=? ");
		Connection conn=null;
		PreparedStatement psmt=null;
		int count=0;
		try {
			conn=dbutil.getConnection();
			System.out.println(this.getClass()+" updateHit 2/6 S ");
			psmt=conn.prepareStatement(sql.toString());
			psmt.setInt(1, id);
			System.out.println(this.getClass()+" updateHit 3/6 S ");
			System.out.println(sql.toString());
			count=psmt.executeUpdate();
			System.out.println(this.getClass()+" updateHit 4/6 S ");
		} catch (SQLException e) {
			System.out.println(this.getClass()+" updateHit F "+e);
		} finally {
			dbutil.close(psmt, conn);
			System.out.println(this.getClass()+" updateHit 6/6 S ");
		}
		return count>0 ?true:false;
	}

}
