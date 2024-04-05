package models;

import javax.swing.ImageIcon;

import observer.Subject;

public class ThumbnailModel extends Subject {
	
	private ImageIcon imageIcon;
	private Image image;
	
	public ThumbnailModel(Image cImage) {
		this.image = cImage;
	}

	//#region Getters/Setters

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
	
	public Image getImage(){
		return this.image;
	}

	public void setImage(Image cImage) {
        this.image = cImage;
    }

	//#endregion
	
}
