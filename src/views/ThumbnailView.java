package views;

import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import models.ThumbnailModel;


import observer.Observer;
import observer.Subject;

public class ThumbnailView extends JPanel implements Observer {
		
    private ThumbnailModel model;	
    private JLabel imageLabel;
	
    public ThumbnailView(ThumbnailModel model) {
        this.model = model;

        imageLabel = new JLabel();
        add(imageLabel);
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

    
	
	@Override
public void update(Subject subject) {
    if (subject instanceof ThumbnailModel) {
        ThumbnailModel model = (ThumbnailModel) subject;
       
        if (model.getImageIcon() != null) {
            imageLabel.setIcon(model.getImageIcon());
        } else {
            imageLabel.setText("Aucune image disponible");
        }
        revalidate();
        repaint();
    }
}

	
}
