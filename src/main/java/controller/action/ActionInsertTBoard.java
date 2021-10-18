package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.tBoard.TBoardDAO;
import model.tBoard.TBoardVO;

public class ActionInsertTBoard implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		TBoardDAO dao = new TBoardDAO();
		TBoardVO vo = new TBoardVO();

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		dao.insertTBoard(vo);

		forward.setPath("main.do");
		forward.setRedirect(false);

		return forward;
	}

}
