package views;

import controller.PerspectiveController;
import models.PerspectiveModel;
import observer.*;

public class PerspectiveView implements Observer {
	
	private PerspectiveModel model;
	private PerspectiveController controller;
	
	public PerspectiveView(PerspectiveModel modelInstance) {
        this.model = modelInstance;
        this.controller = new PerspectiveController();
	}
	
	public void loadImage() {
		// Calls the controller to load the image
	}
	
	public void display() {
		// TODO
	}
	
	public void update(Subject subject) {
		// TODO
	}
	
}
