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
	private Image image;
	private List<Observer> observers;
	
	public ThumbnailModel(Image cImage) {
		this.image = cImage;
		observers = new ArrayList<>();
	}

	// @Override
    // public void addObserver(Observer o) {
    //     observers.add(o);
    // }

    // @Override
    // public void removeObserver(Observer o) {
    //     observers.remove(o);
    // }

    public ThumbnailModel(ImageIcon imageIcon2) {
	
	}

	@Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
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
	
        notifyObservers(); 
    }
    }



	//#endregion
	

