package paint.controller;

public class CommandUndo {

	Command command;
	
	public CommandUndo(Command newCommand) {
		command = newCommand;
		command.undo();
	}
}
