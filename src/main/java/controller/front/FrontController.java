package controller.front;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionDeleteTBoard;
import controller.action.ActionGetTBoard;
import controller.action.ActionInsertTBoard;
import controller.action.ActionLogin;
import controller.action.ActionLogout;
import controller.action.ActionMain;
import controller.action.ActionSignup;
import controller.action.ActionUpdateTBoard;
import controller.common.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String action=uri.substring(cp.length());
		ActionForward forward=null;
		
		if(action.equals("/login.do")) {
			forward = new ActionLogin().execute(request, response);
		}
		else if(action.equals("/logout.do")) {
			forward = new ActionLogout().execute(request, response);
		}
		else if(action.equals("/signup.do")) {
			forward = new ActionSignup().execute(request, response);
		}
		else if(action.equals("/insertTBoard.do")) {
			forward = new ActionInsertTBoard().execute(request, response);
		}
		else if(action.equals("/updateTBoard.do")) {
			forward = new ActionUpdateTBoard().execute(request, response);
		}
		else if(action.equals("/deleteTBoard.do")) {
			forward = new ActionDeleteTBoard().execute(request, response);
		}
		else if(action.equals("/getTBoard.do")) {
			forward = new ActionGetTBoard().execute(request, response);
		}
		else if(action.equals("/main.do")) {
			forward = new ActionMain().execute(request, response);
		}
		else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("index.jsp");
		}
		
		if (forward == null) {
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
		dispatcher.forward(request, response);
	}
}
