package bsu.rfe.group7.lab7.Pavlovich.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bsu.rfe.group7.lab7.Pavlovich.entity.ChatUser;


public class LogoutServlet extends WebChatServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String)request.getSession().getAttribute("name");
		if (name!=null) {
			ChatUser aUser = activeUsers.get(name);
			if (aUser.getSessionId().equals((String)request.getSession().getId())) {
				synchronized (activeUsers) {
					activeUsers.remove(name);
				}
				request.getSession().setAttribute("name", null);
				response.addCookie(new Cookie("sessionId", null));
				response.sendRedirect(response.encodeRedirectURL("/chat/"));
			} 
			else {
				response.sendRedirect(response.encodeRedirectURL("/chat/view.htm"));
			}
		} 
		else {
			response.sendRedirect(response.encodeRedirectURL("/chat/view.htm"));
		}
	}

}
