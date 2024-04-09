package commands;

import views.PerspectiveView;

import java.awt.Point;

import models.*;

public class MoveCommand implements Command{
	
	private int newX;
	private int newY;
	private PerspectiveView view;

	public MoveCommand(int newX, int newY, PerspectiveView pv){
		this.newX = newX;
		this.newY = newY;
		this.view = pv;
	}
	
	@Override
<<<<<<< HEAD
	public void execute(PerspectiveModel perspective) {
		
=======
	public void execute( ) {
		Point newPos = new Point(newX, newY);
		view.getModel().setPosition(newPos);
>>>>>>> 6215db7f28c3e485874303f6510692f93379acf5
	}
	
}

