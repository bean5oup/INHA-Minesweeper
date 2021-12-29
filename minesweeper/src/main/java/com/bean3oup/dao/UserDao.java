package com.bean3oup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean3oup.model.Board;
import com.bean3oup.model.SaveRank;
import com.bean3oup.model.User;
import com.bean3oup.util.DBUtil;

public class UserDao {
	
	private SqlSession sqlSession;
	
	public UserDao() {
		sqlSession = DBUtil.getSqlSession();
	}
	
	public void addUser(User dto) {
		sqlSession.insert("UserMapper.addUser", dto);
		sqlSession.commit();
	}
	
	public User loginUser(User dto) {
		return sqlSession.selectOne("UserMapper.loginUser", dto);
	}
	
	public void updateUser(User dto) {
		sqlSession.update("UserMapper.updateUser", dto);
		sqlSession.commit();
	}
	
	public void deleteUser(String id) {
		sqlSession.delete("UserMapper.deleteUser", id);
		sqlSession.commit();
	}
	
	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		
		List<User> rs = sqlSession.selectList("UserMapper.getAllUsers");
		for (int i = 0; i < rs.size(); i++) {
			User user = new User();
			user.setId(rs.get(i).getId());
			user.setPw(rs.get(i).getPw());
			user.setNickname(rs.get(i).getNickname());
			user.setMail(rs.get(i).getMail());
			users.add(user);
		}

		return users;
	}
	
	public void addRank(SaveRank dto) {
		sqlSession.insert("UserMapper.addRank", dto);
		sqlSession.commit();
	}
	
	public List<SaveRank> getLevelRanks(int level) throws SQLException {
		List<SaveRank> ranks = new ArrayList<SaveRank>();
		List<SaveRank> rs;
		if(level == 1) {
			rs = sqlSession.selectList("UserMapper.getLevel1Ranks");
		}
		else if(level == 2) {
			rs = sqlSession.selectList("UserMapper.getLevel2Ranks");
		}
		else {
			rs = sqlSession.selectList("UserMapper.getLevel3Ranks");
		}
		for (int i = 0; i < rs.size(); i++) {
			SaveRank rank = new SaveRank();
			rank.setId(rs.get(i).getId());
			rank.setNickname(rs.get(i).getNickname());
			rank.setTime(rs.get(i).getTime());
			ranks.add(rank);
		}
		return ranks;
	}
	
	public void addBoard(Board dto) {
		sqlSession.insert("UserMapper.addBoard", dto);
		sqlSession.commit();
	}
	
	public List<Board> getBoardList() {
		List<Board> boards = new ArrayList<Board>();
		List<Board> rs = sqlSession.selectList("UserMapper.getBoardList");
		for (int i = 0; i < rs.size(); i++) {
			Board board = new Board();
			board.setIdx(rs.get(i).getIdx());
			board.setTitle(rs.get(i).getTitle());
			board.setId(rs.get(i).getId());
			board.setDate(rs.get(i).getDate());
			boards.add(board);
		}
		return boards;
	}
	
	public Board boardDetail(Board dto) {
		return sqlSession.selectOne("UserMapper.boardDetail", dto);
	}
	
	public void updateBoard(Board dto) {
		sqlSession.update("UserMapper.updateBoard", dto);
		sqlSession.commit();
	}
	
	public void deleteBoard(Board dto) {
		sqlSession.delete("UserMapper.deleteBoard", dto);
		sqlSession.commit();
	}
}
