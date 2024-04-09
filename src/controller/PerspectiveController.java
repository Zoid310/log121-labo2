package controller;
import models.*;
import views.*;
import singleton.*;
import commands.*;

import java.io.Serializable;

/**
 * Class that controls the perspective view.
 * This class implements the Serializable interface.
 */
public class PerspectiveController implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private PerspectiveView view;
    private CommandManager commandManager;
	
	/**
	 * Constructor for PerspectiveController.
	 * Initializes the view and command manager.
	 * @param cView the perspective view to be controlled
	 */
	public PerspectiveController(PerspectiveView cView) {
        this.view = cView;
        this.commandManager = CommandManager.getInstance();
    }

    /**
     * Handles the zoom in action.
     * Creates a zoom in command and executes it.
     */
    public void handleZoomIn() {
        double zoomFactor = 1.1; 
        Command zoomIn = new ZoomCommand(zoomFactor, view);
        commandManager.executeCommand(zoomIn);
        view.display(); 
    }
    
    /**
     * Handles the zoom out action.
     * Creates a zoom out command and executes it.
     */
    public void handleZoomOut() {
        double zoomFactor = 0.9; 
        Command zoomOut = new ZoomCommand(zoomFactor, view);
        commandManager.executeCommand(zoomOut);
        view.display(); 
    }

    /**
     * Handles the translate action.
     * Creates a move command and executes it.
     * @param dx the change in x-coordinate
     * @param dy the change in y-coordinate
     */
     public void handleTranslate(int dx, int dy) {
        Command move = new MoveCommand(dx, dy, view);
        commandManager.executeCommand(move);
        view.display();
    }

	/**
	 * Updates the perspective view.
	 */
	public void updatePerspective() {
        view.display(); 
	}
}
