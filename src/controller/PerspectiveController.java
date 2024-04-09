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
<<<<<<< HEAD
    }

    public void handleSave(String savePath) {
        Command saveCommand = new SavePerspectiveCommand(model, savePath);
        commandManager.executeCommand(saveCommand);
=======
        view.display(); 
>>>>>>> 6215db7f28c3e485874303f6510692f93379acf5
    }

    public void handleTranslate(int dx, int dy) {
        Command move = new MoveCommand(dx, dy, view);
        commandManager.executeCommand(move);
    }

	
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