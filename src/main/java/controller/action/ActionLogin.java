package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;
import model.tMember.TMemberDAO;
import model.tMember.TMemberVO;

public class ActionLogin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		ActionForward forward = null;
		TMemberDAO dao = new TMemberDAO();
		TMemberVO vo = new TMemberVO();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		vo.setId(id);
		vo.setPassword(password);
		
		if(dao.getTMember(vo)==null) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인 실패');history.go(-1)</script>");
				return forward;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		vo = dao.getTMember(vo);
		HttpSession session =request.getSession();
		session.setAttribute("user", vo);
		forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("main.do");
		return forward;
	}

}
