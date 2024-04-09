package models;

import java.awt.Point;
import java.io.Serializable;

import observer.Subject;


public class PerspectiveModel extends Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	static final double DEFAULT_ZOOM = 1.0;
	public static final double MIN_ZOOM = 0.1;
	
	private String imagePath;
	private double zoom;
	private Point position;
	
	public PerspectiveModel(String cImagePath) {
		this.imagePath = cImagePath;
		this.zoom = DEFAULT_ZOOM;
		this.position = new Point(); // Top left corner for now...
	}

	//#region Getters/Setters

	public String getImagePath() {
        return this.imagePath;
    }

	public void setImagePath(String newImagePath) {
        this.imagePath = newImagePath;
		this.notifyObservers();
    }

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
		this.notifyObservers();
	}

	public double getZoom() {
		return zoom;	
	}

	public void setZoom(double zoom) {
		System.out.println("Zoom actuel : " + this.zoom + ", Nouveau zoom : " + zoom);
        this.zoom = zoom;
        notifyObservers();
    }
	
	//#endregion
	
}
	