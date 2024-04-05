package views;

import models.ThumbnailModel;
import observer.*;

public class ThumbnailView implements Observer {
	
	private ThumbnailModel model;
	
	public ThumbnailView(ThumbnailModel modelInstance) {
		this.model = modelInstance;
	}
	
	public void loadImage() {
		//TODO: Calls the controller to load the thumbnail or something else
	}
	
	public void display() {
		//TODO
	}
	
	public void update(Subject subject) {
		//TODO
	}
}
