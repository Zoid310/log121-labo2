package commands;

import views.PerspectiveView;

public interface Command {

	public void execute(PerspectiveView perspective);
	
}
