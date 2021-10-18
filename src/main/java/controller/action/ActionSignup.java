package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.tMember.TMemberDAO;
import model.tMember.TMemberVO;

public class ActionSignup implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		ActionForward forward = new ActionForward();
		TMemberDAO dao = new TMemberDAO();
		TMemberVO vo = new TMemberVO();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		vo.setName(name);
		vo.setId(id);
		vo.setPassword(password);
		
		if(!dao.insertTMember(vo)) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('존재하는 아이디!');history.go(-1)</script>");
				return forward;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		forward.setRedirect(false);
		forward.setPath("index.jsp");
		
		return forward;
	}

}
