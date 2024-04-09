package singleton;

import java.util.Stack;
import commands.*;

/**
 * Singleton class that manages the execution and undoing of commands.
 */
public class CommandManager {
	
	private static CommandManager instance = new CommandManager();
	private Stack<Command> commandHistory;
	
	/**
	 * Private constructor to prevent instantiation.
	 * Initializes the command history stack.
	 */
	private CommandManager() {
		this.commandHistory = new Stack<Command>();
	}
	
	/**
	 * Returns the singleton instance of the CommandManager.
	 * If the instance is null, a new instance is created.
	 * @return the singleton instance of CommandManager
	 */
	public static CommandManager getInstance() {
		if (instance==null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	/**
	 * Executes a command and adds it to the command history stack.
	 * @param c the command to be executed
	 */
	public void executeCommand(Command c) {
		commandHistory.push(c);
		c.execute();
	}
	
	/**
	 * Undoes the last command in the command history stack.
	 * If the stack is empty, no action is taken.
	 */
	public void undoCommand() {
		if (!commandHistory.isEmpty()) {
            Command c = commandHistory.pop();
			c.undo();
        }
	}
}
