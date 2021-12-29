package com.bean3oup.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean3oup.dao.UserDao;
import com.bean3oup.model.Board;
import com.bean3oup.model.SaveRank;
import com.bean3oup.model.User;

@WebServlet(urlPatterns = { "/UserController", "/UserLogin", "/UserLogout", "/UserUpdate", "/DeleteUser",
		"/ProcessAdmin", "/ProcessTime", "/ProcessRank", "/ProcessBoard", "/ProcessboardAdd", "/AddBoard",
		"/ProcessBoardDetail", "/DeleteBoard", "/UpdateBoard"})
//@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao;

	public UserController() {
		this.userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getRequestURI().equals("/minesweeper/UserLogout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		} else if (request.getRequestURI().equals("/minesweeper/DeleteUser")) {
			HttpSession session = request.getSession();

			System.out.println(session.getAttribute("sessionId").toString());
			System.out.println(request.getParameter("userId"));

			if (session.getAttribute("sessionId").toString().equals("root")) {
				try {
					userDao.deleteUser(request.getParameter("userId"));
					List<User> users = userDao.getAllUsers();

					RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
					request.setAttribute("users", users);
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {

				try {
					userDao.deleteUser(session.getAttribute("sessionId").toString());

					session.invalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}

				RequestDispatcher view = request.getRequestDispatcher("index.jsp");
				view.forward(request, response);
			}
		} else if (request.getRequestURI().equals("/minesweeper/ProcessAdmin")) {
			try {
				List<User> users = userDao.getAllUsers();

				RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
				request.setAttribute("users", users);
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getRequestURI().equals("/minesweeper/ProcessRank")) {
			try {
				List<SaveRank> level1s = userDao.getLevelRanks(1);
				List<SaveRank> level2s = userDao.getLevelRanks(2);
				List<SaveRank> level3s = userDao.getLevelRanks(3);

				RequestDispatcher view = request.getRequestDispatcher("rank.jsp");
				request.setAttribute("level1s", level1s);
				request.setAttribute("level2s", level2s);
				request.setAttribute("level3s", level3s);
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getRequestURI().equals("/minesweeper/ProcessBoard")) {
			try {
				List<Board> boards = userDao.getBoardList();

				RequestDispatcher view = request.getRequestDispatcher("board.jsp");
				request.setAttribute("boards", boards);
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (request.getRequestURI().equals("/minesweeper/ProcessboardAdd")) {
			try {
				HttpSession session = request.getSession();
				String msg = "";
				RequestDispatcher view = request.getRequestDispatcher("board.jsp");
				if (session.getAttribute("sessionId") == null) {
					view = request.getRequestDispatcher("board.jsp");
					msg = "로그인이 필요한 서비스입니다.";
				} else
					view = request.getRequestDispatcher("boardAdd.jsp");
				request.setAttribute("msg", msg);
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (request.getRequestURI().equals("/minesweeper/ProcessBoardDetail")) {
			try {
				HttpSession session = request.getSession();
				String idx = request.getParameter("idx");
				String error = request.getParameter("error");
				Board dto = new Board();
				dto.setIdx(idx);
				dto = userDao.boardDetail(dto);
				
				String msg = "";
				if(error != null) {
					if(error.equals("1")) {
						msg = "로그인이 필요한 서비스입니다.";
					}
					else if(error.equals("2")) {
						msg = "관리자 또는 글 작성자가 아닙니다.";
					}
				}

				request.setAttribute("msg", msg);
				request.setAttribute("board", dto);
				
				RequestDispatcher view = request.getRequestDispatcher("boardDetail.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().equals("/minesweeper/UserController")) {
			User dto = new User();
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			dto.setNickname(request.getParameter("nickname"));
			dto.setMail(request.getParameter("mail"));
			
			try {
				userDao.addUser(dto);
			} catch(Exception e) {
				String msg = "이미 존재하는 ID입니다.";
				RequestDispatcher view = request.getRequestDispatcher("join.jsp");
				request.setAttribute("msg", msg);
				view.forward(request, response);
				return;
			}
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
		else if(request.getRequestURI().equals("/minesweeper/UserLogin")) {
			String msg = "";
			User dto = new User();
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			try {
				HttpSession session = request.getSession();
				User login = userDao.loginUser(dto);
				if(login != null) {
					session.setAttribute("sessionId", login.getId());
					session.setAttribute("sessionNickname", login.getNickname());
					session.setAttribute("sessionMail", login.getMail());
					
					RequestDispatcher view = request.getRequestDispatcher("index.jsp");
					view.forward(request, response);
					return;
				}
				else {
					msg = "error";
				}
			} catch(Exception e) { 
				e.printStackTrace(); 
			}
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			request.setAttribute("msg", msg);
			view.forward(request, response);
		}
		else if(request.getRequestURI().equals("/minesweeper/UserUpdate")) {
			try {
				User dto = new User();
				dto.setId(request.getParameter("id"));
				dto.setPw(request.getParameter("pw"));
				dto.setNickname(request.getParameter("nickname"));
				dto.setMail(request.getParameter("mail"));
				userDao.updateUser(dto);
				HttpSession session = request.getSession();
				User login = userDao.loginUser(dto);
				if(login != null) {
					session.setAttribute("sessionId", login.getId());
					session.setAttribute("sessionNickname", login.getNickname());
					session.setAttribute("sessionMail", login.getMail());
				}
			} catch(Exception e) { 
				e.printStackTrace(); 
			}
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
			return;
		}
		else if(request.getRequestURI().equals("/minesweeper/ProcessTime")) {
			HttpSession session = request.getSession();
			String level = request.getParameter("level");
			if(session.getAttribute("sessionId") != null) {
				String time = request.getParameter("time");
				try {
					SaveRank dto = new SaveRank();
					dto.setId(session.getAttribute("sessionId").toString());
					dto.setNickname(session.getAttribute("sessionNickname").toString());
					dto.setTime(time);
					dto.setLevel(level);
					userDao.addRank(dto);

					System.out.println(level);
					System.out.println(time);
				} catch(Exception e) { 
					e.printStackTrace(); 
				}
				response.sendRedirect("game.jsp?level="+level);
				return;
			}
			response.sendRedirect("game.jsp?level="+level);
			return;
		}
		else if(request.getRequestURI().equals("/minesweeper/AddBoard")) {
			HttpSession session = request.getSession();
			if(session.getAttribute("sessionId") != null) {
				String title = request.getParameter("title");
				Date date = new Date();
				String content = request.getParameter("content");

				try { Board dto = new Board(); dto.setTitle(title);
				dto.setId(session.getAttribute("sessionId").toString());
				dto.setDate(date.toString()); 
				dto.setContent(content); 
				
				userDao.addBoard(dto);
				} catch(Exception e) { e.printStackTrace(); }
				response.sendRedirect("/minesweeper/ProcessBoard"); 
				return;
			}
			response.sendRedirect("/minesweeper/ProcessBoard");
			return;
		}
		else if (request.getRequestURI().equals("/minesweeper/UpdateBoard")) {
			try {
				HttpSession session = request.getSession();
				String msg = "";
				String idx = request.getParameter("idx");
				
				Board target = new Board();
				target.setIdx(idx);
				target = userDao.boardDetail(target);
				
				if (session.getAttribute("sessionId") == null) {
					msg = "1";
				} 
				else if(target.getId().equals(session.getAttribute("sessionId")) || session.getAttribute("sessionId").equals("root")) {
					target.setContent(request.getParameter("content"));
					target.setTitle(request.getParameter("title"));
					
					userDao.updateBoard(target);	
				}
				else {
					msg = "2";
				}
				
				response.sendRedirect("/minesweeper/ProcessBoardDetail?idx="+idx+"&&error="+msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (request.getRequestURI().equals("/minesweeper/DeleteBoard")) {
			try {
				HttpSession session = request.getSession();
				String msg = "";
				String idx = request.getParameter("idx");
				
				Board target = new Board();
				target.setIdx(idx);
				target = userDao.boardDetail(target);
				
				if (session.getAttribute("sessionId") == null) {
					msg = "1";
				} 
				else if(target.getId().equals(session.getAttribute("sessionId")) || session.getAttribute("sessionId").equals("root")) {
					target.setContent(request.getParameter("content"));
					target.setTitle(request.getParameter("title"));
					
					userDao.deleteBoard(target);	
				}
				else {
					msg = "2";
				}
				
				response.sendRedirect("/minesweeper/ProcessBoardDetail?idx="+idx+"&&error="+msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
