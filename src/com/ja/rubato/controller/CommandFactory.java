package com.ja.rubato.controller;

import java.util.HashMap;

import com.ja.rubato.controller.command.*;


public class CommandFactory {
	
	private HashMap<String, CommandHandler> commandMap;	//내부에서 리턴할 용도로만 쓸거니까 private
	
	public CommandFactory() {
		commandMap = new HashMap<String, CommandHandler>(); 
		
		
		commandMap.put("/index.do", new IndexPageHandler());
		commandMap.put("/login_process.do", new LoginProcessHandler());
		commandMap.put("/join_member_page.do", new JoinMemberPageHandler());
		commandMap.put("/join_member_process.do", new JoinMemberProcessHandler());
		commandMap.put("/logout_process.do", new LogoutProcessHandler());
		commandMap.put("/board_list_page.do", new BoardListPageHandler());
		commandMap.put("/read_content_page.do", new ReadContentPageHandler());
		commandMap.put("/board_write_page.do", new BoardWritePageHandler());
		commandMap.put("/board_write_process.do", new BoardWriteProcessHandler());
		commandMap.put("/move_before_page.do", new MoveBeforePageHandler());
		
		
	}
	
	public CommandHandler getCommandHandler(String command) {
		
		return commandMap.get(command);
	}
	
}
