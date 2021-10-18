package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.tBoard.TBoardDAO;
import model.tBoard.TBoardVO;

public class ActionMain implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		TBoardDAO dao = new TBoardDAO();
		TBoardVO vo = new TBoardVO();
		int page = 1;
		if(request.getParameter("page")!=null && Integer.parseInt(request.getParameter("page"))!=0) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<TBoardVO> tBoardList = dao.getTBoardList(vo,page);
		
		request.setAttribute("tBoardList", tBoardList);
		request.setAttribute("page", page);
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}

}
