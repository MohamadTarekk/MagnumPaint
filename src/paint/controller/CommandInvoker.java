package paint.controller;

public class CommandInvoker {
	
	Command command;
	
	public CommandInvoker(Command newCommand) {
		command = newCommand;
		command.excute();
	}

}
