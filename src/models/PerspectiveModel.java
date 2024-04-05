package models;

import observer.Subject;

public class PerspectiveModel extends Subject {
	static final double DEFAULT_ZOOM = 1.0;
	
	private Image image;
	private double zoom;
	private int[] position;
	
	public PerspectiveModel(Image cImage) {
		this.image = cImage;
		this.zoom = DEFAULT_ZOOM;
		this.position = new int[]{0,0}; // Top left corner for now...
	}

	//#region Getters/Setters

	public Image getImage() {
        return image;
    }

	public void setImage(Image image) {
        this.image = image;
    }

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
	
	//#endregion
	
}
