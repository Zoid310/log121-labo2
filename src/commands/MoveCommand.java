package commands;

import views.PerspectiveView;

import java.awt.Point;

import models.*;
import singleton.CommandManager;


public class MoveCommand implements Command{
	
	private int newX;
	private int newY;
	private PerspectiveView view;


	public MoveCommand(int newX, int newY, PerspectiveView pv){
		this.newX = newX;
		this.newY = newY;
		this.view = pv;
	}


	/*@Override
	public void execute( ) {
		Point newPos = new Point(newX, newY);
		view.getModel().setPosition(newPos);
	}*/

    public void execute() {
      Point currentPosition = view.getModel().getPosition();
      Point newPos = new Point(currentPosition.x - newX, currentPosition.y - newY);
      view.getModel().setPosition(newPos);
    }

	public void undo(){
		Point currentPosition = view.getModel().getPosition();
        Point originalPos = new Point(currentPosition.x + newX, currentPosition.y + newY);
        view.getModel().setPosition(originalPos);
	}

	/*@Override
    public void execute() {
       // Get the current position
       Point currentPosition = view.getModel().getPosition();
       // Adjust deltas according to zoom level for consistency
       int adjustedNewX = (int)(newX / view.getModel().getZoom());
       int adjustedNewY = (int)(newY / view.getModel().getZoom());
       // Calculate the new position
       Point newPos = new Point(currentPosition.x + adjustedNewX, currentPosition.y + adjustedNewY);
       // Update the position in the model
       view.getModel().setPosition(newPos);
    }*/

}

