package controller;
import models.*;
import views.*;
import singleton.*;
import commands.*;
import javafx.scene.effect.Light.Point;

import java.io.Serializable;

public class PerspectiveController implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private PerspectiveView view;
    private CommandManager commandManager;
	
	public PerspectiveController(PerspectiveView cView) {
        this.view = cView;
        this.commandManager = CommandManager.getInstance();
    }

    public PerspectiveController(java.awt.Image cImage) {
        //TODO Auto-generated constructor stub
    }

    public void handleZoomIn() {
        double zoomFactor = 1.1; 
        Command zoomIn = new ZoomCommand(zoomFactor, view);
        commandManager.executeCommand(zoomIn);
        view.display(); 
    }
    
    public void handleZoomOut() {
        double zoomFactor = 0.9; 
        Command zoomOut = new ZoomCommand(zoomFactor, view);
        commandManager.executeCommand(zoomOut);
        view.display(); 
    }

     public void handleTranslate(int dx, int dy) {
        Command move = new MoveCommand(dx, dy, view);
        commandManager.executeCommand(move);
        view.display();
    }

   /* public void handleTranslate(int dx, int dy) {
        java.awt.Point currentPos = view.getModel().getPosition();
        // Apply the delta to the current position
        java.awt.Point newPos = new java.awt.Point(currentPos.x + dx, currentPos.y + dy);
        view.getModel().setPosition(newPos);
        view.display(); // Ensure the view is updated after translation
    }*/

	
	public void updatePerspective() {

        view.display(); 
		
	}

    

	//pas sure
	/*public void undo() {
        commandManager.undoCommand();
        view.update();
    }

    public void redo() {
        commandManager.redoCommand();
        view.update();
    }*/
}