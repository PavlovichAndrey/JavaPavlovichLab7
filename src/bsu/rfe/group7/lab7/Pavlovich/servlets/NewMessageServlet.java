package bsu.rfe.group7.lab7.Pavlovich.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bsu.rfe.group7.lab7.Pavlovich.entity.ChatMessage;
import bsu.rfe.group7.lab7.Pavlovich.entity.ChatUser;

public class NewMessageServlet extends WebChatServlet {
	private static final long serialVersionUID = 1L;

    public NewMessageServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String message = (String)request.getParameter("message");
		if (message!=null && !"".equals(message)) {
			ChatUser author = activeUsers.get((String)
			request.getSession().getAttribute("name"));
			synchronized (messages) {
				messages.add(new ChatMessage(message, author,Calendar.getInstance().getTimeInMillis()));
			}
		}
		response.sendRedirect("/chat/compose_message.htm");
	}

}
