package models;

import observer.Subject;

public class PerspectiveModel extends Subject {
	
	private Image image;
	private int zoom;
	private int[] position;
	
	public PerspectiveModel() {
		
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	
	
}
