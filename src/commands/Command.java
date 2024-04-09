package commands;

import models.PerspectiveModel;

public interface Command {

	public void execute(PerspectiveModel perspective);
	
}
