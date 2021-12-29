package com.bean3oup.model;

public class Board {
	private String idx;
	private String title;
	private String id;
	private String date;
	private String content;
	@Override
	public String toString() {
		return "Board [idx=" + idx + ", title=" + title + ", id=" + id + ", date=" + date + ", content=" + content
				+ "]";
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
