package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name ="LoginService", urlPatterns = {"/LoginService"})
public class LoginService extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username != null && password != null) {
				if (username.equals("paulo") && password.equals("1234")) {
					response.sendRedirect("dashboard.jsp");
				} else {
					out.println("Invalid Username or Password");
				}
			} else {
				out.println("Empty Username or Password");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
