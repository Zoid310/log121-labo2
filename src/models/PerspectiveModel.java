package models;

import java.awt.Point;
import java.io.Serializable;

import observer.Subject;


public class PerspectiveModel extends Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	static final double DEFAULT_ZOOM = 1.0;
	
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
<<<<<<< HEAD
<<<<<<< HEAD
		this.zoom = zoom;
		this.notifyObservers();
	}
=======
=======

		System.out.println("Zoom actuel : " + this.zoom + ", Nouveau zoom : " + zoom);
>>>>>>> 6215db7f28c3e485874303f6510692f93379acf5
        this.zoom = zoom;
        notifyObservers();
    }
>>>>>>> 820bcfa4e8fec9c3b0aa119eda3dbd32c0b400ca
	
	//#endregion
	
}
	