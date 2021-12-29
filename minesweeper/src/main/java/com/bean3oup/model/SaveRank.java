package com.bean3oup.model;

public class SaveRank {
	private String id;
	private String nickname;
	private String time;
	private String level;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "SaveRank [id=" + id + ", nickname=" + nickname + ", time=" + time + ", level=" + level + "]";
	}
}
