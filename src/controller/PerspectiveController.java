package controller;
import models.*;
import views.*;
import singleton.*;
import commands.*;

import java.io.Serializable;

public class PerspectiveController implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private PerspectiveView view;
    private CommandManager commandManager;
	
	public PerspectiveController(PerspectiveView cView) {
        this.view = cView;
        this.commandManager = CommandManager.getInstance();
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

	
	public void updatePerspective() {

        view.display(); 
		
	}
}