package bsu.rfe.group7.lab7.Pavlovich.servlets;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import bsu.rfe.group7.lab7.Pavlovich.entity.ChatMessage;
import bsu.rfe.group7.lab7.Pavlovich.entity.ChatUser;

public class WebChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected HashMap<String, ChatUser> activeUsers;
	protected ArrayList<ChatMessage> messages;
	

}
