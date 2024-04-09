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
	
	public PerspectiveController(PerspectiveView cView) {
        this.view = cView;
        this.model = cView.getModel();
        this.commandManager = CommandManager.getInstance();
    }

    public PerspectiveController(java.awt.Image cImage) {
        //TODO Auto-generated constructor stub
    }

    public void handleZoomIn() {
        double zoomFactor = 1.1; 
        Command zoomIn = new ZoomCommand(zoomFactor, model);
        commandManager.executeCommand(zoomIn);
    }

    public void handleZoomOut() {
        double zoomFactor = 0.9; 
        Command zoomOut = new ZoomCommand(zoomFactor, model);
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