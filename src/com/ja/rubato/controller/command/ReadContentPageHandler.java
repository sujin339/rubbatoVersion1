package com.ja.rubato.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.rubato.model.BoardDao;
import com.ja.rubato.model.MemberDao;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.ContentDataVo;
import com.ja.rubato.vo.MemberVo;

public class ReadContentPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		BoardVo boardVo = new BoardDao().selectByNo(b_no);
		
		MemberVo memberVo = new MemberDao().selectByNo(boardVo.getM_no());
		
		new BoardDao().updateViewCount(b_no);
		
		ContentDataVo contentDataVo = new ContentDataVo(memberVo, boardVo);
		
		request.setAttribute("contentDataVo", contentDataVo);
		
		
		
		return "WEB-INF/view/read_content_page.jsp";
	}

}
