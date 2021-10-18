package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.tBoard.TBoardDAO;
import model.tBoard.TBoardVO;

public class ActionUpdateTBoard implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		TBoardDAO dao = new TBoardDAO();
		TBoardVO vo = new TBoardVO();

		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int id = Integer.parseInt(request.getParameter("id"));

		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);
		dao.updateTBoard(vo);

		forward.setPath("main.do");
		forward.setRedirect(false);

		return forward;
	}

}
