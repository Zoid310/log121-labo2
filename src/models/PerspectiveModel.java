package models;

import java.io.Serializable;

import observer.Subject;


public class PerspectiveModel extends Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	static final double DEFAULT_ZOOM = 1.0;
	
	private String imagePath;
	private double zoom;
	private int[] position;
	
	public PerspectiveModel(String cImagePath) {
		this.imagePath = cImagePath;
		this.zoom = DEFAULT_ZOOM;
		this.position = new int[]{0,0}; // Top left corner for now...
	}

	//#region Getters/Setters

	public String getImagePath() {
        return this.imagePath;
    }

	public void setImagePath(String newImagePath) {
        this.imagePath = newImagePath;
		this.notifyObservers();
    }

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
		this.notifyObservers();
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
		this.notifyObservers();
	}
	
	//#endregion
	
}
