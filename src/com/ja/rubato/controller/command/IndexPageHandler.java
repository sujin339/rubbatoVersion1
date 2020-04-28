package com.ja.rubato.controller.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.rubato.model.BoardDao;
import com.ja.rubato.model.MemberDao;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.ContentDataVo;
import com.ja.rubato.vo.MemberVo;

public class IndexPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<BoardVo> mainlist = new BoardDao().selectAll();
		
		request.setAttribute("mainlist", mainlist);

		return "/WEB-INF/view/index.jsp";
	}

}
