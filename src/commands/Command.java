package commands;

import models.PerspectiveModel;

public interface Command {

	public void execute();
	public void undo();
}
