package com.ja.rubato.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.rubato.controller.*;
import com.ja.rubato.controller.command.*;

/**
 * Servlet implementation class ControllerUsingURI
 */
//@WebServlet("/ControllerUsingURI")	web.xml에서 처리할거면 이 라인 지워야한다.
public class ControllerUsingURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//복붙!
	private CommandFactory commandFactory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUsingURI() {
        super();
        
        //팩토리 생성
        commandFactory = new CommandFactory();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()); 이건 빼야함
		
		
		String command = request.getRequestURI();
		
		
			command = command.substring(request.getContextPath().length());	
			System.out.println(command);
			System.out.println();
			

			CommandHandler handler = commandFactory.getCommandHandler(command);
			
			String view = null;
			
			if(handler != null) {
				view = handler.process(request, response);		
			}else {
				System.out.println("[경고] 명령어에 매핑된 객체가 없습니다.");
			}
			
			//뷰 2가지 경우 : 리다이렉트 있는 거, 없는 거
			if(view != null) {
				if(view.startsWith("redirect:")) {	//startWith : 문자열의 시작이 이거냐하는 API
					
					view = view.substring("redirect:".length());	//문자열 안짜르고 그냥 넣으면 진짜 url에 redirect 붙여버림.
					response.sendRedirect(view);
					
				}else {		//리다이렉트 없으면 포워딩으로!
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
					
				}
			}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
