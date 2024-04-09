package commands;

import views.PerspectiveView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import models.*;

public class SavePerspectiveCommand implements Command {

	private PerspectiveModel model;
    private String savePath;

	public SavePerspectiveCommand(PerspectiveModel model, String savePath){
		this.model = model;
        this.savePath = savePath;
	}

	@Override
	public void execute(PerspectiveModel perspective) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath))) {
            oos.writeObject(perspective);
            System.out.println("Perspective saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving perspective: " + e.getMessage());
        }
	}
	
}
