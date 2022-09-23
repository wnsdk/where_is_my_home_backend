package com.ssafy.backend.notice.dto;

public class Notice {
	private int id;
	private String title;
	private String content;
	private int hit;
	private String writer;
	private String writedate;
	public Notice() {}
	public Notice(int id, String title, String content, int hit, String writer, String writedate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.writer = writer;
		this.writedate = writedate;
	}
	public Notice(String title, String content, int hit, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.writer = writer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", hit=" + hit + ", writer=" + writer
				+ ", writedate=" + writedate + "]";
	}
}
