package controller;
import models.*;
import views.*;
import singleton.*;
import commands.*;

import java.io.Serializable;

public class PerspectiveController implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private PerspectiveModel model;
    private PerspectiveView view;
    private CommandManager commandManager;
	
	public PerspectiveController(Image cImage) {
        this.model = new PerspectiveModel(cImage);
        this.commandManager = CommandManager.getInstance();
    }

    public PerspectiveController(java.awt.Image cImage) {
        //TODO Auto-generated constructor stub
    }

    public void handleZoomIn() {
        Command zoomIn = new ZoomCommand(1.1, model); 
        commandManager.executeCommand(zoomIn);
    }

    public void handleZoomOut() {
        Command zoomOut = new ZoomCommand(0.9, model); 
        commandManager.executeCommand(zoomOut);
    }

    public void handleSave() {
        Command saveCommand = new SavePerspectiveCommand(model);
        commandManager.executeCommand(saveCommand);
    }

    public void handleTranslate(int dx, int dy) {
        Command move = new MoveCommand(dx, dy, model);
        commandManager.executeCommand(move);
    }

    // Controller provides a way to get its model for the view to observe
    public PerspectiveModel getModel() {
        return model;
    }
	
	public void updatePerspective() {
		
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