package views;

import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import models.ThumbnailModel;
import observer.*;

public class ThumbnailView extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	private ThumbnailModel model;
	private JLabel imageLabel;
	
	public ThumbnailView(ThumbnailModel modelInstance) {
		super();
		this.model = modelInstance;
		model.add(this);


	}
	
	public void loadImage() {
		
		//TODO: Calls the controller to load the thumbnail or something else
		
	}
	
	public void display() {


        revalidate();
        repaint();
    }
	
	public void update(Subject subject) {
		display(); // mise a jour de laffichage
		
	}
}
