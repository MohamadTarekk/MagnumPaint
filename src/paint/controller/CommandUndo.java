package paint.controller;

public class CommandUndo {

	Command command;
	
	public void go(Command newCommand) {
		
		command = newCommand;
		newCommand.undo();
	}
	
}
