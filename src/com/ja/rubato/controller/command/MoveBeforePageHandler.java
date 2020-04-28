package com.ja.rubato.controller.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.rubato.model.BoardDao;
import com.ja.rubato.model.MemberDao;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.ContentDataVo;
import com.ja.rubato.vo.MemberVo;

public class MoveBeforePageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		int totalContentCount = new BoardDao().totalContentCount();
		int pageNo = totalContentCount / 10;
		
		if(totalContentCount % 10 >= 1) {
			pageNo++;
		}
		
		
		request.setAttribute("pageNo", pageNo);
		
		//찍어보자
		String selectPage = request.getParameter("currentPage");
		System.out.println(selectPage);
		
		
	//	new BoardDao().beforePage(selectPage);
		
		
		
		
		////////////////
		ArrayList<ContentDataVo> contentList = new ArrayList<ContentDataVo>();
		
		//2. 게시글 셀렉트 담을 거
		ArrayList<BoardVo> boardList = new BoardDao().selectAll();
		
		for(int i = 1; i <= pageNo; i++) {
			//boardList = new BoardDao().selectPage(pageNo);
			boardList = new BoardDao().selectPage(selectPage);
		}
		
		
		
		//3. 밑에서 쓸 거 땡겨서
		MemberDao memberDao = new MemberDao();
		
		//4. board 테이블에 들어있는 데이터 배열에 하나씩 넣자~
		for(BoardVo boardVo : boardList) {
			
			//보드테이블 m_no를 끌어오자.
			MemberVo memberVo =  memberDao.selectByNo(boardVo.getM_no());
			
			//조인~~
			ContentDataVo contenDataVo = new ContentDataVo(memberVo, boardVo);
			
			//추가~
			contentList.add(contenDataVo);
			
		}
		
		request.setAttribute("contentList", contentList);
		
		
		
		
		
		//
		
		
		
		
		return "WEB-INF/view/board_list_page.jsp";
	}

}
