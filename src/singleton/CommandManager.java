package singleton;

import java.util.Stack;

import commands.*;

public class CommandManager {
	
	private static CommandManager instance = new CommandManager();
	private Stack<Command> commandHistory;
	
	private CommandManager() {
		this.commandHistory = new Stack<Command>();
	}
	
	public static CommandManager getInstance() {
		if (instance==null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public void executeCommand(Command c) {
		commandHistory.push(c);
		c.execute();
	}
	
	public void newCommand(String type) {
		
	}
	
	public void undoCommand() {
		if (!commandHistory.isEmpty()) {
            Command c = commandHistory.pop();
			c.undo();
        }
	}
}
