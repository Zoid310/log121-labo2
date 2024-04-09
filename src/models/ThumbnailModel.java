package models;

import java.io.Serializable;

import javax.swing.ImageIcon;

import observer.Subject;
import observer.Observer;
import java.util.ArrayList;

import java.util.List;

public class ThumbnailModel extends Subject implements Serializable {

	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon;
	private String imagePath;
	private List<Observer> observers;

	public ThumbnailModel(String imagePath) {
		this.imagePath = imagePath;
	}

	// @Override
	// public void addObserver(Observer o) {
	// observers.add(o);
	// }

	// @Override
	// public void removeObserver(Observer o) {
	// observers.remove(o);
	// }

	public ThumbnailModel(ImageIcon imageIcon2) {
		this.imageIcon = imageIcon2;
	}

	// #region Getters/Setters

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String newImagePath) {
		this.imagePath = newImagePath;
		notifyObservers(); 
	}
	
}

// #endregion
