package webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.beans.UserAccount;
import webapp.utils.AppUtils;
import webapp.utils.DataDAO;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserAccount userAccount = DataDAO.findUser(userName, password);
		
		if(userAccount == null) {
			String errorMessage = "Invalid user or passwor";
			request.setAttribute("errorMessage", errorMessage);
			
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		
		AppUtils.storeLoginedUser(request.getSession(), userAccount);
		
		int redirectID = -1;
		try {
			redirectID = Integer.parseInt(request.getParameter("redirectID"));
		} catch(Exception e) {
			
		}
		
		String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectID);
		
		if(requestUri != null) {
			response.sendRedirect(requestUri);
		} else {
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}
	
}
