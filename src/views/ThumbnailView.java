package views;

import models.ThumbnailModel;
import observer.*;

public class ThumbnailView extends JPanel implements Observer {
	
	private ThumbnailModel model;
	
	public ThumbnailView(ThumbnailModel modelInstance) {
		this.model = modelInstance;
		model.add(this);

		setLayout(new BorderLayout());
		imageLabel = new JLabel();
		add(imageLabel, BorderLayout.CENTRE);
	}
	
	public void loadImage() {
		
		//TODO: Calls the controller to load the thumbnail or something else
		
	}
	
	public void display() {

		if (model.getImageIcon() != null) {
            imageLabel.setIcon(model.getImageIcon());
        } else {
            imageLabel.setText("Aucune image disponible");
        }
        revalidate();
        repaint();
    }
	}
	
	public void update(Subject subject) {
		display(); // mise a jour de laffichage
		
	}
}
