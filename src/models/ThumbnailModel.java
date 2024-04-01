package models;

import javax.swing.ImageIcon;

import observer.Subject;

public class ThumbnailModel extends Subject {
	
	private ImageIcon imageIcon;
	private Image image;
	
	public ThumbnailModel() {
		
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
	
	
}
