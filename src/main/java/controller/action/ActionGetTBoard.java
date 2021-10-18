package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.tBoard.TBoardDAO;
import model.tBoard.TBoardVO;

public class ActionGetTBoard implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		TBoardDAO dao = new TBoardDAO();
		TBoardVO vo = new TBoardVO();

		int id = Integer.parseInt(request.getParameter("id"));

		vo.setId(id);
		vo = dao.getTBoard(vo);

		request.setAttribute("tBoard", vo);
		forward.setPath("getTBoard.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
