package paint.controller;

public class CommandInvoker {
	
	Command command;
	
	public void go(Command newCommand) {
		
		command = newCommand;
		command.excute();
	}

}
