package bsu.rfe.group7.lab7.Pavlovich.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bsu.rfe.group7.lab7.Pavlovich.entity.ChatMessage;

public class MessageListServlet extends WebChatServlet {
	private static final long serialVersionUID = 1L;

    public MessageListServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf8");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><meta http-equiv='Content-Type'content='text/html;"+
		" charset=utf-8'/> <meta http-equiv='refresh'content='10'></head>");
		pw.println("<body>");
		for (int i=messages.size()-1; i>=0; i--) {
			ChatMessage aMessage = messages.get(i);
			pw.println("<div><strong>" + aMessage.getAuthor().getName() +
			"</strong>: " + aMessage.getMessage() + "</div>");
		} 
		pw.println("</body></html>");
	}

}
